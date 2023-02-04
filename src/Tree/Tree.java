package Tree;

import java.util.Arrays;
import java.util.Scanner;

public class Tree {

    static Node root;
    public static class Node{
        int data;
        Node left,right;
        Node(int x){
            this.data = x;
        }
    }


    public static Node insert(int data, Node root){
        if(root == null){
            debug("YES null");
            root = new Node(data);
            root.left =null;
            root.right=null;
            return root;
        }
        debug("Not null");
        if(data > root.data){
//            if(root.right == null) root.right = new Node(data);
//            else
            root.right = insert(data,root.right);
        }
        else {
//            if(root.left == null) root.left = new Node(data);
//            else
            root.left = insert(data,root.left);
        }
        return root;
    }

    public static void printTree(Node root){
        //In order
        if(root==null) return;
        printTree(root.left);
        System.out.print(root.data+" ");
        printTree(root.right);
    }

    public static void initRoot() {
        root = null;
    }

    public static boolean search(int val,Node root){
        if(root == null) return false;
        if(root.data == val) return true;
        if(val>root.data) return search(val, root.right);
        else return search(val,root.left);
    }

    static Node delete(Node root,int val){

        if(root == null) return root;
        else {
            //First search and then del

            if(val == root.data){
                if(root.left == null && root.right == null) root=null;
                else if(root.left == null) root=root.right;
                else if(root.right == null) root = root.left;
                else {
                    // go at the leaf node at right and del that node and copy that node's content to current node

                    Node temp= root.right;
                    while (temp.left != null) temp=temp.left;
                    root.data = temp.data;
                    temp = null;
                }

            }
            else if(val > root.data) root.right = delete(root.right,val);  // search part
            else root.left = delete(root.left,val);
        }
        return root;
    }

    static void debug(Object... o){
        if(o.length != 0) System.err.println(Arrays.deepToString(o));
        else System.err.println();
    }
    public static void main(String[] args) {
        initRoot();
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        while (n-- > 0){
            int x=sc.nextInt();
            root = insert(x,root);
            printTree(root);
        }
        System.out.println("Search ");
        System.out.println(search(sc.nextInt(),root));
        System.out.println("Delete ");
        root = delete(root, sc.nextInt());
        printTree(root);
    }
}
