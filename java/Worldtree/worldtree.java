import java.util.*;


class Node{
    int value;
    Node left,right;
    Node(int val){
        this.value = val;
        this.left=this.right=null;
    }
}

public class Worldtree {
    
    Node root;

    public Worldtree(){
        this.root = null;
    }

    public void insert(Node r,int val){
        if(r==null){ 
            r = new Node(val);
        }
        else if (r.left==null) r.left = new Node(val);
        else if (r.left.value!=0) insert(r.left,val);
        else if (r.right==null) r.right = new Node(val);
        else if (r.right.value!=0) insert(r.right,val);
        else {
            System.out.println("The Worldtree is full");
        }
    }

    public void inorder(Node r){
    if(r!=null){
        inorder(r.left);
            if(r.value!=0){
                System.out.print(r.value + " ");
            }
        inorder(r.right);
        }
    }   

    public static void main(String[] args) {

        Worldtree worldtree = new Worldtree();
        wordltree.insert(worldtree.root,1);
        wordltree.insert(worldtree.root,3);
        wordltree.insert(worldtree.root,4);
        wordltree.insert(worldtree.root,5);
        wordltree.insert(worldtree.root,6);
        wordltree.insert(worldtree.root,0);
        wordltree.insert(worldtree.root,0);
        wordltree.insert(worldtree.root,0);
        wordltree.insert(worldtree.root,0);
        worldtree.inorder(worldtree.root);
    }

}
