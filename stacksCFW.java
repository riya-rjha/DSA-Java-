import java.util.Stack;
public class stacksCFW {

    //push an integer in the bottom of the stack
    public static void pushAtBottom(Stack<Integer>s, int data) {
        //base case
        if(s.isEmpty()){
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }

    //reversing a string using stacks
    public static String revString(String str) {
        Stack<Character>s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            s.push(str.charAt(i));
        }
        StringBuilder sb = new StringBuilder("");
        while(!s.isEmpty()){
            char top = s.pop();
            sb.append(top);
        }
        return sb.toString();
    }

    //reverse stack using concept of stack
    public static void reverseStack(Stack<Integer>s) {
        //base case
        if(s.isEmpty()){
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);       
    }

    //StockSpan Problem
    //max no of consecutive days for which price<=today's price
    //BP<=SP
    public static void stockSpanProb(int arr[], int span[]){
        span[0] = 1;
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for(int i=1; i<span.length; i++){
            int currPrice = arr[i];
            while(!s.isEmpty() && currPrice>arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                //last element
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }

    }

    //Next Greater Element (Right)
    public static void nextGreaterElement(int arr[]){
        int nextG[] = new int[arr.length];
        Stack<Integer>s = new Stack<>();
        for (int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[i]>=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nextG[i] = -1;
            }
            else{
                nextG[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for (int i=0; i<nextG.length; i++){
            System.out.print(nextG[i]+" ");
        }
    }

    

    //Valid Parentheses
    public static boolean validParentheses(String str) {
        Stack<Character>s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            //opening condition
            if(ch=='(' || ch=='{' || ch=='['){
                s.push(ch);
            }
            else{
                if(s.isEmpty()){
                    //opening brackets only no closing brackets or vice versa
                    return false;
                }
                //condition for opening and closing
                if((ch==')' && s.peek()=='(') || (ch=='}' && s.peek()=='{') || (ch==']' && s.peek()=='[')){
                    s.pop();
                }
                else{
                    return false;
                }
            }
        }
        if(s.isEmpty()){
            return true;
        }
        return false;
    }


    //Duplicate Parentheses
    public static boolean duplicateParentheses(String str) {
        Stack<Character>s = new Stack<>();
        for (int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch==')'){
                int count = 0;
                while (s.peek()!='(') {
                    s.pop();
                    count++;
                }
                if(count<1){
                    //double parentheses
                    return true;
                }
                else{
                    s.pop();
                }
            }
            else{
                s.push(ch);
            }
        }return false;
    }



    //Max Area in Histogram
    public static void maxArea(int arr[]) {
        int nsl[] = new int[arr.length];
        int nsr[] = new int[arr.length];
        int maxArea = 0;
        //Next smaller right
        Stack<Integer>s = new Stack<>();
        for (int i = arr.length-1; i>=0; i--){
            while (!s.isEmpty() && arr[i]<=arr[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = arr.length;
            }
            else{
                nsr[i] = s.peek();
            }
            s.push(i);
        }

        //Next smaller left
        //Emptying the old stack
        s = new Stack<>();
        for (int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[i]<=arr[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = -1;
            }
            else{
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        //width = j - i - 1
        //width = nsr[i] - nsl[i] - 1
        for (int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height*width;
            maxArea = Math.max(maxArea, currArea);
        }
        System.out.println("Max area obtained is : " + maxArea);

    }


    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        pushAtBottom(s, 0);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }
        //Stack becomes empty
        s.push(4);
        s.push(5);
        s.push(6);
        String str = "riya";
        System.out.println(revString(str));
        reverseStack(s);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }

        //Stock Span problem
        int stocks[] = {100, 80, 60, 70, 60, 85, 100};
        int span[] = new int[stocks.length];
        stockSpanProb(stocks, span);
        for (int i=0; i<span.length; i++){
            System.out.print(span[i]+" ");
        }
        System.out.println();

        //Next Greater Element
        int arr[] = {6, 8, 0, 1, 3};
        nextGreaterElement(arr);
        System.out.println();

        //Valid Parentheses
        String string = "()[{(])}]";//false
        System.out.println(validParentheses(string));
        
        //Duplicate Parentheses
        String dupStr = "(((a+b) + (c+d)))";//true
        System.out.println(duplicateParentheses(dupStr));

        //Max area in histogram
        int heights[] = {2, 1, 5, 6, 2, 3};
        maxArea(heights);
    }
}
