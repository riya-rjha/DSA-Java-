public class newCodes {
    
    //creating a linked list
    public static class Node{
        int data;
        Node next; //class object - reference pointer
        //constructor to store data and next
        public Node (int data){
            this.data = data;
            this.next = null;//initialization
        }
    }
    //creating head and tail for a linkedList
    public static Node head;
    public static Node tail;

    //Adding first element in a linked List
    public void addFirst(int data) {
        Node newNode = new Node(data);
        //base case
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    //Adding last element in a LinkedList
    public void addLast(int data) {
        Node newNode = new Node(data);
        //base case
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    //printing a LinkedList
    public void printLL() {
        //base case
        if(head == null){
            System.out.println("LinkedList is empty");
            return;
        }
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.print("null");

    }

    //Adding a newNode in the middle of a Linkedlist
    public void addMiddle(int idx, int data){
        //base case
        if(idx==0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int i=0;
        while(i<idx-1){
            temp = temp.next;
            i++;
        }
        //creating linkages
        newNode.next = temp.next;
        temp.next = newNode;
        
    }

    //calculating size of a linked list
    public int sizeLL() {
        Node temp = head;
        int size = 0;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        return size;
    }

    //remove first in LL
    public int removeFirst() {
        int val = head.data;
        head = head.next;
        return val;
    }

    //remove last in LL
    public void removeLast() {
        int size = sizeLL();
        //create a prev before tail and create linkages
        //using prev node and removal of tail takes place
        //through garbage collector
        Node prev = head;
        //tail = size-1 
        //prev = size-2
        for (int i=0; i<size-2; i++){
            prev = prev.next;
        }
        prev.next = null;
        tail = prev;
        
    }

    //Iterative search
    public int linearSearch(int key){
        Node temp = head;
        int i = 0;
        while(temp!=null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    //Recursive Search
    public int recursiveSearch(int key){
        return helper(head, key);
    }

    public int helper(Node head, int key){
        if(head==null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx == -1){
            return -1;
        }
        return idx + 1;
    }


    //Reversal of a LinkedList
    public void reversalLL() {
        //3 variable 4 step approach
        Node prev = null;
        Node curr = tail = head;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;//Last element of LL now becomes head
    }

    //Find and remove nth node from end
    public void deleteNthNodeFromEnd (int n){
        //calculate size of LL
        int size = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(n == size){
            //remove head
            head = head.next;
            return;
        }
        Node prev = head;
        for (int i=1; i<size - n; i++){
            prev = prev.next;
        }
        prev.next = prev.next.next;
    }

    //calculation of middleNode
    public Node findMidNode(Node head){
        Node slow = head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //Check if LL is palindrome or not 
    public boolean checkPalindromeLL() {
        if(head==null || head.next == null){
            //single or no element is considered as a palindrome
            return true;
        }
        Node midNode = findMidNode(head);
        //reverse the second half
        Node prev = null;
        Node curr = midNode;
        Node next;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        //creating left and right hand sides head nodes
        Node right = prev;
        Node left = head;
        //checking the equality of left and right halves
        while(right!=null){
            if(left.data!=right.data){
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        newCodes ll = new newCodes();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.printLL();
        System.out.println();
        ll.addMiddle(2, 3);
        ll.printLL();
        System.out.println(ll.sizeLL());
        ll.removeFirst();
        ll.printLL();
        System.out.println();
        ll.removeLast();
        ll.printLL();
        System.out.println();
        System.out.println("Key found at position : " + ll.linearSearch(4));
        System.out.println("Key found at position : " + ll.recursiveSearch(4));
        ll.reversalLL();
        ll.printLL();
        ll.addMiddle(0, 5);
        ll.addMiddle(4, 1);
        System.out.println();
        ll.printLL();
        System.out.println();
        ll.deleteNthNodeFromEnd(4);
        ll.printLL();
        newCodes ll2 = new newCodes();
        ll2.addFirst(1);
        ll2.addFirst(2);
        ll2.addFirst(1);
        System.out.println();
        ll2.printLL();
        boolean checkAns = ll2.checkPalindromeLL();
        if(checkAns){
            System.out.println("Second LinkedList is palindrome");
        }
        else{
            System.out.println("Second LinkedList is not palindrome");
        }
    }
}



