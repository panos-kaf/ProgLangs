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
	
	int N;
	FILE* file=fopen(argv[1],"r");
	fscanf(file,"%d",&N);
	int sequence[N];

	for(int i=0;i<N;i++) fscanf(file,"%d",&sequence[i]);

	const int totalSum=findSum(N,sequence);
	int best=totalSum;
	//printf("Sum = %d\n",totalSum);

	//int new_i=0,new_j=0;
	int tmpSum=0;
	//int count=0,passed=0;


	for(int i=0;i<N;i++){
		tmpSum=0;
//		printf("best=%d\n",best);
		for(int j=i;j<N;j++){
			tmpSum+=sequence[j];
			if((tmpSum*2>=totalSum) && (abs(tmpSum*2-totalSum)<best))best=abs(tmpSum*2-totalSum);
		}
	}

/*	for(int i=0;i<N;i++){

		if((best==0 && totalSum%2==0)||(best==1 && totalSum%2==1)) break;

		for(int j=new_j;j<N;j++){
			count++;
			tmpSum+=sequence[j];
			if(2*tmpSum>totalSum){
				passed++; printf("2*tmpsum-totalsum=%d\n",abs(2*tmpSum-totalSum));
				//printf("passed half of the sum %d times\n",passed);
				if(findBest(&best,tmpSum,totalSum)) {
					tmpSum-=sequence[new_j];new_j=j+1; 
					printf("test1: best=%d\n",best);
				}
				if(findBest(&best,tmpSum-sequence[j],totalSum)) {
					tmpSum-=sequence[new_j]; new_j=j; 
					printf("test2: best=%d\n",best);
				}
				//new_j=j;
				//new_i=i;
								break;
			}
		}
		//i=new_i;
	}
*/
//	printf("passed half of the sum %d times\n",passed);
	printf("%d\n",best);
	return 0;	
}
