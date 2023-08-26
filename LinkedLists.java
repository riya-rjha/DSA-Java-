public class LinkedLists {

    class Node {
        int data;
        Node next;// class Node object
        // constructor

        public Node(int data) {
            this.data = data;
            this.next = null;// Initialization of linked List
        }

    }

    // creating head and tail
    public Node head;
    public static Node tail;
    // size
    public static int size = 0;

    // Add first element in LinkedList
    public void addFirst(int data) {
        // step 1 : create a new node
        Node newNode = new Node(data);
        size++;
        // base case
        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step 2 : link head to new node's next
        newNode.next = head; // linkages formed
        // step 3 : head = newNode --> make newNode head as it is added at the first
        // place of linkedList
        head = newNode;
    }

    // Add last element in LinkedList
    public void addLast(int data) {
        Node nn = new Node(data);
        size++;
        if (head == null) {
            head = tail = nn;
            return;
        }
        tail.next = nn;
        tail = nn;
    }

    // printing a linked list
    public void print() {
        Node temp = head;
        // base case
        if (head == null) {
            System.out.println("LL is empty");
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    // Add in the middle of LL
    public void add(int idx, int data) {
        size++;
        // creating a newNode
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        // creating linkages between temp and newNode
        newNode.next = temp.next;
        temp.next = newNode;

    }

    // remove first in LL
    // deleting head node
    public int delFirst() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val2 = head.data;
            head = tail = null;
            size = 0;
            return val2;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    // remove last in LL
    // deleting tail of linked List
    public int delLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;
        }
        // tail = size - 1
        // prev = size - 2
        Node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;// tail.data value stored in val variable
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    // Iterative search
    public int IterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) { // till iterations reach upto tail
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;

    }

    // recursive search
    public int recursiveSearch(int key) {
        return helper(head, key);
    }

    // helper function
    public int helper(Node head, int key) {
        if (head == null) {
            return -1;
        }
        if (head.data == key) { // moment where key is found return index as 0 and then keep on incrementing
                                // till 0th value of node
            return 0;
        }
        int idx = helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    // reversing a linked list
    // 3 variable 4 step approach
    public void reversal() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // removal of nth node from fast
    // nth node from fast == (size-n-1)th node from the slow
    public void delNode(int n) {
        // calculate size
        int sz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) { // removed head
            head = head.next;
            return;
        }
        int i = 1;
        Node prev = head;
        while (i < (size - n)) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;// prev next will be linked to prev next to next
    }

    // to check if LL is palindrome or not
    /*
     * Step 1 : Find midNode
     * Step 2 : Reverse the second half
     * Step 3 : Check for left end and right end
     */

    // slow fast
    public Node midNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean checkPalindrome() {
        // base case
        // if LL is empty or contains only one element then return true
        if (head == null || head.next == null) {
            return true;
        }
        // calculating middleNode
        Node middleNode = midNode(head);
        Node prev = null;
        Node curr = middleNode;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node leftN = head; // left hand side node
        Node rightN = prev;// right hand side node
        // checking for left half and right half
        while (rightN != null) { // until it reaches tail
            if (leftN.data != rightN.data) {
                return false;
            }
            leftN = leftN.next;
            rightN = rightN.next;
        }
        return true;
    }

    // MergeSort Code
    /*
     * Step 1 : To calculate midNode and separate into two halves
     * Step 2 : Calling mergeSort for left and right half to return single values of
     * heads
     * Step 3 : Combining head1 and head2 to merge
     */

    private Node getMidNode(Node head) {
        Node slow = head;
        Node fast = head.next; // to get last of first half as mid
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node mergeSortNode(Node head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }
        // calculate midNode
        Node mid = getMidNode(head);
        // created two left and right halves of LinkedList
        Node rightHead = mid.next;
        mid.next = null;
        Node leftPart = mergeSortNode(head);
        Node rightPart = mergeSortNode(rightHead);
        return merge(leftPart, rightPart);
    }

    private Node merge(Node head1, Node head2) {
        // creating a temporary LinkedList space to compare data
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;
        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                temp = temp.next;
                head1 = head1.next;
            } else {
                temp.next = head2;
                temp = temp.next;
                head2 = head2.next;
            }
        }
        // For all the remaining elements
        while (head1 != null) {
            temp.next = head1;
            temp = temp.next;
            head1 = head1.next;
        }
        while (head2 != null) {
            temp.next = head2;
            temp = temp.next;
            head2 = head2.next;
        }
        // because first element is -1
        return mergedLL.next;
    }

    // Zig - zag LinkedList
    /*
     * Step 1 : Calculate midNode
     * Step 2 : Reverse second half
     * Step 3 : Apply zig-zag algorithm
     */

    public void zigZagLL() {
        Node mid = getMidNode(head);
        // reversing second half of LinkedList
        Node prev = null;
        Node curr = mid.next;
        mid.next = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node left = head;
        Node right = prev;
        Node leftH, rightH;
        while (left != null && right != null) {
            leftH = left.next;
            left.next = right;
            rightH = right.next;
            right.next = leftH;
            // Updation
            left = leftH;
            right = rightH;
        }

    }

    public static void main(String[] args) {
        LinkedLists ll = new LinkedLists();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(4);
        ll.addLast(5);
        ll.print();
        ll.add(2, 3);
        ll.print();
        System.out.println("Size of linkedList : " + size);
        ll.delFirst();
        ll.print();
        System.out.println("Size of linkedList : " + size);
        ll.delLast();
        ll.print();
        System.out.println("Size of linkedList : " + size);
        System.out.println("Index of key element using Linear search is : " + ll.IterativeSearch(3));
        System.out.println("Index of key element using Recursive search is : " + ll.recursiveSearch(3));
        ll.reversal();
        ll.print();
        ll.delNode(3);
        ll.print();
        ll.addFirst(4);
        ll.addFirst(5);
        ll.add(4, 1);
        ll.print();
        LinkedLists ll2 = new LinkedLists();
        ll2.addFirst(1);
        ll2.addFirst(2);
        ll2.addFirst(1);
        ll2.print();
        boolean ans = ll2.checkPalindrome();
        System.out.println("Is the above LinkedList a palindrome ? : " + ans);
        // mergeSort
        ll.head = ll.mergeSortNode(ll.head);
        ll.print();
        // zig zag linkedList
        ll.zigZagLL();
        ll.print();

    }
}
