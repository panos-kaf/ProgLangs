
class node{
	int value;
	node left,right;

	public node(int val){
		value=val;
		left=null;
		right=null;
	}
}

public class worldtree{
	
	public static node insert(node root,int val){
		if (root==null){
			root=new node(val);
			return root;
		}
