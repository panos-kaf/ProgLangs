import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystem;

class Node{
    int value;
    Node left,right;
    Node(int val){
        this.value = val;
        this.left=null;
        this.right=null;
    }
    public boolean leaf(){
        if (this.value==0) return false;
        if ((this.left==null  || this.left.value==0) &&
            (this.right==null || this.right.value==0)){
            return true;
        }
        return false;
    }
}

public class Worldtree {
    
    Node root;
    int size;
    
    public Worldtree(int n){
        this.size=n;
        this.root = null;
    }

    private boolean isFull(Node n){
        if(n.left!=null && n.right!=null)
        return n.left.value==0 && n.right.value==0 || (isFull(n.left) && isFull(n.right));
        else return false;
    }

    public void insert(int val){
        root = insert(root, val);
    }
    private Node insert(Node n, int val){
        if(n==null){
            n = new Node(val);
            return n;
        }
        if(n.value!=0){
            if (n.left == null){
                n.left = new Node(val);
                return n;
            }
            else if (n.left.value != 0 && !isFull(n.left)){
                n.left = insert(n.left,val);
            }
            else if (n.right == null){
                n.right = new Node(val);
                return n;
            }   
            else if (n.right.value != 0 && !isFull(n.right)){
                n.right = insert(n.right,val);
            }

        else{
            System.out.println("The Worldtree is full");
        }
    }
        return n; 
    }

    public void inorder(){
        inorder(this.root);
    }
    private void inorder(Node r){
    if(r!=null){
        inorder(r.left);
            if(r.value!=0){
                System.out.print(r.value + " ");
            }
        inorder(r.right);
        }
    }   

    private void swap(Node n){
        Node temp = n.right;
        n.right = n.left;
        n.left = temp;
    }

    private int smallestLeaf(Node n,int min){
        if(n==null) return min;

        if(n.leaf()){
            if(n.value<min){
                min = n.value;
            }
            return min;
        }
        min=smallestLeaf(n.left,min);
        min=smallestLeaf(n.right,min);
        return min;
    }

    public void solve(){
        solve(root);
        int L=smallestLeaf(root.left,size);
        int R=smallestLeaf(root.right,size);
        if(L>R) swap(root);
    }
    private void solve(Node n){
        if(n.left!=null && n.value!=0){
            solve(n.left);
            if(((n.left.value>n.right.value && n.right.value!=0) || 
               ((n.right.value<n.value && n.left.value==0))) ||
               ((n.left.value>n.value && n.right.value==0))){
                swap(n);
            }
            solve(n.right);
        }   
    }
    
    public static void main(String[] args){
        try{
            File inputFile = new File(args[0]);
            Scanner userInput = new Scanner(inputFile);
            int N = userInput.nextInt();
            Worldtree worldtree = new Worldtree(N);
            for(int i=0;i<N;){
                int n = userInput.nextInt();
                worldtree.insert(n);
                if(n!=0) i++;
            }
            userInput.close();
            worldtree.solve();
            worldtree.inorder();
        }
        catch(FileNotFoundException e){
            System.out.println("read error");
        }
    }
}