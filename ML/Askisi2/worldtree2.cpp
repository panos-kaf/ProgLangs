#include <iostream>

class node{
    public:
    int value;
    node* left;
    node* right;
    node (int val){
        value=val;
        left=nullptr;
        right=nullptr;
    }
    node* insert(int val,node* root);
    void inorder(node* root){
        if(root){
            inorder(root->left);
            std::cout<<root->value<<" ";
            inorder(root->right);
        }
        else std::cout<<"error...\n";
    }
};

node* insert(int val,node* root){
    if (root==nullptr) node* root= new node(val);

    else if(root->left->value!=0) insert(val,root->left);
    else if(root->right->value!=0) insert(val,root->right);
    else std::cout<<"The Worldtree is full\n";
    return root;
}

void node::inorder(node* root){
    if(root){
    inorder(root->left);
    std::cout<<root->value<<" ";
    inorder(root->right);
    }
    else std::cout<<"error..\n";
}

int main(){
    node* worldtree=nullptr;
    worldtree=insert(0,worldtree);
    worldtree=insert(0,worldtree);
    std::cout<<"hi..";
    inorder(worldtree);
    std::cout<<"hi again..\n";
}