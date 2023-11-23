package ex03;

import java.lang.reflect.Executable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import java.util.Map;

public class DownloadThread extends Thread {
    private Urls urls;
    private int threadCount;

    public DownloadThread(Urls urls, int threadCount) {
        this.urls = urls;
        this.threadCount = threadCount;
    }

    @Override
    public void run() {
        while (!urls.isEmpty()) {
            Map.Entry<Integer, String> urlEntry = urls.getURL();
            String urlStr = urlEntry.getValue();
            int urlCount = urlEntry.getKey();
            URL url;
            try {
                url = new URL(urlStr);
            } catch (Exception ex) {
                System.out.println("Incorrect format of URL " + urlCount);
                continue;
            }
            try {
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                    System.out.println("Thread-" + threadCount + " start download file number " + urlCount);
                    InputStream inputStream = connection.getInputStream();
                    File file = new File(getName(urlStr));
                    OutputStream outputStream = new FileOutputStream(file);
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    inputStream.close();
                    outputStream.close();
                    connection.disconnect();
                    System.out.println("Thread-" + threadCount + " finish download file number " + urlCount);
                } else {
                    connection.disconnect();
                    throw new RuntimeException("Unable to create connection with file " + urlCount);
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private String getName(String path) {
        String[] words = path.split("/");
        return words[words.length - 1];
    }
}
