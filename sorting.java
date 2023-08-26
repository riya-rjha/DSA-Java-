import java.util.Arrays;

public class sorting {

    //printing array
    public static void PrintArray(int n[]) {
        for(int i=0; i<n.length; i++){
            System.out.print(n[i] + " ");
        }
    }


    //bubble sorting
    public static void BubbleSort(int n[]) {
        for (int i=0; i<n.length; i++){
            for (int j=0; j<n.length-i-1; j++){
                if(n[j]>n[j+1]){
                    //swap
                    int temp = n[j];
                    n[j] = n[j+1];
                    n[j+1] = temp;
                }
            }
        }
    }

    //insertion sort
    public static void InsertionSort(int n[]) {
        for (int i=1; i<n.length; i++){
            int temp = n[i];
            int j = i-1;
            while(j>=0 && n[j]>temp){
                n[j+1] = n[j];
                j--;
            }
            n[j+1] = temp;
        }
    }

    //selection sort
    public static void SelectionSort(int n[]) {
        for(int i=0; i<n.length; i++){
            int minPos = i;
            for (int j=i+1; j<n.length; j++){
                if(n[minPos]>n[j]){
                    minPos = j;
                }
            }
            //swap
            int temp = n[minPos];
            n[minPos] = n[i];
            n[i] = temp;
        }
    }

    //Arrays sorting inbuilt method
    public static void ArraySorting(int n[]) {
        Arrays.sort(n, 0, n.length);
    }

    //Couting Sort
    public static void CountingSort(int n[]) {
        int largest = Integer.MIN_VALUE;
        for (int i=0; i<n.length; i++){
            largest = Math.max(largest, n[i]);
        }
        int countArr[] = new int[largest+1];
        for (int i=0; i<n.length; i++){
            countArr[n[i]]++;
        }
        int j = 0;
        for (int i=0; i<countArr.length; i++){
            while(countArr[i]>0){
                n[j] = i;
                countArr[i]--;
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {5,3,2,4,1};
        CountingSort(arr);
        PrintArray(arr);
    }
}
