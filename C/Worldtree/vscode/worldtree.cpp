#include <iostream>

#define N 1000000

class node
{
private:

public:
    int value;
    node* parent,*left,*right;
    node(int val) { value=val; parent=right=left=nullptr; }
};

node* swapNodes(node* root,node* father){
    node* temp=father->left;
    father->left=father->right;
    father->right=temp;
    return root;
}

node* insert(node* root,int val){
    if (root==nullptr) root= new node(val);

    else if(root->value!=0){
    if (root->left==nullptr) {root->left=new node(val); root->left->parent=root; return root;}
    else if (root->left->value!=0) if(insert(root->left,val)) return root;

    if (root->right==nullptr) {root->right=new node(val); root->right->parent=root; return root;}
    else if (root->right->value!=0) if(insert(root->right,val)) return root;
    return nullptr;
    }
    return root;
}

void children(node* n){
    if (n->left && n->right)
    std::cout<<"my left child is "<<n->left->value<<"and my right child is "<<n->right->value<<"\n";
}

node* findSmallestLeaf(node* root,node* &smallestLeaf){

    if(root==nullptr) return nullptr;

    if(root->left==nullptr && root->right==nullptr){
        if (smallestLeaf==nullptr || root->parent->value < smallestLeaf->value) smallestLeaf=root->parent;
    }
    findSmallestLeaf(root->left,smallestLeaf);
    findSmallestLeaf(root->right,smallestLeaf);

    return smallestLeaf;
}

bool isRight(node* n){
    if(n==nullptr || n->parent==nullptr) return false;
    if(n->parent->right->value == n->value && n->parent->left) return true;
    else return false;
}

node* toLeft(node* root,node* n){
    if(isRight(n)) root=swapNodes(root,n->parent);
    if(n->parent) root=toLeft(root,n->parent);
    return root;
}

void inorder(node* n){
    if(n){
    inorder(n->left);
    if(n->value!=0) std::cout<<n->value<<" ";
    inorder(n->right);
    }
}

void inorderEndl(node* n){
    inorder(n);
    std::cout<<'\n';
}

node* minimize(node* n){
    if(n->value==0)
        return n;
     if(n->left->value==0){
        node* temp=n->left;
        n->left=n->right;
        n->right=temp;
    }
    else if(n->left->value!=0 && n->right->value!=0){
        if(n->left->value>n->right->value)
            {
                node* temp=n->left;
                n->left=n->right;
                n->right=temp;
            }
    }
    minimize(n->left);
    minimize(n->right);
    return n;
}

int main(){
    node *worldtree=nullptr;
    int n;

    std::cin>>n;
    for(int i=0;i<2*n+1;i++)
    {
        int val;
        std::cin>>val;
        worldtree=insert(worldtree,val);
    }

    std::cout<<std::endl;
    inorderEndl(worldtree);
    swapNodes(worldtree,worldtree);
    inorderEndl(worldtree);
    swapNodes(worldtree,worldtree);
    inorderEndl(worldtree);
    std::cout<<std::endl;

    node* smallestLeaf=nullptr;
    minimize(worldtree);
    smallestLeaf=findSmallestLeaf(worldtree,smallestLeaf);
    std::cout<<"smallest leaf has value "<<smallestLeaf->value<<'\n';
    toLeft(worldtree,smallestLeaf);
    //node* smallestRightLeaf= nullptr;
    //smallestRightLeaf=findSmallestLeaf(worldtree->right,smallestRightLeaf);
    //std::cout<<"smallest right leaf has value "<<smallestRightLeaf->value<<'\n';
    //toLeft(worldtree->right,smallestRightLeaf);
    //minimize(worldtree);
    inorderEndl(worldtree);
    //inorderEndl(toLeft(worldtree,findSmallestLeaf(worldtree,smallestLeaf)));
}

