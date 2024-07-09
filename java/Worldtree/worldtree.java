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
        if (this.value==0) return true;

        if ((this.left == null) || (this.right==null)) return false;

        if ((this.left.value==0) && (this.right.value==0)) return true;

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
        if(n==null) return false;

        if(n.leaf()) return true;

        return isFull(n.left) && isFull(n.right);}

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

    public void swap(Node n){
        Node temp = n.right;
        n.right = n.left;
        n.left = temp;
    }

    private int smallestLeaf(Node n,int min){
        if(n==null) return min;

        if(n.leaf() && n.value!=0){
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
        int L=smallestLeaf(root.left,size+1);
        int R=smallestLeaf(root.right,size+1);
        if((L>R && L!=(size+1)) || (L==(size+1) && R<root.value) || R ==(size+1) && L>root.value){
            swap(root);
        }
    }
    private void solve(Node n){
        if(n.left!=null && n.value!=0){
            solve(n.left);
            if (((n.left.value>n.right.value && n.right.value!=0) || 
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
            for(int i=0;i<2*N+1;i++){
                int n = userInput.nextInt();
                worldtree.insert(n);
            }
            userInput.close();
            worldtree.solve();
            worldtree.inorder();
        }
        catch(FileNotFoundException e){
            System.out.println("Could not read file");
        }
    }
}