
public class LinkedListPartII {

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public static boolean findCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        boolean cycle = false;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                cycle = true;
                break;
            }
        }
        if (!cycle) {
            return;
        }
        Node prev = null;
        slow = head;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = null;
    }

    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
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
        while (fast.next != null && fast != null) {
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
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // printLL();
        // printing a LinkedList with cycle will result into an infinite loop
        removeCycle();
        printLL();

    }
}
