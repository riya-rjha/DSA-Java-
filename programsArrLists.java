import java.util.*;
public class programsArrLists {

    //reversal of arrayList
    public static void reversal(ArrayList<Integer>list) {
        // int n = list.size();
        // System.out.print("[ ");
        // for (int i=n-1; i>=0; i--){
        //     System.out.print(list.get(i)+", ");
        // }
        // System.out.println(" ]");

        int start = 0;
        int end = list.size()-1;
        while(start<=end){
            int temp = list.get(start);
            list.set(start, list.get(end));
            list.set(end, temp);
            start++;end--;
        }
        System.out.println(list);
    }

    //maximum of arrayList
    public static int maxArrList(ArrayList<Integer>list) {
        int largest = Integer.MIN_VALUE;
        for (int i=0; i<list.size(); i++){
            if(largest<list.get(i)){
                largest = list.get(i);
            }
        }
        return largest;
    }

    //swapping two elements
    public static void swapArrList(ArrayList<Integer>list, int i1, int i2) {
        int temp = list.get(i1);
        list.set(i1, list.get(i2));
        list.set(i2, temp);
    }

    //sorting an arrayList
    public static void sortingAscending(ArrayList<Integer>list) {
        Collections.sort(list);
    }
    public static void sortingDescending(ArrayList<Integer>list) {
        Collections.sort(list, Collections.reverseOrder());
    }

    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        for (int i=1; i<=8; i++){
            list.add(i*2);
        }
        int i1 = 0;
        int i2 = list.size()-1;
        System.out.println("ArrayList is : "+list);
        System.out.println("After reversal : ");
        reversal(list);
        System.out.println("Maximum : " + maxArrList(list));
        swapArrList(list, i1, i2);
        System.out.println("After swapping list is : "+ list);
        sortingAscending(list);
        System.out.println("Sorted array in ascending order : "+list);
        sortingDescending(list);
        System.out.println("Sorted array in descending order : "+list);
    }
}
