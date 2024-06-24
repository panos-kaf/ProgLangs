#include <stdio.h>

/*int findSumAndBiggest(int *sum,int N,int *array){
	
	int biggest=0;
	
	for (int i=0;i<N;i++){
	*sum+=*(array+i);
	if(*(array+biggest)<*(array+i))biggest=i;}

	return biggest;
}*/

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
	if(*best>current) {*best=current; return 1;}
	return 0;
}

int main(int argc, char** argv){
	
	int N=5;

	/*FILE* file=fopen(argv[1],"r");
	fscanf(file,"%d",&N);
	int sequence[N];
	for(int i=0;i<N;i++) fscanf(file,"%d",&sequence[i]);
	*/

	/*scanf("%d",&N);
	int sequence[N];
	for(int i=0;i<N;i++) scanf("%d",&sequence[i]);
	*/

	int sequence[N];
	sequence[0]=1; sequence[1]=2; sequence[2]=3; sequence[3]=4; sequence[4]=5;

	const int totalSum=findSum(N,sequence);
	int best=totalSum;
	printf("Sum = %d\n",totalSum);

	int new_i=0,new_j=0;
	int tmpSum=0;
	int count=0,passed=0;
	for(int i=0;i<N;i++){

		if(best==0 || best==1) break;

		for(int j=new_j;j<N;j++){
			count++;
			tmpSum+=sequence[j];
			if((2*tmpSum-totalSum)>0){
				passed++;
				//printf("passed half of the sum %d times\n",passed);
				if(findBest(&best,tmpSum,totalSum)) printf("test1: best=%d\n",best);
				if(findBest(&best,tmpSum-sequence[j],totalSum)) printf("test2: best=%d\n",best);
				new_j=j;
				
				if(new_j==(N-1)){
					for(int k=i;k<N;k++) {tmpSum-=sequence[k];findBest(&best,tmpSum,totalSum);}
					printf("%d(last)\n",best); return 0;
					}
				tmpSum-=sequence[i];
				//new_i=i;
				break;
			}
		}
		//i=new_i;
	}
	printf("passed half of the sum %d times\n",passed);
	printf("Res=%d\nRan the loop %d times\n",best,count);
	return 0;	
}
