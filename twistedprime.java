import java.util.*;
public class twistedprime {

    public static boolean isPrime(int n) {
        if(n<2){
            return false;
        }
        if(n==2 || n==3){
            return true;
        }
        for (int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    public static int reversedNumber(int n) {
        int rev = 0;
        while(n!=0){
            int ld = n%10;
            rev = rev*10 + ld;
            n = n/10;
        }
        return rev;
    }

    public static boolean twistedPair(int n) {
        int revNumb = reversedNumber(n);
        return isPrime(revNumb);
    }

    public static int sumOfTwistedPairs(int n) {
        int sum = 0;
        int count = 0;
        int num = 2;
        while (count<n){
            if(twistedPair(n)){
                sum+=num;
                count++;
                num++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n;
        try (Scanner sc = new Scanner(System.in)) {
            n = sc.nextInt();
        }
        int sum = sumOfTwistedPairs(n);
        System.out.println("Sum of nos till " + n + " is : " + sum );
        
    }
}
