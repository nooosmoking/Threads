package ex00;

public class EggThread extends Thread{
    private final int outCount;
    public EggThread(int count)  {
        super();
        outCount = count;
    }
    public void run() {
        for (int i = 0; i < outCount; i++) {
            System.out.println("Egg");
        }
    }
}
