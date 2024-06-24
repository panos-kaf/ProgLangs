#include <stdio.h>

int findBest(int best,int current,int sum){

}

int main(int argc,char* argv[]){
    int N;
    scanf("%d",N);
    FILE* file;
    file=fopen(argv[1],"r");
    fscanf(file,"%d",&N);
    int sequence[N];
    int sum=0;
    for(int i=0;i<N;i++){
        fscanf(file,"%d",&sequence[i]);
        sum+=sequence[i];
    }

    int partialSum=0,best=sum;
    for(int i=0;i<N;i++){

        for(int j=i;j<N-1;j++){
            partialSum+=sequence[j];
            if (2*partialSum>sum){
            best=findBest(best,partialSum,sum);
            
            }

        }

    }
    
}