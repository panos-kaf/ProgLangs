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
	int current=abs(2*val-total);
	if(*best>current) *best=current; 
}

int main(int argc, char** argv){
	
	int N=5;
	//FILE* file=fopen(argv[1],"r");
	//scanf("%d",&N);
	int sequence[5]={1,2,3,4,5};

	//for(int i=0;i<N;i++) scanf("%d",&sequence[i]);

	const int totalSum=findSum(N,sequence);
	int best=totalSum;

	int new_j=0,tmpSum=0;

	for(int i=0;i<N;i++){

		if(best==0 ||(best==1 && totalSum%2==1)) break;

		for(int j=new_j;j<N;j++){
		
			if(new_j!=N-1)tmpSum+=sequence[j];
			if(((2*tmpSum-totalSum)>=0)){
				findBest(&best,tmpSum,totalSum);
				if(j!=new_j)findBest(&best,tmpSum-sequence[j],totalSum);
				new_j=j;
				break;
			}
		}
		tmpSum-=sequence[i];
	}

	printf("%d\n",best);

	return 0;	
}
