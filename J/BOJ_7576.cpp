// BOJ_7576 ≈‰∏∂≈‰ 
#include<cstdio>
#include<queue>
#include<cstring>

using namespace std;

int m,n; 
int map[1001][1001];
int rst[1001][1001];
int visited[1001][1001];
queue<pair<int,int> > q;
int dx[] = {0,0,1,-1};
int dy[] = {1,-1,0,0};


void solve(){
	
	while(!q.empty()){
		
		int y = q.front().first;
		int x = q.front().second;
		q.pop();
		
		for(int i=0; i<4; i++){
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(ny < 0 || ny >= n || nx < 0 || nx >= m) continue;
			if(map[ny][nx] == 0 && visited[ny][nx] == -1){
				visited[ny][nx] = 1;
				q.push(make_pair(ny,nx));
				rst[ny][nx] = rst[y][x] + 1;
			}
		}		
	}
}


int main(){
	
	scanf("%d %d", &m, &n);
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			scanf("%d", &map[i][j]);
		}
	}  
	
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			if(map[i][j] == 1){
				q.push(make_pair(i,j));
			}
		}
	}
	
	memset(visited, -1, sizeof(visited));
	solve();
	
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			if(map[i][j] == 0 && rst[i][j] == 0){
				printf("%d", -1);
				return 0;				
			}
		}
	}
	
	int ans = -1;
	for(int i=0; i<n; i++){
		for(int j=0; j<m; j++){
			if(rst[i][j] > ans){
				ans = rst[i][j];
			}
		}
	}
	printf("%d", ans);
	
	return 0;
}
