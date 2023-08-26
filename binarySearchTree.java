public class binarySearchTree {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    //Building a BST
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data>val){
            root.left = insert(root.left, val);
        }
        if(root.data<val){
            root.right = insert(root.right, val);
        }
        return root;
    }
    
    //Inorder sequence
    public static void InorderSeq(Node root){
        if(root == null){
            return;
        }
        InorderSeq(root.left);
        System.out.print(root.data+" ");
        InorderSeq(root.right);
        
    }

    public static void main(String[] args) {
        int val[] = {5, 1, 3, 4, 2, 7};
        Node root = null;
        for (int i=0; i<val.length; i++){
            root = insert(root, val[i]);
        }
        InorderSeq(root);
    }
}
