import java.util.*;

public class node{
    int value;
    node left;
    node right;

    public node(int val){
        this.value = val;
        this.left = null;
        this.right = null;
    }

    node insert(node root, int val){

        if(root == null){
            root = new node(val);
        }

        else if(root.value!=0){

            if(root.left==null){
                root.left = new node(val);
                return root;
            }
            else if(root.left.value!=0){
                if(insert(root.left,val)!=null){
                    return root;
                }
            }
            if(root.right==null){
                root.right = new node(val);
                return root;
            }
            else if(root.right.value!=0){
                if(insert(root.right,val)!=null){
                    return root;
                }    
            }
            return null;
        }
    }

    void inorder(node r){
        if(r!=null){
            inorder(r.left);
            if(r.value!=0){
                System.out.print(r.val + " ");
            }
            inorder(r.right);
        }
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner(System.in);
        int N = userInput.nextInt();
        node worldtree = null;
        for(int i=0;i<2*N+1;i++){
            worldtree.insert(worldtree,userInput.nextInt());
        }
        userInput.close();
        worldtree.inorder(worldtree);
    }
}