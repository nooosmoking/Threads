package ex03;

public class Program {
    private static int threadCount;

    public static void main(String[] args) {
        checkArg(args);
        Urls urls = new Urls();
        DownloadThread[] threads = new DownloadThread[threadCount];
        for (int i = 0; i < threadCount; i++) {
            threads[i] = new DownloadThread(urls, i + 1);
            threads[i].start();
        }
    }

    public static void checkArg(String[] args) {
        try {
            if (args.length != 1)
                throw new RuntimeException("Incorrect count of arguments!");
            String[] argWords = args[0].split("=");
            if (argWords.length != 2 || !argWords[0].equals("--threadsCount"))
                throw new RuntimeException("Incorrect argument!");
            threadCount = Integer.parseInt(argWords[1]);
            if (threadCount < 0)
                throw new RuntimeException("Incorrect count: " + threadCount);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
    }
}
