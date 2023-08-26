
public class pracs{

    //to print elements of array 
    public static void printArr(int arr[]) {
        for (int i=0; i<arr.length; i++){
            System.out.print(arr[i]+" ");
        }
    }
    
    //to change the elements of array by backtracking 
    public static void changeArr(int arr[], int i, int value) {
        if(i==arr.length){
            printArr(arr);
            return;
        }
        arr[i] = value;
        changeArr(arr, i+1, value+1);
        //backtracking step
        arr[i] = arr[i] - 2;
    }

    //to find and print all subsets of string
    public static void findSubsets(String str, String ans, int i) {
        //base case 
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("Null set");
            }
            else{
                System.out.println(ans);
            }
            return;
        }
        //yes choice
        findSubsets(str, ans+str.charAt(i), i+1); 
        //no choice
        findSubsets(str, ans, i+1); 

    }

    //to find no of possible permutations of a given string
    public static void findPermu(String str, String ans) {
        //base case

    }

    //N - Queens problem
    public static boolean isSafeQueeen(char board[][], int row, int col) {

        //vertically up
        for (int i=row-1; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        //vertically left diagonal
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        //vertically right diagonal
        for (int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }

    //printing a 2D matrix
    public static void printBoard(char board[][]) {
        System.out.println("Possible chess board solution is : -----");
        for (int i=0; i<board.length; i++){
            for (int j=0; j<board.length; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
    }

    //creating all possible solutions of n Queens
    public static void nQueens(char board[][], int row) {
        //base case
        if(row==board.length){
            printBoard(board);
            return;
        }
        for(int j=0; j<board.length; j++){  
            System.out.println(isSafeQueeen(board, row, j));
            if (isSafeQueeen(board, row, j)) {
                System.out.println("Values of row and j are :  " + row + " " + j);
                board[row][j] = 'Q';
                nQueens(board, row+1);
                board[row][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = new int[5];
        System.out.println("Actual Array is : ");
        changeArr(arr, 0, 1);
        System.out.println();
        System.out.println("Modified array after backtracking : ");
        printArr(arr);

        //------------------------------
        char board[][] = new char[4][4];
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                board[i][j] = 'X';
            }
        }
        nQueens(board, 0);
    }
}

