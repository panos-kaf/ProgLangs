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
        if ((this.left == null) || (this.right==null)) return true;
        return false;
    }
    public boolean leaf_for_insert(){

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

    public int min_Node(Node x, Node y){
        if(x!=null && y!=null){
        if(x.value<y.value) return x.value;
        return y.value;
        }
        if(x==null) return y.value;
        if(y==null) return x.value;
        return -1;
    }

    public int min(int x,int y){
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

    public int swap(Node n){
        Node temp = n.right;
        n.right = n.left;
        n.left = temp;

        int res=n.value;
        if (n.right!=null){
            res = min(n.right.value,n.value);
        }
        if (n.left!=null){
            res = min(n.left.value,res);
        }
        return res;
    }

    private int smallestLeaf(Node n,int min){
        if(n==null) return min;

        if(n.leaf() && n.value!=0 || (!n.leaf() && (n.left.value==0 ^ n.right.value==0))){
            if(n.value<min){
                min = n.value;
            }
            return min;
        }
        min=smallestLeaf(n.left,min);
        min=smallestLeaf(n.right,min);
        return min;
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

    public void TreePrint(){
        BTreePrinter.printNode(root);
    }

    public void solve(){
        solve(root,Integer.MAX_VALUE);
    }
    private int old_solve(Node n,int min){

        int minLeft = Integer.MAX_VALUE; //maybe minL=minR=min; ?
        int minRight = Integer.MAX_VALUE;

        if(n==null) return min;
        if(n.leaf()) return min(min,n.value);

        minRight = old_solve(n.right,minRight);
        minLeft = old_solve(n.left,minLeft);

        if((min(n.left.value,minLeft)>min(n.right.value,minRight)) && n.right!=null){
            swap(n);
            return min(n.left.value,minRight);
        }
        else if((min(n.left.value,minLeft)>n.value) && minRight==(Integer.MAX_VALUE)){
            swap(n);
            return n.value;
        }
        else if((min(n.right.value,minRight)<n.value) && minLeft==(Integer.MAX_VALUE)){
            swap(n);
            return min(n.left.value,minRight);
        }
        return min;
    }

    private int solve(Node n,int min){

        int minRight = Integer.MAX_VALUE;
        int minLeft = Integer.MAX_VALUE;

        if (n == null) return min;
        if (n.leaf()) return n.value;
       
        minRight = solve(n.right,minRight);
        minLeft = solve(n.left,minLeft);

        if (n.left != null && n.right != null){
            minRight = min(minRight, n.right.value);
            minLeft = min(minLeft, n.left.value);
            if(minRight<minLeft){
                swap(n);
            }
            return minLeft;
        }

        if (n.right != null && n.left == null){
            minRight = min(minRight, n.right.value);
            if(minRight<n.value){
                swap(n);
                return minRight;
            }
            return n.value;
        }

        if (n.left != null && n.right == null){
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
            int N = userInput.nextInt();
            Worldtree worldtree = new Worldtree(N);
            for(int i=0;i<2*N+1;i++){
                int n = userInput.nextInt();
                worldtree.insert(n);
            }
            userInput.close();

            worldtree.clean_up();

            worldtree.TreePrint();
            System.out.print("Initial: ");
            worldtree.inorder();

            worldtree.solve();

            worldtree.TreePrint();
            System.out.print("Solution: ");
            worldtree.inorder();
        }
        catch(FileNotFoundException e){
            System.out.println("Could not read file");
        }
    }
}