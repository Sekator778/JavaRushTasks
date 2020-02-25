public class ChainOfResponsibility {
    public static void main(String[] args) {
        MessagePrinter messagePrinter = new ConsoleMessagePrinter();
        FileMessagePrinter fileMessagePrinter = new FileMessagePrinter();
        messagePrinter.setNextMessagePrinter(fileMessagePrinter);
        fileMessagePrinter.setNextMessagePrinter(new DbMessagePrinter());
        messagePrinter.print("hello world !!");

    }
}
//**chain of responsibility
abstract class MessagePrinter {
    MessagePrinter nextMessagePrinter;

    public void setNextMessagePrinter(MessagePrinter nextMessagePrinter) {
        this.nextMessagePrinter = nextMessagePrinter;
    }
    public void print (String message) {
        printMessage(message);
        if (nextMessagePrinter != null) {
            nextMessagePrinter.print(message);
        }
    }
    abstract void printMessage(String message);         // его реализацию у каждого можем желать свою
    }
//**chain of responsibility

class ConsoleMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print to console: " + message);

    }
}

class FileMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print to file: " + message);

    }
}

class DbMessagePrinter extends MessagePrinter{
    @Override
    void printMessage(String message) {
        System.out.println("print to db: " + message);

    }
}