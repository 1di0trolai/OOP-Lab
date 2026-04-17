package hust.soict.hedspi.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class NoGarbage {
    public static void main(String[] args) {
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files
                    .readAllBytes(Paths.get("D:\\Code\\OOP\\OtherProjects\\hust\\soict\\hedspi\\garbage\\test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        startTime = System.currentTimeMillis();
        StringBuilder outputStringBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputStringBuilder.append((char) b);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time taken with StringBuilder: " + (endTime - startTime) + " ms");
    }
}
