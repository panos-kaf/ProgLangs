#include <iostream>

class node
{
private:

public:
    int value;
    node* left;
    node* right;
    node(int val);
    void inorder(node* root);
    node* insert(node *root,int val);
};

node::node(int val)
{
    value=val;
    right->value=-1;
    left->value=-1;
}

void inorder(node* root){
    if (root){
    inorder(root->left);
    std::cout<<root->value<<" ";
    inorder(root->right);
    }
}

node* insert(node* root,int val){
    if (root==nullptr) root= new node(val);
    else if (root->left==nullptr) root->left=new node(val);
    else if (root->left->value!=0) insert(root->left,val);
    else if (root->right==nullptr) root->right=new node(val);
    else if (root->right->value!=0) insert(root->right,val);
    else std::cout<<"The Worldtree is full\n";

    return root;
}

int main(){
    node *worldtree=nullptr;
    int n;
    /*
    std::cin>>n;
    for(int i=0;i<n;i++){
        int val;
        std::cin>>val;
        worldtree=insert(worldtree,val);
    }
    */
   worldtree=insert(worldtree,1);
   // inorder(worldtree);
    std::cout<<'\n';
}
