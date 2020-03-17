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
        System.out.println(findAlle(5));
        System.out.println(findMax());

        data.clear();

        data.add(4);
        data.add(12);
        data.add(13);
        data.add(22);
        data.add(27);
        data.add(35);
        data.add(56);
        data.add(62);
        data.add(67);
        data.add(107);
        data.add(182);

        // binary search
        System.out.println(binarySearch(62));

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

    static int findAlle(int x) {
        int result = 0;

        for (int i : data) {
            if (i == x) {
                result++;
            }
        }

        return result;
    }

    static int findMax() {
        int result = 0;

        for (int i : data) {
            if (i > result) {
                result = i;
            }
        }

        return result;
    }

    static int binarySearch(int x) {
        int result;
        int indexMin = 0;
        int indexMax = data.size() - 1;

        System.out.println("PErforming binary search for the integer " + x + " on a list with " + data.size() + " entries.");

        while (true) {
            int indexMid = (indexMax + indexMin) / 2;
            System.out.println("Looking at median index " + indexMid + "...");
            if (data.get(indexMid) == x) {
                result = indexMid;
                System.out.println("Success! Found the integer " + x + " at index " + result + ".");
                break;
            } else if (data.get(indexMid) > x) {
                indexMax = indexMid;
                System.out.println("This integer is higher than what we're looking for, adjusting bounds to " + indexMin + " and " + indexMax + ".");
            } else {
                indexMin = indexMid;
                System.out.println("This integer is lower than what we're looking for, adjusting bounds to " + indexMin + " and " + indexMax + ".");
            }
        }

        return result;
    }
}
