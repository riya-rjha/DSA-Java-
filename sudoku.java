public class sudoku {

    //printing the sudoku
    public static void printSudoku(int sudoku[][]) {
        for (int i=0; i<sudoku.length; i++){
            for (int j=0; j<sudoku.length; j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
            System.out.println("------------------");
        }
    }

    //check isSafe condition for sudoku
    public static boolean isSafeSudoku(int arr[][], int row, int col, int digit) {

        //column check
        for (int i=0; i<=8; i++){
            if(arr[i][col] == digit){
                return false;
            }
        }

        //row check
        for (int j=0; j<=8; j++){
            if(arr[row][j] == digit){
                return false;
            }
        }

        //grid check
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for (int i =sr; i<sr+3; i++){
            for(int j=sc; j<sc+3; j++){
                if(arr[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean sudokuSolver(int arr[][], int row, int col) {
        //base case
        if(row==9){
            return true;
        }
        int nextRow = row;
        int nextCol = col+1;
        if(col == 8){
            nextCol = 0;
            nextRow = row+1;
        }

        if(arr[row][col]!=0){
            return sudokuSolver(arr, nextRow, nextCol);
        }
        for (int digit=1; digit<=9; digit++){
            if(isSafeSudoku(arr, row, col, digit)){
                arr[row][col] = digit;
                if(sudokuSolver(arr, nextRow, nextCol)){
                    //solution exists
                    return true;
                }
                arr[row][col] = 0;
            }
        }

        return false;
    }

    public static void main(String[] args) {
       /* int arr[][] = {{4,2,0,5,0,3,8,0,6},
                        {0,0,3,4,0,7,9,1,2},
                        {9,7,0,0,0,8,4,0,5},
                        {2,0,7,9,8,0,0,1,0},
                        {1,9,0,3,0,0,2,0,6},
                        {3,5,0,0,0,0,8,9,0},
                        {1,5,0,7,0,9,6,0,8},
                        {6,3,0,8,0,1,0,2,9},
                        {0,0,9,2,6,0,0,0,1}};*/

           int arr[][] = { {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0}, 
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0} };
        if(sudokuSolver(arr, 0, 0)){
            System.out.println("Solution exists : ----");
            printSudoku(arr);
        }
        else{
            System.out.println("Solution does not exits : ----");
        }
    }
}
