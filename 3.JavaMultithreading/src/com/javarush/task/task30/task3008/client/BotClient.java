package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class BotClient extends Client {

    @Override
    protected String getUserName() {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    public class BotSocketThread extends SocketThread {
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (message != null && message.contains(":")) {
                String[] nameAndText = message.split(": ");
                Date date = Calendar.getInstance().getTime();
                SimpleDateFormat format = new SimpleDateFormat();
                if (message.contains(": ")) {
                    switch (nameAndText[1].trim()) {
                        case "дата":
                            format.applyPattern("d.MM.YYYY");
                            sendTextMessage(String.format("Информация для %s: %s", nameAndText[0], format.format(date)));
                            break;
                        case "день":
                            format.applyPattern("d");
                            sendTextMessage(String.format("Информация для %s: %s", nameAndText[0], format.format(date)));
                            break;
                        case "месяц":
                            format.applyPattern("MMMM");
                            sendTextMessage(String.format("Информация для %s: %s", nameAndText[0], format.format(date)));
                            break;
                        case "год":
                            format.applyPattern("YYYY");
                            sendTextMessage(String.format("Информация для %s: %s", nameAndText[0], format.format(date)));
                            break;
                        case "время":
                            format.applyPattern("H:mm:ss");
                            sendTextMessage(String.format("Информация для %s: %s", nameAndText[0], format.format(date)));
                            break;
                        case "час":
                            format.applyPattern("H");
                            sendTextMessage(String.format("Информация для %s: %s", nameAndText[0], format.format(date)));
                            break;
                        case "минуты":
                            format.applyPattern("m");
                            sendTextMessage(String.format("Информация для %s: %s", nameAndText[0], format.format(date)));
                            break;
                        case "секунды":
                            format.applyPattern("s");
                            sendTextMessage(String.format("Информация для %s: %s", nameAndText[0], format.format(date)));
                            break;
                        case "Sekator":
                            sendTextMessage("Да мой повелитель я сделаю все что прикажете");
                            break;

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }
}