public class Decorator {
    public static void main(String[] args) {
        FileStream fileStream = new FileBufferReader(new FileStreamReader());
        fileStream.read();
        FileStreamReader fileStreamReader = new FileStreamReader();
        fileStreamReader.read();
    }
}


interface FileStream {
    void read();
}

class FileStreamReader implements FileStream {
    @Override
    public void read() {
        System.out.println("read file");
    }
}

abstract class FileDecorator implements FileStream {
    FileStream fileDecorator;

    public FileDecorator(FileStream fileDecorator) {
        this.fileDecorator = fileDecorator;
    }
    public abstract void read();
}

class FileBufferReader extends FileDecorator {
    public FileBufferReader(FileStream fileDecorator) {
        super(fileDecorator);
    }

    @Override
    public void read() {
        fileDecorator.read();
        System.out.println("buffered read");
    }
}