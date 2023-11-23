package ex01;
public class Printer {
    private Type type = Type.EGG;

    private enum Type {
        EGG,
        HEG;
    }

    public synchronized void print(String str) {
        try {
            if (type != Type.valueOf(str.toUpperCase())) {
                wait();
            }
            System.out.println(str);
            type = type  == Type.EGG ? Type.HEG : Type.EGG;
            notify();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}