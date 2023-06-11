public class backTassignment {
    //Backtracking assignments

        /*1. Knight's Tour
         * 2. Keypad Combinations
         * 3. Rat in a maze
         */

    //Kinght's tour
    public static boolean SolveKnights(int x, int y, int move, int sol[][], int next_R[], int next_C[]) {
        //base case
        if(move==64){
            return true; //all cases have been checked
        }
        for (int k=0; k<8; k++){
            int nextRow = x + next_R[k];
            int nextCol = y + next_C[k];
            if(isSafeKnights(nextRow, nextCol, sol)){
                sol[nextRow][nextCol] = move; //move starts from 1
                if(SolveKnights(nextRow, nextCol, move+1, sol, next_R, next_C)){
                    return true;
                }
                else{
                    sol[nextRow][nextCol] = -1;
                }
            }
        }
        return false;
    }

    public static boolean isSafeKnights(int x, int y, int sol[][]) {
        return(x>=0 && x<8 && y>=0 && y<8 && sol[x][y]==-1);
    }

    public static void printKnightsBoard(int sol[][]) {
        for (int i=0; i<4; i++){
            for (int j=0; j<4; j++){
                System.out.print(sol[i][j]+"\t");
            }
            System.out.println();
        }
    }

    //KeyPad combinations
    public static void letterCombo(String D){
        int len = D.length();
        if(len==0){
            System.out.println(" ");
            return;
        }
        bfs(0,len,new StringBuilder(),D);
    }

    public static void bfs(int pos, int length, StringBuilder sb, String D) {
        if(pos==length){
            String str12 = sb.toString();
            System.out.println(str12);
        }
        else{
            char[] letters = L[Character.getNumericValue(D.charAt(pos))];
            for (int i=0; i<letters.length; i++){
                bfs(pos+1, length,new StringBuilder(sb).append(letters[i]), D);
                // sb = sb.deleteCharAt(1);
            }
        }
    }

    final static char[][] L = {{},{},{'a','b','c'},{'d','e','f'},{'g','h','i'},
    {'j','k','l'},{'m','n','o'},{'p','q','r','s'}, {'t','u','v'}};

    //Rat in a maze
    public static boolean isSafe(int arr[][], int x, int y) {
        return (x>=0 && x<arr.length && y>=0 && y<arr.length && arr[x][y] == 1);
    }

    public static boolean solveMaze(int arr[][]) {
        int N = arr.length;
        int sol[][] = new int[N][N];
        if(solveRatMazeUtil(arr, 0, 0, sol)){
            printKnightsBoard(sol);
            return true;
        }
        else{
            System.out.println("Solution does not exist");
            return false;
        }
    }

    public static boolean solveRatMazeUtil(int arr[][], int x, int y, int sol[][]) {
        //base case
        if(x==arr.length-1 && y==arr.length-1 && arr[x][y] == 1){
            sol[x][y] = 1;
            return true;
        }
        if(isSafe(arr, x, y)){
            if(sol[x][y] == 1){
                return false;
            }
            sol[x][y] = 1;
            if(solveRatMazeUtil(arr, x+1, y, sol)){
                return true;
            }
            if(solveRatMazeUtil(arr, x, y+1, sol)){
                return true;
            }
            sol[x][y] = 0;
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        // String D = "23";
        // letterCombo(D);
        // int arr[][] = new int[8][8];
        // for (int i=0; i<8; i++){
        //     for (int j=0; j<8; j++){
        //         arr[i][j] = -1;
        //     }
        // }
        // int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        // int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        // //starting from 0th case or 0th cell
        // arr[0][0] = 0;
        // if(SolveKnights(0, 0, 1, arr, xMove, yMove)==false){
        //     System.out.println("Solution does not exist");
        // }
        // else{
        //     printKnightsBoard(arr);

        // }

        int arr[][] = {{1,0,0,0},{1,1,0,1},{0,1,0,0},{1,1,1,1}};
        solveMaze(arr);


    }
}
