package ex00;

public class HegThread extends Thread {
    private final int outCount;
    public HegThread(int count)  {
        super();
        outCount = count;
    }
    public void run() {
        for (int i = 0; i < outCount; i++) {
            System.out.println("Heg");
        }
    }
}
