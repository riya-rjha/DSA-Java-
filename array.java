public class array {

    // linear search of element
    public static int LinearSearch(int n[], int key) {
        for (int i = 0; i < n.length; i++) {
            if (key == n[i]) {
                return i;
            }
        }
        return -1;
    }

    // binary search
    public static int BinarySearch(int n[], int key) {
        int l = 0;
        int r = n.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (n[mid] == key) {
                return mid;
            }
            if (n[mid] > key) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    // reverse of array
    public static void ReverseOfArray(int n[]) {
        int start = 0;
        int end = n.length - 1;
        while (start <= end) {
            int temp = n[start];
            n[start] = n[end];
            n[end] = temp;
            start++;
            end--;
        }
    }

    // printing array
    public static void PrintArray(int n[]) {
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i] + " ");
        }
    }

    // pairs in array
    public static void PairsOfArray(int n[]) {
        for (int i = 0; i < n.length; i++) {
            for (int j = i + 1; j < n.length; j++) {
                System.out.println("(" + n[i] + "," + n[j] + ")");
            }
            System.out.println();
        }
    }

    // sub arrays in array
    public static void SubArrays(int n[]) {
        for (int i = 0; i < n.length; i++) {
            for (int j = i; j < n.length; j++) {
                System.out.println("(" + n[i] + "," + n[j] + ")");
            }
            System.out.println();
        }
    }

    // SubArrays Sum
    // Brute Force
    public static void BruteForce(int n[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n.length; i++) {
            int start = i;
            for (int j = i; j < n.length; j++) {
                int end = j;
                currSum = 0;
                for (int k = start; k <= end; k++) {
                    currSum += n[k];
                }
                System.out.println("Current Sum : " + currSum);
            }
            maxSum = Math.max(maxSum, currSum);
            System.out.println("Max Sum : " + maxSum);
        }
    }

    // SubArrays Sum
    // Prefix Array Sum
    public static void PrefixArraySum(int n[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefix[] = new int[n.length];
        prefix[0] = n[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = n[i] + prefix[i - 1];
        }
        for (int i = 0; i < n.length; i++) {
            int start = i;
            for (int j = 0; j < n.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                }
                System.out.println("Current Sum : " + currSum);
            }
            maxSum = Math.max(maxSum, currSum);
            System.out.println("Max Sum : " + maxSum);
        }
    }

    // SubArrays Sum
    // Kadane's Algorithm
    public static void KadaneAlgo(int n[]) {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n.length; i++) {
            currSum += n[i];
            System.out.println("Curr sum : " + currSum);
            if (currSum < 0) {
                currSum = 0;
            }
            // if all input values of array are negative
            if (n[i] < 0) {
                int smallest = Integer.MAX_VALUE;
                if (smallest > n[i]) {
                    smallest = n[i];
                }
                currSum = smallest;
            }
            maxSum = Math.max(maxSum, currSum);
            System.out.println("Max Sum : " + maxSum);
        }
    }

    // trapping rainwater
    // {4,2,0,6,3,2,5}
    public static void TrappedRainWater(int n[]) {
        int LMB[] = new int[n.length];
        LMB[0] = n[0];
        for (int i = 1; i < LMB.length; i++) {
            LMB[i] = Math.max(n[i], LMB[i - 1]);
        }
        int RMB[] = new int[n.length];
        RMB[n.length - 1] = n[n.length - 1];
        for (int i = n.length - 2; i >= 0; i--) {
            RMB[i] = Math.max(n[i], RMB[i + 1]);
        }
        int trapped = 0;
        for (int i = 0; i < n.length; i++) {
            int waterLevel = Math.min(LMB[i], RMB[i]);
            trapped += waterLevel - n[i];
        }
        System.out.println("Trapped Rain water : " + trapped);
    }

    // Buy & Sell Stocks
    //{ 7, 1, 5, 3, 6, 4 }
    public static void BuySell(int n[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < n.length; i++) {
            if (buyPrice < n[i]) {
                int netProfit = n[i] - buyPrice;
                maxProfit = Math.max(maxProfit, netProfit);
            }else{
                buyPrice = n[i];
            }
        }
        System.out.println("Max Profit : " + maxProfit);
    }

    public static void main(String[] args) {
        // starting the codes again;
        int arr[] = { 7, 1, 5, 3, 6, 4 };
        // int key = 8;
        BuySell(arr);
    }
}
