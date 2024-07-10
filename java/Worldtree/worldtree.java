import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

class Node{
    int value;
    Node left,right;

    Node(int val){
        this.value = val;
        this.left=null;
        this.right=null;
    }

    public boolean leaf(){
        return (this.left==null) && (this.right==null);
    }
    public boolean leaf_for_insert(){
        if (this.value==0) return true;
        if ((this.left == null) || (this.right==null)) return false;

        return (this.left.value==0) && (this.right.value==0);
    }
}

public class Worldtree {
    Node root; 

    public Worldtree(){
        this.root = null;
    }

    private int min(int x,int y){
        if(x<y) return x;
        return y;
    }

    private boolean isFull(Node n){
        if(n==null) return false;
        if(n.leaf_for_insert()) return true;
        return isFull(n.left) && isFull(n.right);
    }

    public void insert(int val){
        root = insert(root, val);
    }
    private Node insert(Node n, int val){
        if(n==null){
            n = new Node(val);
            return n;
        }
            if (n.left == null){
                n.left = new Node(val);
                return n;
            }
            else if (!isFull(n.left)){
                n.left = insert(n.left,val);
            }
            else if (n.right == null){
                n.right = new Node(val);
                return n;
            }   
            else if (n.right.value != 0){
                n.right = insert(n.right,val);
            }

        else{
            System.out.println("The Worldtree is full");
    }
        return n; 
    }

    public void inorder(){
        inorder(this.root);
        System.out.println();
    }
    private void inorder(Node r){
    if(r!=null){
        inorder(r.left);
        System.out.print(r.value + " ");
        inorder(r.right);
        }
    }   

    private void swap(Node n){
        Node temp = n.right;
        n.right = n.left;
        n.left = temp;
    }

    public void clean_up(){
        root = clean_up(root);
    }
    private Node clean_up(Node n){
        if(n == null) return null;

        n.left=clean_up(n.left);
        n.right=clean_up(n.right);
        if (n.value==0) return null; 

        return n;
    }

    public void solve(){
        solve(root,Integer.MAX_VALUE);
    }
    private int solve(Node n,int min){

        int minRight = Integer.MAX_VALUE;
        int minLeft = Integer.MAX_VALUE;

        if (n == null) return min;
        if (n.leaf()) return n.value;
       
        minRight = solve(n.right,minRight);
        minLeft = solve(n.left,minLeft);

        if ((n.left != null) && (n.right != null)){
            minRight = min(minRight, n.right.value);
            minLeft = min(minLeft, n.left.value);
            if(minRight<minLeft){
                swap(n);
            }
            return minLeft;
        }

        if ((n.right != null) && (n.left == null)){
            minRight = min(minRight, n.right.value);
            if(minRight<n.value){
                swap(n);
                return minRight;
            }
            return n.value;
        }

        if ((n.left != null) && (n.right == null)){
            minLeft = min(minLeft, n.left.value);
            if(n.value<minLeft){
                swap(n);
                return n.value;
            }
            return minLeft;
        }
        return min;
    }

    public static void main(String[] args){
        try{
            File inputFile = new File(args[0]);
            Scanner userInput = new Scanner(inputFile);

            Worldtree worldtree = new Worldtree();
            int N = userInput.nextInt();
            for(int i=0;i<2*N+1;i++) worldtree.insert(userInput.nextInt());

            userInput.close();
            worldtree.clean_up();
            worldtree.solve();
            worldtree.inorder();
        }
        catch(FileNotFoundException e){
            System.out.println("Could not read file");
        }
    }
}