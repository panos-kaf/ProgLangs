#include <stdio.h>

long long int myabs(long long int x){
    if(x<0) return -x;
    else return x;
}

int findBest(long long int* best,long long int partial,long long unsigned int total){
    int current=myabs((2*partial)-total);
    if(*best>current) {
        *best=current; 
        return 1;
    }
    return 0;
}

int main(int argc, char** argv){
    
    int N=1;
    FILE* file=fopen(argv[1],"r");
    fscanf(file,"%d",&N);
    int sequence[N];
    long long unsigned int totalSum=0;
    for(int i=0;i<N;i++) {
        fscanf(file,"%d",&sequence[i]);
        totalSum+=sequence[i];
    }

    long long int best=totalSum;
    long long int j=0,new_j=0,partialSum=0;

    for(int i=0;i<N;i++){
        if(best<2) break;
        for(j=new_j;j<N;j++){
            partialSum+=sequence[j];
            if((2*partialSum-totalSum)>0){
                if(findBest(&best,partialSum,totalSum)) new_j=j+1;
                if(findBest(&best,partialSum-sequence[j],totalSum)){new_j=j; partialSum-=sequence[j];}
                break;
            }
        }
        partialSum-=sequence[i];
    }
    printf("%lld\n",best);
    return 0;	
}
