public class recursion{

    //program 1
    public static void Alloccurrences(int []arr, int key, int i){
        //base case
        if (i==arr.length){
            return;
        }
        if (arr[i] == key){
            System.out.println(i+" ");
        }
        Alloccurrences(arr, key, i+1);
    }

    //program 2
    static String digits [] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
    public static void PrintingNosOfNo(int n){
        //base case
        if (n==0){
            return;
        }
        int lastDigit = n%10;
        PrintingNosOfNo(n/10);
        System.out.print(digits[lastDigit]+" ");
    }

    //program 3
    public static int length(String str){
        if (str.length()==0){
            return 0;
        }
        return length(str.substring(1))+1;
    }

    //program 4
    public static int countSubStrings(String str, int i, int j, int n){
        //base case
        if(n==1){
            return 1;
        }
        if (n<=0){
            return 0;
        }
        int res = countSubStrings(str, i+1, j, n-1) + countSubStrings(str, i, j-1, n-1) - countSubStrings(str, i+1, j-1, n-2);
        if (str.charAt(i) == str.charAt(j)){
            res++;
        }
        return res;
    }

    

    public static void main (String [] args){
        String a = "abcab";
        int n = a.length();
        System.out.println(countSubStrings(a, 0, n-1, n));

    }
}