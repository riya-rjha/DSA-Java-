import java.util.*;

public class hackerrank {

    public static void miniMaxSum(List<Long> arr) {
        // Write your code here
        long largest = Integer.MIN_VALUE;
        long smallest = Integer.MAX_VALUE;
        for (int i = 0; i < arr.size(); i++) {
            largest = Math.max(largest, arr.get(i));
            smallest = Math.min(smallest, arr.get(i));
        }
        long maxSum = 0;
        long minSum = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == largest) {
                continue;
            }
            minSum += arr.get(i);
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == smallest) {
                continue;
            }
            maxSum += arr.get(i);
        }
        minSum = (int)minSum;
        System.out.println(minSum + " " + maxSum);
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // ArrayList<long>list = new ArrayList<>();
            List<Long> list = new ArrayList<Long>(Arrays. asList(1L, 2L));
            for (int i=0; i<5; i++){
                list.add(sc.nextLong());
            }
            miniMaxSum(list);
        }
    }
}