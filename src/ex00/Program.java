package ex00;

public class Program {
    private static int count;
    public static void main(String[] args) {
        checkArg(args);
        EggThread eggThread = new EggThread(count);
        HegThread hegThread = new HegThread(count);
        eggThread.start();
        hegThread.start();
        try {
            eggThread.join();
            hegThread.join();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }
        for (int i = 0; i < count; i++) {
            System.out.println("Human");
        }
    }
    public static void checkArg(String[] args) {
        try {
            if (args.length != 1)
                throw new RuntimeException("Incorrect count of arguments!");
            String[] argWords = args[0].split("=");
            if (argWords.length != 2 || !argWords[0].equals("--count"))
                throw new RuntimeException("Incorrect argument!");
            count = Integer.parseInt(argWords[1]);
            if (count < 0)
                throw new RuntimeException("Incorrect count^ " +count);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

    }

}
