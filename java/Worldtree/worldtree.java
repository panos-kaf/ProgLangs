import java.util.*;

class Node{
    int value;
    Node left,right;
    Node(int val){
        this.value = val;
        this.left=null;
        this.right=null;
    }
}

public class Worldtree {
    
    Node root;
    int size;

    public boolean isFull(Node n){
        if(n.left!=null && n.right!=null)
        return n.left.value==0 && n.right.value==0 || (isFull(n.left) && isFull(n.right));
        else return false;
    }

    public Worldtree(int n){
        this.size=n;
        this.root = null;
    }

    public void insert(int val){
        root = insertHelper(root, val);
    }

    public Node insertHelper(Node n, int val){
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
                n.left = insertHelper(n.left,val);
            }
            else if (n.right == null){
                n.right = new Node(val);
                return n;
            }   
            else if (n.right.value != 0 && !isFull(n.right)){
                n.right = insertHelper(n.right,val);
            }

        else{
            System.out.println("The Worldtree is full");
        }
    }
        return n; 
    }

    public void inorder(){
        inorderHelper(this.root);
    }
    public void inorderHelper(Node r){
    if(r!=null){
        inorderHelper(r.left);
            if(r.value!=0){
                System.out.print(r.value + " ");
            }
        inorderHelper(r.right);
        }
    }   
    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int N = userInput.nextInt();
        Worldtree worldtree = new Worldtree(N);
        for(int i=0;i<2*N+1;i++){
            worldtree.insert(userInput.nextInt());
        }
        userInput.close();
        worldtree.inorder();
    }

}