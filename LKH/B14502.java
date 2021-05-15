import java.util.*;
public class Main {
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static LinkedList<Pair> virus = new LinkedList<>();
	static int max = 0;
	static public class Pair{
		int x, y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void countingSafe(int arr[][], int visited[][], int n, int m) {
		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0 && visited[i][j] == 0) {
					count++;
				}
			}
		}
		if(max<count) {
			max = count;
		}
	} // 안전 지역 영역 개수 카운팅 함수
	
	public static void spreadVirus(int arr[][], int empty[][], int a, int b, int n, int m) {
		int visited[][] = new int[n][m];
		Queue<Pair> s = new LinkedList<>();
		s.add(new Pair(a,b));
		while(!s.isEmpty()) {
			Pair p = s.poll();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0||nx>m-1 || ny<0 || ny>n-1 || visited[ny][nx] == 1 || empty[ny][nx] == 2) continue;
				else if(arr[ny][nx] == 0) {
					visited[ny][nx] = 1;
					empty[ny][nx] = 2;
					s.add(new Pair(nx, ny));
				}
			}
		}
	} // 바이러스 퍼트리는 함수
	
	public static void setWall(int arr[][], int visited[][], LinkedList<Pair> virus,  int depth, int n, int m) {
		if(depth == 3) {
			int empty[][] = new int[n][m];
			for(int i=0; i<virus.size(); i++) {
				Pair p = virus.get(i);
				spreadVirus(arr, empty, p.x, p.y, n, m);
			}
			
			countingSafe(arr, empty, n, m);
			return;
		}// 세 개의 벽을 세웠을 때 
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 0) {
					arr[i][j] = 1;
					setWall(arr, visited, virus, depth+1, n, m);
					arr[i][j] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int arr[][] = new int[n][m];
		int visited[][] = new int[n][m];
		
		// 지도의 크기 입력
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j] = scn.nextInt();
			}
		} // 지도의 내용 입력
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 2) {
					virus.add(new Pair(j, i));
				}
			}
		}// 바이러스 위치 파악하기/

		setWall(arr, visited, virus, 0, n, m);
		System.out.println(max);

	}

}
