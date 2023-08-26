public class queues {

    static class Queues{
        //using arrays
        static int arr[];
        static int size;
        static int rear;

        //constructor
        Queues(int data){
            arr = new int[data];
            size = data;
            rear = -1;
        }

        //isEmpty()
        public boolean isEmpty() {
            return rear==-1;
        }

        //add()
        public void add(int data) {
            //using arrays size remains fixed
            if(rear==size-1){
                System.out.println("Queue is full");
                return;
            }
            rear = rear+1;
            arr[rear] = data;
        }

        //remove() -> O(n)
        public int remove() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            //shift the elements of array by 1 index
            for (int i=0; i<rear; i++){
                arr[i] = arr[i+1];
            }
            rear = rear-1;
            return front;
        }

        //peek 
        public int peek() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            //return front
            return arr[0];

        }

    }

    //Circular Queues using arrays
    static class CircularQueue{
        static int arr[];
        static int size;
        static int front;
        static int rear;
        //constructor
        CircularQueue(int n){
            arr = new int[n];
            size = n;
            front = -1;
            rear = -1;
        }
        //isEmpty()
        public boolean isEmpty() {
            return rear==-1 && front==-1;
        }

        // isFull()
        public static boolean isFull() {
            //both rear and front pointers at same position
            return (rear+1)%size==front;
        }

        //add()
        public void add(int data) {
            if(isFull()){
                System.out.println("Queue is full");
                return;
            }
            //adding 1st element ie front = -1
            if(front==-1){
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }


        //remove()
        public int remove() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            //removal of last element
            if(rear == front){
                rear = front = -1;
            }
            //removing front element
            int ans = arr[front];
            front = (front+1)%size;
            return ans;
        }

        //peek()
        public int peek() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int ans = arr[front];
            return ans;
        }

    }

    //LinkedLists
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    //Using LinkedLists
    static class QueueLL{
        static Node head = null;
        static Node tail = null;

        //isEmpty()
        public boolean isEmpty() {
            return head==null && tail==null;
        }

        //add()
        public void add(int data) {
            Node newNode = new Node(data);
            if(head==null){
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        //remove()
        public int remove() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            int front = head.data;
            //single element
            if(head == tail){
                head = tail = null;
                return head.data;
            }
            else{
                head = head.next;
            }
            return front;
        }

        //peek()
        public int peek() {
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }

    }

    public static void main(String[] args) {

        System.out.println("Queues using Arrays: ");
        Queues q = new Queues(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        while(!q.isEmpty()){
            System.out.print(q.peek()+" ");
            q.remove();
        }

        System.out.println("Circular Queues using Arrays: ");
        CircularQueue cq = new CircularQueue(5);
        cq.add(1);
        cq.add(2);
        System.out.println(cq.remove());
        cq.add(3);
        System.out.println(cq.remove());
        cq.add(4);


        System.out.println("Circular Queues using Linked Lists: ");
        QueueLL ql = new QueueLL();
        ql.add(1);
        ql.add(2);
        ql.add(3);
        ql.add(4);
        ql.add(5);
        System.out.println(ql.remove());
        System.out.println(ql.remove());

    }
}
