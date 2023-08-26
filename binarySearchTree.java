import java.util.ArrayList;

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
        }
        else if (root.data > val) {
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

    //Printing in a range
    public static void printRange(Node root, int k1, int k2){
        if(root == null){
            return;
        }
        if(root.data>=k1 && root.data<=k2){
            printRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            printRange(root.right, k1, k2);
        }
        else if(root.data<k1){
            printRange(root.left, k1, k2);
        }
        else{
            printRange(root.right, k1, k2);
        }
    }    

    //Root to leaf path 
    //max possible values
    public static void printPath(ArrayList<Integer>path){
        for (int i=0; i<path.size(); i++){
            System.out.print(path.get(i)+" ");
        }
        System.out.println();
    }

    public static void rootTOleaf(Node root, ArrayList<Integer>path){
        if(root == null){
            return;
        }
        path.add(root.data);
        if(root.left == null && root.right == null){
            printPath(path);
        }
        
        rootTOleaf(root.left, path);
        rootTOleaf(root.right, path);
        path.remove(path.size()-1);
    }

    //Check for a valid BST
    //Validate BST
    public static boolean validateBST(Node root, Node min, Node max){
        if(root == null){
            //one root is always balanced
            return true;
        }
        if(min!=null && root.data<=min.data){
            return false;
        }
        if(max!=null && root.data>=max.data){
            return false;
        }
        return validateBST(root.left, min, root) && validateBST(root.right, root, max);
    }

    //Mirror Sequence
    public static Node mirrorSeq(Node root){
        if(root == null){
            return null;
        }
        Node leftMirror = mirrorSeq(root.left);
        Node rightMirror = mirrorSeq(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }

    //Pre order sequence 
    public static void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    //Binary Search Trees II
    //Sorted array to a balanced binary search tree

    public static void main(String[] args) {
        int val[] = {1, 3, 4, 6, 5, 8, 10, 11, 14 };
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

    /*              8
                  /   \
                 5     10
                / \     \
               3   6     11
              / \         \
             1   4        14 
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
        System.out.println();
        mirrorSeq(root2);
        preOrder(root2);
    }
}
