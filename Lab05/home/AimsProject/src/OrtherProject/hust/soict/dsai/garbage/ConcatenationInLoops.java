package OrtherProject.hust.soict.dsai.garbage;
import java.util.Random;
public class ConcatenationInLoops {
    public static void main(String[] args) {
        Random r = new Random(123);
        long star = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 65536; i++)  s += r.nextInt(2);
        System.out.println(System.currentTimeMillis() - star);
        r = new Random(123);
        star = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 65536; i++)  sb.append(r.nextInt(2));
        System.out.println(System.currentTimeMillis() - star);

    }

}
