import java.util.*;

//Binary Search Trees I
public class binarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Building a BST
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        }
        if (root.data < val) {
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Inorder sequence
    public static void InorderSeq(Node root) {
        if (root == null) {
            return;
        }
        InorderSeq(root.left);
        System.out.print(root.data + " ");
        InorderSeq(root.right);

    }

    public static boolean BSTSearch(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return BSTSearch(root.left, key);
        }
        return BSTSearch(root.right, key);
    }

    // Deleting a node
    public static Node deleteNode(Node root, int val) {
        if (root.data < val) {
            root.right = deleteNode(root.right, val);
        } else if (root.data > val) {
            root.left = deleteNode(root.left, val);
        } else {
            // Case 1 : Only null as leaves
            if (root.left == null && root.right == null) {
                return null;
            }
            // Case 2 : Only one child is null and the other has a valid data
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // Case 3 : Both childs have valid data
            Node inOrder = findInorderSuccessor(root.right);
            root.data = inOrder.data;
            root.right = deleteNode(root.right, inOrder.data);
        }
        return root;
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Printing in a range
    public static void printRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printRange(root.left, k1, k2);
        } else {
            printRange(root.right, k1, k2);
        }
    }

    // Root to leaf path
    // max possible values
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void rootTOleaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            printPath(path);
        }

        rootTOleaf(root.left, path);
        rootTOleaf(root.right, path);
        path.remove(path.size() - 1);
    }

    // Check for a valid BST
    // Validate BST
    public static boolean validateBST(Node root, Node min, Node max) {
        if (root == null) {
            // one root is always balanced
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }
        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }

    // Mirror Sequence
    public static Node mirrorSeq(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMirror = mirrorSeq(root.left);
        Node rightMirror = mirrorSeq(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    // Pre order sequence
    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // Binary Search Trees II
    // Sorted array to a balanced binary search tree
    // using arrays
    public static Node createBalancedBST(int arr[], int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBalancedBST(arr, si, mid - 1);
        root.right = createBalancedBST(arr, mid + 1, ei);
        return root;
    }

    // Create a BST
    // Using arrayLists
    public static Node createsBST(ArrayList<Integer> path, int si, int ei) {
        if (si > ei) {
            return null;
        }
        int mid = (si + ei) / 2;
        Node nn = new Node(path.get(mid));
        nn.left = createsBST(path, si, mid - 1);
        nn.right = createsBST(path, mid + 1, ei);
        return nn;
    }

    // create a BST into a sorted BST
    public static Node createBSTBalanced(Node root) {
        // Step 1 : Inorder sequence
        ArrayList<Integer> path = new ArrayList<>();
        findInorderSequence(root, path);

        // Step 2 : Create Balanced BST from sorted arrayList
        root = createsBST(path, 0, path.size() - 1);
        return root;
    }

    // Finding Inorder sequence using an arrayList
    public static void findInorderSequence(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        findInorderSequence(root.left, path);
        path.add(root.data);
        findInorderSequence(root.right, path);
    }

    // Size of largest BST in a Binary Tree
    static class Info {
        boolean isBST;
        int size;
        int min;
        int max;

        Info(boolean isBST, int size, int min, int max) {
            this.isBST = isBST;
            this.size = size;
            this.min = min;
            this.max = max;
        }
    }

    public static int maxBST = 0;

    public static Info largestBST(Node root) {
        if (root == null) {
            return new Info(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        // check for valid BST
        Info leftSide = largestBST(root.left);
        Info rightSide = largestBST(root.right);
        int size = leftSide.size + rightSide.size + 1;
        int min = Math.min(root.data, Math.min(leftSide.min, rightSide.min));
        int max = Math.max(root.data, Math.max(leftSide.max, rightSide.max));
        if (root.data <= leftSide.max || root.data >= rightSide.min) {
            return new Info(false, size, min, max);
        }
        if (leftSide.isBST && rightSide.isBST) {
            maxBST = Math.max(maxBST, size);
            return new Info(true, size, min, max);
        }
        return new Info(false, size, min, max);

    }

    // Merging two BSTS
    // createBST() & findInorderSequence()
    public static Node mergeBSTS(Node root1, Node root2) {
        // Step 1 : Get inorder sequences for both roots
        // in the form of an arrayList
        ArrayList<Integer> list1 = new ArrayList<>();
        findInorderSequence(root1, list1);
        ArrayList<Integer> list2 = new ArrayList<>();
        findInorderSequence(root2, list2);

        // Step 2 : Merge both the arrayLists
        ArrayList<Integer>path = new ArrayList<>();
        int i=0, j=0;
        while(i<list1.size() && j<list2.size()){
            if(list1.get(i)<=list2.get(j)){
                path.add(list1.get(i));
                i++;
            }
            else{
                path.add(list2.get(j));
                j++;
            }
        }
        while(i<list1.size()){
            path.add(list1.get(i));
            i++;
        }
        while(j<list2.size()){
            path.add(list2.get(j));
            j++;
        }

        // Step 3 : Create a merged array and find a BST balance for it
        return createsBST(path, 0, path.size()-1);
    }

    public static void main(String[] args) {
        int val[] = { 1, 3, 4, 6, 5, 8, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < val.length; i++) {
            root = insert(root, val[i]);
        }
        InorderSeq(root);
        System.out.println();
        System.out.println(BSTSearch(root, 14));
        deleteNode(root, 5);
        InorderSeq(root);
        System.out.println();

        /*
         *  8
         * / \
         * 5 10
         * / \ \
         * 3 6 11
         * /\    \
         * 1 4   14
         */

        Node root2 = new Node(8);
        root2.left = new Node(5);
        root2.right = new Node(10);
        root2.left.left = new Node(3);
        root2.left.right = new Node(6);
        root2.left.left.left = new Node(1);
        root2.left.left.right = new Node(4);
        root2.right.right = new Node(11);
        root2.right.right.right = new Node(14);
        printRange(root2, 5, 12);
        System.out.println();
        rootTOleaf(root2, new ArrayList<>());
        boolean isAns = validateBST(root2, null, null);
        System.out.println(isAns);
        mirrorSeq(root2);
        preOrder(root2);
        System.out.println();

        /*
         *  8
         * / \
         * 5  11
         * /\  / \
         * 3 6 10 12
         */

        Node root3 = new Node(8);
        root3.left = new Node(5);
        root3.right = new Node(11);
        root3.left.left = new Node(3);
        root3.left.right = new Node(6);
        root3.right.left = new Node(10);
        root3.right.right = new Node(12);

        int arr[] = { 1, 5, 6, 7, 8, 2, 4, 3, 9 };
        int si = 0;
        int ei = arr.length - 1;
        preOrder(createBalancedBST(arr, si, ei));
        System.out.println();

        Node root4 = new Node(8);
        root4.left = new Node(6);
        root4.left.left = new Node(5);
        root4.left.left.left = new Node(3);
        root4.right = new Node(10);
        root4.right.right = new Node(11);
        root4.right.right.right = new Node(12);
        preOrder(createBSTBalanced(root4));
        System.out.println();

        /*
         *  50
         * /  \
         * 30  60
         * / \  / \
         * 5 20 45 70
         * /  \
         * 65 80
         * 
         */

        Node root5 = new Node(50);
        root5.left = new Node(30);
        root5.right = new Node(60);
        root5.left.left = new Node(5);
        root5.left.right = new Node(20);
        root5.right.left = new Node(45);
        root5.right.right = new Node(70);
        root5.right.right.left = new Node(65);
        root5.right.right.right = new Node(80);
        largestBST(root5);
        System.out.println(maxBST);

        //Merged BSTS
        Node root6 = new Node(2);
        root6.left = new Node(1);
        root6.right = new Node(4);
        Node root7 = new Node(9);
        root7.left = new Node(3);
        root7.right = new Node(12);
        Node root_merge = mergeBSTS(root6, root7);
        preOrder(root_merge);
    }
}
