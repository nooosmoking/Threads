package ex02;

public class Program {
    private static int arraySize, threadsCount;

    public static void main(String[] args) {
        checkArg(args);
        SumArray array = new SumArray(arraySize);
        System.out.println("Sum: " + array.sumStandart());
        System.out.println("Sum by threads: " + array.sumThreads(threadsCount));
    }

    public static void checkArg(String[] args) {
        try {
            if (args.length != 2)
                throw new RuntimeException("Incorrect count of arguments!");
            String[] arrayWords = args[0].split("=");
            String[] threadWords = args[1].split("=");
            if (arrayWords.length != 2 || threadWords.length != 2 || !arrayWords[0].equals("--arraySize") || !threadWords[0].equals("--threadsCount"))
                throw new RuntimeException("Incorrect argument!");
            arraySize = Integer.parseInt(arrayWords[1]);
            threadsCount = Integer.parseInt(threadWords[1]);
            if (arraySize < 0 || threadsCount < 0)
                throw new RuntimeException("Size of array and count of threads should be positive numbers!");
            if (arraySize > 2000000)
                throw new RuntimeException("Size of array shouldn't be more than 2 000 000!");
            if (threadsCount > arraySize)
                throw new RuntimeException("Count of threads shouldn't be more than size of array!");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

    }
}
