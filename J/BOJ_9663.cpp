// N-QUEEN 9663 

#include<cstdio>
#include<cstring>

int board[15];
int n;
int ans;

bool check(int r, int c){
		
		
	/*
	   n = 3 �̶�� 
	  
	   o 
	   x x o 
	   x x x   
	   
	   ans �� + �ȵ� 
	   
	   n = 4 �̶��
	   
	   o 
	   x x o
	   x x x x
	   x o   
	   
	     o 
	   x x x o
	   o 
	   x x o x
	    
		
	*/
	
	for(int i=0; i<r; i++){
		if(board[i] == c) return false;
	}	
	
	
	// (4,2)  
	/*
	������ �ڸ��� ���� ��ȣ�� ���� 
	
	
	(0,0) (0,1) (0,2) (0,3)
	(1,0) (1,1) (1,2) (1,3)
	(2,0) (2,1) (2,2) (2,3)
	(3,0) (3,1) (3,2) (3,3)
	
	*/
	
	
	for(int i=1; i<=r; i++){
		// ���� �밢�� 
		if(board[r-i] == c-i) return false;	
		// ������ �밢�� 
		if(board[r-i] == c+i) return false;
		
	}
	
	return true;	
	
}



void solve(int cur){
	if(cur == n){
		ans++;
		return;
	}
	
	for(int i=0; i<n; i++){	
		if(check(cur,i)){
			board[cur] = i;
			solve(cur+1);
			board[cur] = -1;
		}
	}	
}


int main(){
	
	scanf("%d", &n);
	memset(board,-1,sizeof(board));

	solve(0);

	printf("%d",ans);
	
	return 0;
}


