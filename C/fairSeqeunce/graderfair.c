#include <stdio.h>

int abs(int x){
    if(x<0) return -x;
    else return x;
}

int findSum(int N,int* array){
    int sum=0;
    for(int i=0;i<N;i++)
        sum+=*(array+i);
    return sum;
}

void findBest(int* best,int val,int total){
    int current=abs((2*val)-total);
    if(*best>current) *best=current; 
}

int main(int argc, char** argv){
    
    int N=0;
    FILE* file=fopen(argv[1],"r");
    fscanf(file,"%d",&N);
    int sequence[N];

    for(int i=0;i<N;i++) fscanf(file,"%d",&sequence[i]);

    const int totalSum=findSum(N,sequence);
    int best=totalSum;

    int j=0,new_j=0,tmpSum=0;

    for(int i=0;i<N;i++){

        if(best==0 || best==1) break;

        for(j=new_j;j<N;j++){
            tmpSum+=sequence[j];
            if((2*tmpSum-totalSum)>0){
                findBest(&best,tmpSum,totalSum);
                findBest(&best,tmpSum-sequence[j],totalSum);
                new_j=i+1;
                break;
            }
        }
	if (j==N-1) break;
        tmpSum-=sequence[i];
    }

    printf("%d\n",best);
    return 0;	
}
