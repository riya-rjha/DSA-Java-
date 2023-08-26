public class practice {

    //Last occurrence of element in array
    //using recursion
    public static int LastOcc(int arr[], int key, int i){
        //base case
        if(i==arr.length-1){
            return -1;
        }
        int isFound = LastOcc(arr, key, i+1);
        if(isFound==-1 && arr[i] == key){
            //when idx is -1 ie element present at last then return value of idx
            return i;
        }
        return isFound;
    }

    public static void Last(int arr[], int key, int i) {
        if(i==arr.length-1){
            return;
        }
        int isF = LastOcc(arr, key, i+1);
        System.out.println(isF);

    }

    //to print the chess board
    public static void printBoard(char arr[][]) {
        System.out.println("----Chess Board----");
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    //to recursively perform backtracking step
    //placing n queens in n rows
    public static void nQueens(char arr[][], int row) {
        //base case
        if(row==arr.length){
            printBoard(arr);
            count++;
            return;
        }
        //column loop
        for (int j=0; j<arr.length; j++){
            if(isSafe(arr,row,j)){
                arr[row][j] = 'Q';
                nQueens(arr, row+1);
                arr[row][j] = 'x';
            }
        }
    }

    public static boolean isSafe(char arr[][], int row, int col) {
        //vertical up
        for(int i=row-1; i>=0; i--){
            if(arr[i][col] == 'Q'){
                return false;
            }
        }

        //diagonally left
        for (int i=row-1,j=col-1; i>=0 && j>=0 ; i--, j--){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }

        //diagonally right
        for (int i=row-1, j=col+1; i>=0 && j<arr.length; i--, j++){
            if(arr[i][j] == 'Q'){
                return false;
            }
        }

        return true;
    }

    static int count = 0;
    public static void main(String[] args) {
        char arr[][] = {{'x','x','x','x','x'},
                         {'x', 'x','x','x','x'},
                        {'x','x','x','x','x'},
                        {'x','x','x','x','x'},
                        {'x','x','x','x','x'}};
        nQueens(arr, 0);
        System.out.println("No of possible solutions : ");
        System.out.print(count);

        int n = 3, m = 3;
        System.out.println();
        System.out.println("No of ways : ");
        System.out.print(gridWays(0, 0, n, m));
    }

    //to print no of ways one can travel through a grid
    public static int gridWays(int i, int j, int n, int m) {
        //base case
        if(i==n-1 && j==m-1){
            return 1;
        }
        //corner case
        else if(i==n || j==m){
            return 0;
        }
        return (gridWays(i+1, j, n, m) + gridWays(i, j+1, n, m));
    }

}

