package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    private static class Handler extends Thread {
        Socket socket;

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Connection with " + socket.getRemoteSocketAddress() + " has been established");
            String userName = "";
            socket.getRemoteSocketAddress();
            try (Connection connection = new Connection(socket)) {
                userName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, userName));
                notifyUsers(connection, userName);
                serverMainLoop(connection, userName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Error type " + e.getMessage());
            } finally {
                connectionMap.remove(userName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, userName));
            }
            ConsoleHelper.writeMessage("Connection with server has been closed");

        }

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                Message receiveMessage = connection.receive();
                String name = receiveMessage.getData();
                if (receiveMessage == null || name == null || name.equals("") || connectionMap.containsKey(name)) {
                    continue;
                }
                connectionMap.put(name, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                return name;
            }
        }

        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                if (!pair.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String answer = userName + ": " + message.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, answer));
                } else ConsoleHelper.writeMessage("Message is not a text");
            }

        }
    }

    public static void sendBroadcastMessage(Message message) {
        try {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                pair.getValue().send(message);
            }
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Failed to send message.");
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("input port id");
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(port);
        ConsoleHelper.writeMessage("Server is UP");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                new Handler(socket).start();

            } catch (Exception e) {
                serverSocket.close();
                ConsoleHelper.writeMessage(e.getMessage());
                break;
            }
        }
    }
}
