import java.util.*;

public class strings {

    //String Compression
    public static String Compression(String str) {
        StringBuilder sb = new StringBuilder(" ");
        for (int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i)==str.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count>1){
                sb.append(count.toString());
            }
        }
        return sb.toString();
    }

    
    
    //anagrams
    public static void name(String a, String b) {
        //if the order of two strings is different 
        //but letters are same
        /*
        Step 1 : convert to lowercase
        Step 2 : check lengths
        Step 3 : convert to character array
        Step 4 : sort arrays
        Step 5 : check equality of arrays
         */

         a = a.toLowerCase();
         b = b.toLowerCase();
         if(a.length()==b.length()){
            char a_arr[] = a.toCharArray();
            char b_arr[] = b.toCharArray();
            Arrays.sort(a_arr);
            Arrays.sort(b_arr);
            boolean result = Arrays.equals(a_arr, b_arr);
            if(result){
                System.out.println("Yes anagrams");
            }
            else{
                System.out.println("Not anagrams");
            }
            
         }
        else{
            System.out.println("Not anagrams");
        }

        
    }


    public static void main(String[] args) {
        String str1[] = {"a3b2c1d2"};
        Decompression(str1);
        
    }

    //String decompression
    public static void Decompression(String str[]) {
        int l = str.length;
        String alphabets[] = new String[l/2];
        int numbers[] = new int[l/2];
        int n1 = 0, n2 = 0;
        for(int i=0; i<l; i++){
            if(i%2==0){
                //at even indexes
                //characters will be present
                alphabets[n1] = str[i];
                n1++;
            }
            if(i%2!=0){
                numbers[n2] = Integer.parseInt(str[i]) - 48;
                n2++;
            }
        }

        for (int i=0; i<l/2; i++){
            int clone = numbers[i];
            while(clone>0){
                System.out.println(alphabets[i]);
                clone--;
            }

        }
    }
}