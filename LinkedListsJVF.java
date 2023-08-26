import java.util.LinkedList;
public class LinkedListsJVF {
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        //add
        ll.addFirst(4);
        ll.addFirst(3);
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);
        //1->2->3->4->5->null
        System.out.println(ll);
        //remove
        ll.removeFirst();
        //2->3->4->5->null
        ll.removeLast();
        //2->3->4->null
        System.out.println(ll);

    }
}
