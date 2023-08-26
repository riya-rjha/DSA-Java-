public class divide {

    public static void PrintArray(int n[]) {
        for (int i=0; i<n.length; i++){
            System.out.print(n[i]+" ");
        }
    }

    public static void MergeSort(int arr[], int si, int ei) {
        //Base case
        if(si>=ei){
            return;
        }
        int mid = si + (ei-si)/2;
        MergeSort(arr, si, mid);
        MergeSort(arr, mid+1, ei);
        Merge(arr, si, mid, ei);
    }

    public static void Merge(int arr[], int si,int mid, int ei){
        int temp[] = new int[ei-si+1];
        int i = si;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=ei){
            if(arr[i]<arr[j]){
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }
        //leftover elements
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while(j<=ei){
            temp[k++] = arr[j++];
        }
        for ( k=0, i=si; k<temp.length; k++, i++){
            arr[i] = temp[k];
        }

    }

    public static void QuickSort(int arr[], int si, int ei) {
        //base case
        if(si>=ei){
            return;
        }
        //last element --> pivot element
        Partition(arr, si, ei);
        int key = Partition(arr, si, ei);
        QuickSort(arr, si, key-1); //left sort
        QuickSort(arr, key+1, ei); //right sort
    }

    public static int Partition(int arr[], int si, int ei) {
        int pivot = arr[ei];//choosing the last element as the pivot element 
        int i = si-1;
        for (int j=si; j<ei; j++){
            if(arr[j]<=pivot){
                i++;
                //swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }//after i and j cross each other
        i++;
        //swap pivot element and ith element ie starting element
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;
    }

    public static void main(String[] args) {
        int arr[] = {6,7,3,4,1,2,5,9,10,8};    
        //MergeSort(arr, 0, 9);
        QuickSort(arr, 0, arr.length-1);
        PrintArray(arr);
    }
}
