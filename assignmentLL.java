public class assignmentLL {

    static class Node{
        int data;
        Node next;
        Node (int data){
            this.data = data;
            next = null;
        }
    }

    public Node getIntersection(Node head1, Node head2){
        //assuming 2nd LL to be bigger than first
        while(head2!=null)
        {
            Node temp = head1;
            while(temp!=null){
                if(temp == head2){
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        assignmentLL list = new assignmentLL();
        Node head1 = new Node(4);
        Node head2 = new Node(1);
        Node newNode = new Node(2);
        head2.next = newNode;
        newNode = new Node(3);
        head2.next.next = newNode;
        newNode = new Node(5);
        head1.next = newNode;
        newNode = new Node(6);
        head1.next.next = newNode;
        head2.next.next.next = newNode;
        newNode = new Node(7);
        head1.next.next.next = newNode;
        head1.next.next.next.next = null;
        Node pt = list.getIntersection(head1, head2);
        if(pt == null){
            System.out.println("No intersection point");
        }
        else{
            System.out.println("Intersection point is : " + pt.data);
        }

    }
}

