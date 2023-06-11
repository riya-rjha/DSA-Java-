public class nQueensCode{

    //n Queens
    public static void nQueens(char arr[][], int row) {
        //base case
        if(row==arr.length){
            printBoard(arr);
            return;
        }        

        for (int j=0; j<arr.length; j++){
            if(isSafe(arr,row,j)){
                arr[row][j] = 'Q';
                nQueens(arr, row+1);
                arr[row][j] = 'X';
            }
        }
        
    }

    public static boolean isSafe(char arr[][], int row, int col) {
        //vertically up
        for (int i=row-1; i>=0; i--){
            if(arr[i][col]=='Q'){
                return false;
            }
        }
        //diagonally left
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(arr[i][j]=='Q'){
                return false;
            }
        }

        //diagonally right
        for (int i=row-1, j=col+1; i>=0 && j<arr.length; i--, j++){
            if(arr[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char arr[][]) {
        System.out.println("Solution : -----");
        for (int i=0; i<arr.length; i++){
            for (int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        char arr[][] = new char[4][4];
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                arr[i][j] = 'X';
            }
        }
        nQueens(arr, 0);
    }
}