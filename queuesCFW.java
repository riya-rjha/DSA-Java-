import java.util.*;

public class queuesCFW {

    // creating a queue using 2 stacks s1 and s2
    static class Queues {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        // isEmpty()
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add->O(n)
        public void add(int data) {
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove
        public int remove() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.pop();
        }

        // peek
        public int peek() {
            if (s1.isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return s1.peek();
        }
    }

    // creating a stack using 2 queues
    static class Stacks {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        // isEmpty()
        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // add()->O(1)
        public void add(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        // pop()->O(n)
        public int pop() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int top = -1;
            // Case - 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }
            }
            // Case - 2
            else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }
            }
            return top;
        }

    }

    public static void printNonRepeating(String str) {
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;
            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }

    }

    public static void interLeave(Queue<Integer> q) {
        Queue<Integer> firstH = new LinkedList<>();
        int size = q.size();
        // adding first half elements in Queue firstH
        for (int i = 0; i < size / 2; i++) {
            firstH.add(q.remove());
        }
        while (!firstH.isEmpty()) {
            q.add(firstH.remove());
            q.add(q.remove());
        }
    }

    // Queue reversal
    public static void queueReversal(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }

    }

    public static void main(String[] args) {

        Queues q = new Queues();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.remove();
        System.out.println(q.peek());

        Stacks s = new Stacks();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        s.pop();
        s.pop();
        System.out.println(s.pop());

        String str = "aabccxb";
        printNonRepeating(str);

        Queue<Integer> q2 = new LinkedList<>();
        q2.add(1);
        q2.add(2);
        q2.add(3);
        q2.add(4);
        q2.add(5);
        q2.add(6);
        q2.add(7);
        q2.add(8);
        q2.add(9);
        q2.add(10);
        interLeave(q2);
        System.out.println();
        while (!q2.isEmpty()) {
            System.out.print(q2.remove() + " ");
        }
        System.out.println("Reversed Queue : ");
        Queue<Integer> q3 = new LinkedList<>();
        q3.add(1);
        q3.add(2);
        q3.add(3);
        q3.add(4);
        q3.add(5);
        queueReversal(q3);

    }
}
