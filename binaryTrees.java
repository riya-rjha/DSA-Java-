import java.util.*;
import java.util.HashMap;

public class binaryTrees {

    // creating a binaryTree
    static class Node {
        int data;
        Node left;
        Node right;

        // constructor
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Binary Trees Part 1
    // Root node of Binary Tree
    static class BinaryTree {
        static int idx = -1;

        public Node buildTrees(int nodes[]) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }
            Node newnode = new Node(nodes[idx]);
            newnode.left = buildTrees(nodes);
            newnode.right = buildTrees(nodes);
            return newnode;
        }
    }

    // Types of Traversals
    // Pre-order Traversal
    public static void preOrderTraversal(Node root) {
        if (root == null) {
            // System.out.print("-1 ");
            return;
        }
        System.out.print(root.data + " ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    // InOrder Traversal
    public static void inOrderTraversal(Node root) {
        if (root == null) {
            // System.out.print("-1 ");
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data + " ");
        inOrderTraversal(root.right);
    }

    // Post-Order Traversal
    public static void postOrderTraversal(Node root) {
        if (root == null) {
            // System.out.print("-1 ");
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data + " ");
    }

    // Level Order Traversal
    public static void levelTraversal(Node root) {
        // base case
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    // Height of a tree
    public static int height(Node root) {
        // base case
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return Math.max(lh, rh) + 1;

    }

    // Counting the number of nodes
    public static int noOFNodes(Node root) {
        // base case
        if (root == null) {
            return 0;
        }
        int leftCount = noOFNodes(root.left);
        int rightCount = noOFNodes(root.right);
        return leftCount + rightCount + 1;

    }

    // Calculating the sum of nodes
    public static int sumOFNodes(Node root) {
        // base case
        if (root == null) {
            return 0;
        }
        int leftSum = sumOFNodes(root.left);
        int rightSum = sumOFNodes(root.right);
        return leftSum + rightSum + root.data;
    }

    // Binary Trees - II
    // Diameter of a tree
    // Approach I
    public static int diameter(Node root) {
        // base case
        if (root == null) {
            return 0;
        }
        int ldia = diameter(root.left);
        int rdia = diameter(root.right);
        int lh = height(root.left);
        int rh = height(root.right);
        int self_diameter = lh + rh + 1;
        return Math.max(Math.max(rdia, ldia), self_diameter);
    }

    // Diameter of tree
    // Approach II
    // Create a class of Information that stores the diameter and height of
    // BinaryTree
    // To avoid repetitive function calls such as for height of tree
    static class Info {
        int diam;
        int ht;

        // Constructor
        Info(int d, int h) {
            this.diam = d;
            this.ht = h;
        }
    }

    public static Info diamterII(Node root) {
        // base case
        if (root == null) {
            return new Info(0, 0);
        }
        Info ldia = diamterII(root.left);
        Info rdia = diamterII(root.right);
        int self_dia = Math.max(Math.max(ldia.diam, rdia.diam), ldia.ht + rdia.ht + 1);
        int ht = Math.max(ldia.ht, rdia.ht) + 1;
        return new Info(self_dia, ht);
    }

    // Sub-Tree of another tree
    public static boolean isSubtree(Node root, Node subRoot) {
        // base case
        if (root == null) {
            return false;
        }
        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static boolean isIdentical(Node root, Node subRoot) {
        // Reached the end of iteration
        if (root == null || subRoot == null) {
            return true;
        }
        // Data not equal
        if (root.data != subRoot.data || root == null || subRoot == null) {
            return false;
        }
        // Data not correct for left part of BT
        if (!isIdentical(root.left, subRoot.left)) {
            return false;
        }
        // Data not correct for right part of BT
        if (!isIdentical(root.right, subRoot.right)) {
            return false;
        }
        // For none of the cases mentioned above
        return true;
    }

    // Top view of a Binary Tree
    static class Information {
        Node node;
        int hd;// Horizontal distance

        Information(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    // Using HashMap & Queue
    // Using level order traversal
    public static void topView(Node root) {
        Queue<Information> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();
        q.add(new Information(root, 0));
        q.add(null);
        int min = 0, max = 0;
        while (!q.isEmpty()) {
            Information currNode = q.remove();
            if (currNode == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                // Check if map contains HD or not
                if (!map.containsKey(currNode.hd)) {
                    map.put(currNode.hd, currNode.node);
                }
                // Check for left
                // i-1
                if (currNode.node.left != null) {
                    q.add(new Information(currNode.node.left, currNode.hd - 1));
                    min = Math.min(min, currNode.hd - 1);
                }
                // Check for right
                // i+1
                if (currNode.node.right != null) {
                    q.add(new Information(currNode.node.right, currNode.hd + 1));
                    max = Math.max(max, currNode.hd + 1);
                }
            }
        }
        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    // Binary Trees III
    // Kth level of a tree
    public static void kthLevel(Node root, int level, int K) {
        if (root == null) {
            return;
        }
        if (level == K) {
            System.out.print(root.data + " ");
            return;
        }
        kthLevel(root.left, level + 1, K);
        kthLevel(root.right, level + 1, K);
    }

    // Lowest Common Ancestor
    // Approach I
    public static Node lcaI(Node root, int n1, int n2) {
        //Creating ArrayList
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();
        getPath(root, n1, path1);
        getPath(root, n2, path2);
        int i = 0;
        for (; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }
        Node lca = path1.get(i - 1);
        return lca;

    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        if (root == null) {
            return false;
        }
        path.add(root);
        if (root.data == n) {
            return true;
        }

        boolean leftFound = getPath(root.left, n, path);
        boolean rightFound = getPath(root.right, n, path);
        if (leftFound || rightFound) {
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }

    //Lowest Common Ancestor
    //Approach II
    public static Node lcaII(Node root, int n1, int n2){
        //No usage of auxiliary memory
        if(root == null || root.data == n1 || root.data == n2){
            return root;
        }
        Node leftFound = lcaII(root.left, n1, n2);
        Node rightFound = lcaII(root.right, n1, n2);
        if(leftFound == null){
            return rightFound;
        }
        if(rightFound == null){
            return leftFound;
        }
        //When both are not null
        return root;

    }

    //Minimum distance between 2 Nodes
    public static int minDist (Node root, int n1, int n2){
        Node lca = lcaII(root, n1, n2);
        int d1 = getDist(lca, n1);
        int d2 = getDist(lca, n2);
        return d1 + d2;
    } 

    public static int getDist(Node root, int n){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftDist = getDist(root.left, n);
        int rightDist = getDist(root.right, n);
        if(leftDist == -1 && rightDist == -1){
            return -1;
        }
        else if(leftDist == -1){
            return rightDist + 1;
        }
        else{
            return leftDist + 1;
        }
    }

    //Kth ancestor of node
    public static int kthAncestor(Node root, int n, int k){
        if(root == null){
            return -1;
        }
        if(root.data == n){
            return 0;
        }
        int leftFound = kthAncestor(root.left, n, k);
        int rightFound = kthAncestor(root.right, n, k);
        if(leftFound == -1 && rightFound == -1){
            return -1;
        }
        int max = Math.max(leftFound, rightFound);
        if(max+1 == k){
            System.out.println(root.data+" ");
        }
        return max + 1;
    }

    //Transform to a sum Tree
    public static int transform(Node root){
        if(root == null){
            return 0;
        }
        int leftC = transform(root.left);
        int rightC = transform(root.right);
        int data = root.data;
        int leftSum = root.left == null?0 : root.left.data;
        int rightSum = root.right == null?0 : root.right.data;
        root.data = leftC + rightC + leftSum + rightSum;
        return data;
    }

    public static void main(String[] args) {
        /*
         * Binary Tree I codes
         * BinaryTree b1 = new BinaryTree();
         * int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
         * Node root = b1.buildTrees(nodes);
         * System.out.println(root.data);
         * preOrderTraversal(root);
         * System.out.println();
         * inOrderTraversal(root);
         * System.out.println();
         * postOrderTraversal(root);
         * System.out.println();
         * levelTraversal(root);
         * System.out.println("Height of tree : " + height(root));
         * System.out.println("No of nodes : " + noOFNodes(root));
         * System.out.println("Sum of nodes : " + sumOFNodes(root));
         * 
         */

        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        // Binary Tree II Codes
        // Node root2 = new Node(1);
        // root2.left = new Node(2);
        // root2.left.left = new Node(4);
        // root2.right = new Node(3);
        // root2.right.right = new Node(7);
        // root2.left.right = new Node(5);
        // root2.right.left = new Node(6);
        // System.out.println("Diameter of tree through ApproachI : " +
        // diameter(root2));
        // Info class diam is value of diameter else it prints the address of Binary
        // Tree
        // System.out.println("Diameter of tree through ApproachII : " +
        // diamterII(root2).diam);

        /*
         * 2
         * / \
         * 4 5
         */

        // Node root3 = new Node(2);
        // root3.left = new Node(4);
        // root3.right = new Node(5);
        // System.out.println("Subtree? : " + isSubtree(root2, root3));

        // topView(root2);

        // Binary Tree III Codes
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        Node root4 = new Node(1);
        root4.left = new Node(2);
        root4.left.left = new Node(4);
        root4.right = new Node(3);
        root4.right.right = new Node(7);
        root4.left.right = new Node(5);
        root4.right.left = new Node(6);

        kthLevel(root4, 1, 3);
        Node lca = lcaI(root4, 4, 5);
        System.out.println(lca.data+" ");
        Node lcaII = lcaII(root4, 4, 6);
        System.out.print(lcaII.data+" ");
        System.out.println(minDist(root4, 4, 6));
        System.out.println(kthAncestor(root4, 4, 2));
        System.out.println(transform(root4));
        preOrderTraversal(root4);
    }

}
