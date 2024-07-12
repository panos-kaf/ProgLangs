#include <stdio.h>

int abs(int x){
	if(x<0)return -x;
	return x;
}

int findBest(int best,int partial,int sum){
	int res=abs(partial-sum);
	if(res<best) return res;
	return best;
}

int main(int argc,char** argv){

	FILE* file=fopen(argv[1],"r");
	
	int N=0;
	/*scanf("%d",&N);
	
	int sequence[N],sum=0;
	for (int i=0;i<N;i++) {
		scanf("%d",&sequence[i]);
		sum+=sequence[i];
	}
	*/
	fscanf(file,"%d",&N);
	int sequence[N],sum=0;
	for(int i=0;i<N;i++){
		fscanf(file,"%d",&sequence[i]);
		sum+=sequence[i];
	}
	int partialSum=0,best=sum;
	int new_j=0,j=0;
/*
	for (int i=0;i<N;i++){

		if(best==0 || (best==1 && sum%2==1)) break;

		for (j=new_j;j<N;j++){

			partialSum+=sequence[j];
			if(2*partialSum>=sum){
				best=findBest(best,partialSum,sum);
				best=findBest(best,partialSum-sequence[j],sum);
				new_j=j;
				break;
			}
		
		}
	if (j==N-1) break;
	}
*/

	for (int i=0;i<N;i++){

		for(int j=new_j;j<N;j++){

			partialSum+=sequence[j];
			if(2*partialSum>=sum){
				best=findBest(best,partialSum,sum);
				best=findBest(best,partialSum-sequence[j],sum);
				new_j=j;	
				break;
			}
			partialSum-=sequence[i];
					}
		if (j==N-1) break;
			}

	printf("%d\n",best);
	}

