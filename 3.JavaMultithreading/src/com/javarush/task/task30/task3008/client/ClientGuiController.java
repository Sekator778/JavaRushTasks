package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client {
    private ClientGuiModel model = new ClientGuiModel();
    private ClientGuiView view = new ClientGuiView(this);

    public ClientGuiModel getModel() {
        return model;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    @Override
    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }

    @Override
    protected String getServerAddress() {
        return view.getServerAddress();
    }

    @Override
    protected int getServerPort() {
        return view.getServerPort();
    }

    @Override
    protected String getUserName() {
        return view.getUserName();
    }

    public class GuiSocketThread extends SocketThread {
        @Override
        protected void processIncomingMessage(String message) {
            super.processIncomingMessage(message);
            model.setNewMessage(message);
            view.refreshMessages();
        }

        @Override
        protected void informAboutAddingNewUser(String userName) {
            super.informAboutAddingNewUser(userName);
            model.addUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void informAboutDeletingNewUser(String userName) {
            super.informAboutDeletingNewUser(userName);
            model.deleteUser(userName);
            view.refreshUsers();
        }

        @Override
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            super.notifyConnectionStatusChanged(clientConnected);
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    public static void main(String[] args) {
        new ClientGuiController().run();
    }


}
