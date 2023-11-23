package ex03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Urls {
    private TreeMap<Integer, String> urlMap = new TreeMap<>();

    public Urls() {
        try {
            BufferedReader in = new BufferedReader(new FileReader("ex03/files_urls.txt"));
            String str = in.readLine();
            while (str != null) {
                String[] lineWords = str.split("\\s+");
                if (lineWords.length != 2)
                    System.out.println("Incorrect format of URL " + lineWords[0]);
                else {
                    urlMap.put(Integer.parseInt(lineWords[0]), lineWords[1]);
                }
                str = in.readLine();
            }
            if (urlMap.isEmpty())
                throw new RuntimeException("File is empty!");
            in.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Map.Entry<Integer, String> getURL() {
        return urlMap.pollFirstEntry();
    }

    public boolean isEmpty() {
        return urlMap.isEmpty();
    }
}
