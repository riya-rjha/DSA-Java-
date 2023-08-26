import java.util.*;
public class stacks {

    static class StacksArrLists{
        static ArrayList<Integer> list = new ArrayList<>();

        //check for size of string
        public boolean isEmpty() {
            //returns true if list.size() == 0
            return list.size() == 0;
        }

        //push an element 
        public void push(int data) {
            list.add(data);
        }

        //pop an element
        public void pop(){
            if(isEmpty()){
                return;
            }
            list.remove(list.size()-1);
        }

        //peek an element
        public int peek() {
            return list.get(list.size()-1);
        }
    }

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    static class StacksLinkedLists{
        static Node head = null;
        
        //To check size of LL
        public static boolean isEmpty() {
            //returns true if head == null ie LL is empty
            return head == null;
        }

        //push an element 
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }

        //pop an element
        public static void pop() {
            if(isEmpty()){
                return;
            }
            //previous linkage broken thus new head is element next to the head
            head = head.next;
        }

        //peek an element
        public static int peek() {
            return head.data;
        }
    }


    public static void main(String[] args) {
        StacksArrLists s = new StacksArrLists();
        s.push(1);
        s.push(2);
        s.push(3);
        while(!s.isEmpty()){
            System.out.println(s.peek());
            s.pop();
        }

        StacksArrLists s2 = new StacksArrLists();
        s2.push(4);
        s2.push(5);
        s2.push(6);
        while (!s2.isEmpty()) {
            System.out.println(s2.peek());
            s2.pop();
        }

    }
}