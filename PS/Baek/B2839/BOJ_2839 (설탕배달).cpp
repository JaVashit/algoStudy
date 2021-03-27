// BOJ 2839 설탕배달 
#include<cstdio>

int main(){
	
	int N;
	
	scanf("%d", &N);
	
	
	int r5kg, r3kg;
	int rst = 0;
	r5kg = 0, r3kg = 0;
/*	
	if(N < 5){ // N이 5보다 작은 경우  
		if(N%3 == 0){
			rst = (N/3);
			printf("%d",rst);
			return 0;	
		} 
		else {
			rst = -1;
			printf("%d",rst);
			return 0;	
		}
		
	}else{
		// 5보다 큰 경우  
		if(N%5 == 0){
			printf("%d",N/5);
			return 0;
		}else if(N%5 != 0){
		
			if(N%3 == 0){
				printf("%d",(N/3));
				return 0;
			}else{
				r5kg = (N/5); 
				// 나머지 값 
				N = N - (r5kg)*5;
				
				if(N%3 == 0){
					r3kg = (N/3);
					rst = r5kg + r3kg;
					printf("%d",rst);
					return 0;
				}else{
					printf("%d",-1);
					return 0;
				}
			}			
		}
	}
*/
/*
	if(N%5 == 0){ // 5,10,15,20,25,30,...,5N => 가장 적을 수 있는 케이스  
		rst = (N/5);
		printf("%d", rst);
		return 0;		
	}else{ // 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 
		r5kg = (N/5);
		
		if(r5kg == 0){ // 1,2,3,4 인 경우  
			if(N%3 == 0){ // 3 인 경우 
				rst = 1;
				printf("%d",rst);
				return 0;
			}else{ // 1,2,4 인 경우  
				rst = -1;
				printf("%d",rst);
				return 0;			
			}
		}else{ // 6,7,8,9,...,11,12,... 인 경우			
			// 5 : 1 
			// 3 : 2
			
			rst = r5kg;
			int copyN = N;
			N = N - 5*r5kg;
			if(N%3 == 0){
				r3kg = (N/3); 
				rst = rst + r3kg;
				printf("%d",rst);
				return 0;
			}else if(N%3 != 0 && copyN%3 !=0){
				r3kg = (N/3);
				copyN = copyN - 3*r3kg;
				
				
			}
			
			
		}

	}
*/	
	if(N%5 == 0){
		rst = N/5;
		printf("%d",rst);
		return 0;
	}else{
		r5kg = N/5; // 21 이면 4개 일 수 있고, 19이면 3개, ...  
		r3kg = 0;
		// 11인 경우 (2,1) => x, (1,2) => o  
		for(int i=r5kg; i>=0; i--){
			// 6 인 경우  
			if( (N-(5*i)) %3 == 0 ) {
				r5kg = i;
				r3kg = (N-(5*i)) / 3;
				rst = r5kg + r3kg;
				break;
			}else{
				rst = -1;
			}
		}
		printf("%d", rst);		
	}
	return 0; 		
}
