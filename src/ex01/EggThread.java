package ex01;

public class EggThread extends Thread{
    private final int outCount;
    private Printer printer;
    public EggThread(int count, Printer printer)  {
        super();
        this.outCount = count;
        this.printer = printer;
    }
    public void run() {
        for (int i = 0; i < outCount; i++) {
            printer.print("Egg");
        }
    }
}
