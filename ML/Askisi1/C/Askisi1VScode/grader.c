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

int findBest(int* best,int val,int total){
    int current=abs((2*val)-total);
    if(*best>current) {
        *best=current; 
        return 1;
    }
    return 0;
}

int main(int argc, char** argv){
    
    //int N=0;
    /*
    FILE* file=fopen(argv[1],"r");
    fscanf(file,"%d",&N);
    int sequence[N];
    for(int i=0;i<N;i++) fscanf(file,"%d",&sequence[i]);
    */
   
    /*scanf("%d",&N);  
    int sequence[N],sum=0;
    for (int i=0;i<N;i++) {
            scanf("%d",&sequence[i]);
            sum+=sequence[i];
        }
    */

    int N=4;
    int sequence[N];
    sequence[0]=1;
    sequence[1]=2;
    sequence[2]=3;
    sequence[3]=4;
    //sequence[4]=42;

    const int totalSum=findSum(N,sequence);
    int best=totalSum;

    int j=0,new_j=0,tmpSum=0;

    for(int i=0;i<N;i++){

        if(best<2) break;

        for(j=new_j;j<N;j++){
            tmpSum+=sequence[j];
            if((2*tmpSum-totalSum)>0){
                if(findBest(&best,tmpSum,totalSum)) new_j=j+1;
                if(findBest(&best,tmpSum-sequence[j],totalSum)) {new_j=j; tmpSum-=sequence[j];}
                break;
            }
        }
        /*if (j==N-1) { 
            tmpSum=0;
            for(int k=1;k<N+1;k++){
                tmpSum+=sequence[N-k];
                if (2*tmpSum > totalSum){
                    findBest(&best,tmpSum,totalSum);
                    findBest(&best,tmpSum-sequence[N-k+1],totalSum);
                    break;
                }
            }
            break;       
        }*/
        tmpSum-=sequence[i];
    }
    printf("%d\n",best);
    return 0;	
}