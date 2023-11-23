package ex02;

import ex01.Printer;

import java.util.ArrayList;

public class SumThread extends Thread {
    private final ArrayList<Integer> array;
    SumBuffer buffer;
    int threadCounter, startIndex, finishIndex;

    public SumThread(ArrayList<Integer> array, SumBuffer buffer, int threadCounter, int startIndex, int finishIndex) {
        super();
        this.array = array;
        this.buffer = buffer;
        this.threadCounter = threadCounter;
        this.startIndex = startIndex;
        this.finishIndex = finishIndex;
    }

    @Override
    public void run() {
        int sum = buffer.sum(array);
        System.out.println("Thread " + threadCounter + ": from " + startIndex + " to " + finishIndex + " sum is " + sum);
    }
}
