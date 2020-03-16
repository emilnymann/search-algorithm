import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    static ArrayList<Integer> data = new ArrayList<>(10);

    public static void main(String[] args) {

        for (int i = 0; i < 10; i++) {
            int rnd = ThreadLocalRandom.current().nextInt(0, 50 + 1);
            data.add(rnd);
        }

        System.out.println(data);
        System.out.println(find(5));

    }

    static boolean find(int x) {
        boolean result = false;

        for (int i : data) {
            if (i == x) {
                result = true;
                break;
            }
        }

        return result;
    }
}
