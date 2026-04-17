package hust.soict.hedspi.garbage;

import java.util.Random;

public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long start = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++) {
            s += r.nextInt(2);
        }
        System.out.println("String concatenation: " + (System.currentTimeMillis() - start) + " ms");

        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++) {
            sb.append(r.nextInt(2));
        }
        s = sb.toString();
        System.out.println("StringBuilder append: " + (System.currentTimeMillis() - start) + " ms");
        
        r = new Random(123);
        start = System.currentTimeMillis();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < 65536; i++) {
            sbuffer.append(r.nextInt(2));
        }
        s = sbuffer.toString();
        System.out.println("StringBuffer append: " + (System.currentTimeMillis() - start) + " ms");
    }
}
