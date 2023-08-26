import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class greedyAlgo {

    // Activity Selection Code
    // performing max activites
    public static int ActivitySelectionCode(int start[], int end[]) {
        // 2D array to store indices and timing of start and end
        int activity[][] = new int[start.length][3];
        int maxAct = 1;// first act will always be performed

        // storing values in 2D array
        for (int i = 0; i < start.length; i++) {
            activity[i][0] = i; // index
            activity[i][1] = start[i];
            activity[i][2] = end[i];
        }

        // Sorting on the basis of end time
        // Comparator and Lambda function
        Arrays.sort(activity, Comparator.comparingDouble(o -> o[2]));

        // create and arrayList to store the activities
        ArrayList<Integer> arr = new ArrayList<>();
        // first activity will always be performed
        arr.add(activity[0][0]);
        // ending time of second activity after first activity has been performed
        int lastEnd = activity[0][2];
        for (int i = 1; i < end.length; i++) {
            if (activity[i][1] >= lastEnd) {
                // Acitivty selection
                maxAct++;
                lastEnd = activity[i][2];
                arr.add(activity[i][0]);
            }
        }
        System.out.println("Activities that can be performed : ");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print("A" + arr.get(i) + " ");
        }
        System.out.println();
        return maxAct;

    }

    // Fractional Knapsack
    // get the max cost on taking weights of goods

    public static int FractionalKnapsack(int val[], int weight[], int capacity) {

        // double to store decimal values of ratios
        double ratio[][] = new double[val.length][2];
        for (int i = 0; i < val.length; i++) {
            ratio[i][0] = i; // idx
            ratio[i][1] = val[i] / (double) weight[i];
        }

        // sort according to ratio in ascending order
        Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
        int cost = 0;
        // Best ratio
        for (int i = ratio.length - 1; i >= 0; i--) {
            int idx = (int) ratio[i][0];// index of best ratio
            if (capacity >= weight[idx]) {
                cost += val[idx];
                capacity -= weight[idx];
                // System.out.println(cost);
            } else {
                cost += (ratio[i][1] * capacity);
                capacity = 0;
                break;
            }

        }
        return cost;
    }

    // Minimum Absolute Difference Sum of Pairs
    public static int minAbsoluteDifference(int A[], int B[]) {
        // Smaller compared to Smaller will result in a smaller value
        int minDiff = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for (int i = 0; i < A.length; i++) {
            minDiff += Math.abs(A[i] - B[i]);
        }

        return minDiff;
    }

    // Max Length Chain of Pairs
    // Based on activity Selection Code
    public static int maxLengthChain(int pairs[][]) {
        // sorting on the basis of last end time
        Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));
        int maxChains = 1;
        int lastEnd = pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > lastEnd) {
                maxChains++;
                lastEnd = pairs[i][1];
            }
        }
        return maxChains;
    }

    // Indian Coins
    public static int IndianCoins(Integer coins[], int amount) {
        int numCoins = 0;
        ArrayList<Integer> arrList = new ArrayList<>();
        // sort coins array in descending order
        Arrays.sort(coins, Comparator.reverseOrder());
        for (int i = 0; i < coins.length; i++) {
            while (amount >= coins[i]) {
                amount = amount - coins[i];
                numCoins++;
                arrList.add(coins[i]);
            }
        }
        for (int i = 0; i < arrList.size(); i++) {
            System.out.print(arrList.get(i) + " ");
        }
        System.out.println();
        return numCoins;
    }

    // Job Sequencing Problem

    static class Job {
        int deadline;
        int profit;
        int id;

        public Job(int d, int i, int p) {
            deadline = d;
            profit = p;
            id = i;
        }
    }

    public static void jobSequencing(int JobsInfo[][]) {
        ArrayList<Job> jobs = new ArrayList<>();
        for (int i = 0; i < JobsInfo.length; i++) {
            jobs.add(new Job(JobsInfo[i][0], i, JobsInfo[i][1]));
        }
        int time = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        // arrange profit in descending order
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        for (int i = 0; i < jobs.size(); i++) {

            // ArrayList ith item
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                time++;
                ans.add(curr.id);
            }
        }
        char ARR[] = { 'A', 'B', 'C', 'D', 'E' };
        for (int i = 0; i < ans.size(); i++) {
            int idx = ans.get(i);
            System.out.print("Job " + ARR[idx] + " ");
        }
    }

    // Chocola Problem
    // expensive cuts done first
    public static int chocolaProblem(Integer costHor[], Integer costVer[]) {
        int hp = 0; // hz pointer
        int vp = 0; // vy pointer
        int hzP = 1; // hz pieces
        int vyP = 1; // vy pieces
        int cost = 0;

        // sorting in descending order
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        while (hp < costHor.length && vp < costVer.length) {
            if (costHor[hp] <= costVer[vp]) {
                // vertical cuts expensive will be done first
                cost += (hzP * costVer[vp]);
                vp++;
                vyP++;
            } else {
                // horizontal cuts expensive will be done first
                cost += (vyP * costHor[hp]);
                hp++;
                hzP++;
            }
        }
        // Remaining cuts
        if (hp < costHor.length) {
            cost += (vyP * costHor[hp]);
            hp++;
            hzP++;
        }
        if (vp < costVer.length) {
            cost += (hzP * costVer[vp]);
            vp++;
            vyP++;
        }
        System.out.println();
        System.out.println("No of horizontal cuts : " + hzP);
        System.out.println("No of vertical cuts : " + vyP);
        return cost;
    }

    // Assignment Questions
    // Max Balanced String partitions
    public static int maxBalancedSubStrings(String str) {
        int count_L = 0;
        int count_R = 0;
        int ans = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'L') {
                count_L++;
            } else {
                count_R++;
            }
            if (count_L == count_R) {
                // Substring is balanced
                ans++;
            }
        }
        return ans;
    }

    // Kth largest odd number
    public static int kthLargestOddNo(int L, int R, int K) {

        for (int i = R; i >= L; i--) {
            if (i % 2 != 0) {
                K--;
                int idx = i;
                if (K == 0) {
                    return idx;
                }
            }
        }
        // when K>no of odd nos
        return 0;
    }

    // Lexicographically Smallest String
    // Length N and Sum K
    public static String lexo_small(int n, int k) {
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');
        for (int i = n - 1; i >= 0; i--) {
            k -= i;
            if (k >= 0) {
                if (k >= 26) {
                    arr[i] = 'z';
                    k -= 26;
                } 
                else {
                    arr[i] = (char) (k + 97 - 1);
                    k -= arr[i] - 'a' + 1;
                }
            } 
            else {
                break;
            }
            k += i;
        }
        //ERROR
        return arr.toString();
    }


    //Best time to Buy & Sell Stocks
    public static int maxProfit(int prices[]) {
        int buyPrice = prices[0];
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++){

            //BuyPrice is more then buy continue storing highest value of BuyingPrice 
            if(buyPrice>prices[i]){
                buyPrice = prices[i];
            }
            else if(prices[i] - buyPrice>maxProfit){
                maxProfit = prices[i] - buyPrice;
            }
        }
        return maxProfit;
    }

    public static int ans = Integer.MAX_VALUE;

    public static void solveSplit(int arr[], int k, int n, int index, int sum, int maxSum) {
        //base case
        // when only one subArray min sum has to be calculated
        if(k==1){
            maxSum = Math.max(maxSum, sum);
            sum = 0;
            for(int i=index; i<arr.length; i++){
                sum += arr[i];
            }
            maxSum = Math.max(maxSum, sum);
            ans = Math.min(maxSum, ans);
            return;
        }

        sum = 0;
        for(int i=index; i<arr.length; i++){
                sum += arr[i];
                maxSum = Math.max(maxSum, sum);
                solveSplit(arr, k-1, n, i+1, sum, maxSum);
        }
    }
    public static void main(String[] args) {

        // Activity Selection Code
        int start[] = { 1, 3, 0, 5, 8, 5 };
        int end[] = { 2, 4, 6, 7, 9, 9 };
        System.out.print("Max number of activities that can be performed are : " + ActivitySelectionCode(start, end));
        System.out.println();

        // Fractional Knapsack
        int val[] = { 60, 100, 120 };
        int weight[] = { 10, 20, 30 };
        int capacity = 50;
        System.out.println("Total cost : " + FractionalKnapsack(val, weight, capacity));

        // Minimum Absolute Difference
        int A[] = { 1, 4, 7, 8 };
        int B[] = { 2, 3, 5, 6 };
        System.out.println("Minimum absolute Difference : " + minAbsoluteDifference(A, B));

        // Max Length Chain Pairs
        int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };
        System.out.println("Max length of Chains : " + maxLengthChain(pairs));

        // Indian Coins
        Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 2000 };
        int amount = 590;
        System.out.println("No of coins : " + IndianCoins(coins, amount));

        // Job Sequencing Problem
        int Jobsinfo[][] = { { 4, 20 }, { 1, 10 }, { 1, 40 }, { 1, 30 } };
        jobSequencing(Jobsinfo);

        // Chocola Problem
        Integer costVer[] = { 2, 1, 3, 1, 4 };
        Integer costHor[] = { 4, 1, 2 };
        System.out.println("Total cost of cutting chocolate : " + chocolaProblem(costHor, costVer));

        // Max Balanced SubStrings partition
        String str = "LRRRRLLRLLRL";
        System.out.println("Max number of subStrings : " + maxBalancedSubStrings(str));

        // Kth largest odd no
        int L = -3;
        int R = 3;
        int K = 2; // 1st largest odd number
        System.out.println(K + "th Largest Odd No : " + kthLargestOddNo(L, R, K));

        // Lexicographically Smallest String
        int N = 5;
        int K2 = 42;
        System.out.println("Lexicographically Smallest String that can be formed : " + lexo_small(N, K2));

        //Best time to Buy & Sell Stocks
        int prices[] = {7, 1, 5, 3, 6, 4};
        System.out.println("Max Profit that can be obtained : " + maxProfit(prices));

        //K sub array Split
        int Array[] = {1, 2, 3, 4};
        int K3 = 3;
        solveSplit(Array, K3, Array.length, 0, 0, 0);
                                            //idx    sum    maxSum
        System.out.println("Minimum sub-array sum : " + ans);
    }

}
