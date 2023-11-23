package ex02;

import java.util.ArrayList;
import java.util.Random;

public class SumArray extends ArrayList<Integer> {
    private final SumBuffer buffer = new SumBuffer();

    public SumArray(int size) {
        super();
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            this.add(rand.nextInt(2001) - 1001);
        }
    }

    public int sumStandart() {
        int sum = 0;
        for (int num : this) {
            sum += num;
        }
        return sum;
    }

    public int sumThreads(int threadsCount) {
        SumBuffer buffer = new SumBuffer();
        int sizeThread = this.size() / threadsCount;
        int last = this.size() - (threadsCount * sizeThread);
        int startIndex = 0, finishIndex = sizeThread;
        SumThread[] threadsArray = new SumThread[threadsCount];
        for (int i = 0; i < threadsCount; i++) {
            if (i == threadsCount - 1)
                finishIndex += last;
            threadsArray[i] = new SumThread(new ArrayList<>(this.subList(startIndex, finishIndex)), buffer, i, startIndex, finishIndex);
            startIndex += sizeThread;
            finishIndex += sizeThread;
        }
        for (SumThread thread : threadsArray) {
            thread.start();
            try {
                thread.join();
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                System.exit(-1);
            }
        }
        return buffer.getSum();
    }
}
