package ex02;

import java.util.ArrayList;

public class SumBuffer {
    private int totalSum = 0;

    public synchronized int sum(ArrayList<Integer> array) {
        int tmpSum = 0;
        for (int num : array) {
            tmpSum += num;
        }
        totalSum += tmpSum;
        return tmpSum;
    }

    public int getSum() {
        return totalSum;
    }

    ;
}
