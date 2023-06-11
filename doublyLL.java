public class doublyLL {

    public class Node{
        int data;
        Node next;
        Node prev;
        //constructor
        public Node(int data){
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    //Add first in LinkedList
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        //base case
        if(head==null){
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    //Printing the doubly LinkedList
    public void printDLL() {
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //Remove first from Doubly LinkedList
    public void removeFirst() {
        //base case
        if(head==null){
            System.out.println("Doubly LinkedList is empty");
            return;
        }
        head = head.next;
        head.prev = null;
        int size = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(size==1){
            head = tail = null;
            return;
        }

    }

    //Add last in Doubly LinkedList
    public void addLast(int data) {
        Node newNode = new Node(data);
        if(head==null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    //Remove last from Doubly LinkedList
    public void removeLast() {
        //base case
        if(head==null){
            System.out.println("Linked List is empty");
            return;
        }
        int size = 0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(size==1){
            head = tail = null;
            return;
        }
        Node previous = head;
        //tail = size-1
        //previous of tail = size-2
        for(int i=0; i<size-2; i++){
            previous = previous.next;
        }
        tail.prev = null;
        previous.next = null;
        tail = previous;
        
    }

    //reversal of a doubly LinkedList
    public void reverseDLL() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr!=null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }


    public static void main(String[] args) {
        doublyLL dll = new doublyLL();
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);
        dll.printDLL();
        dll.removeFirst();
        dll.printDLL();
        dll.addLast(4);
        dll.printDLL();
        dll.removeLast();
        dll.printDLL();
        dll.addFirst(3);
        dll.addFirst(4);
        dll.printDLL();
        dll.reverseDLL();
        dll.printDLL();
    }
}
