import java.util.*;
public class Main {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	public static class Pair{
		int x;
		int y;
		Pair(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void dfs(String[][] map, boolean check[][], int sx, int sy, int n, String color) {
		Stack<Pair> s = new Stack<>();
		s.add(new Pair(sx, sy));
		check[sy][sx] = true;
		
		while(!s.isEmpty()) {
			Pair p = s.pop();
			int x = p.x;
			int y = p.y;
			for(int i=0; i<4; i++) {
				int nx = x+dx[i];
				int ny = y+dy[i];
				if(nx<0 || nx>n-1 || ny<0 || ny>n-1 || check[ny][nx]) continue; // 범위 초과 및 이전 방문한 영역 체크
				else if(!map[ny][nx].equals(color)) continue; // 다른 색일 경우 탐색 금지
				else {
					s.add(new Pair(nx, ny));
					check[ny][nx] = true;
				}
			}
		}
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[][] map = new String[n][n];
		
		for(int i=0; i<n; i++) {
			String tmp =  scn.next();
			map[i] = tmp.split("");
		} // 영역 입력
		String rMap[][] = new String[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j].equals("R")) {
					rMap[i][j] = "G";
				}else {
					rMap[i][j] = map[i][j];
				}
			}
		}
		
		// 정상인
		int normal = 0;
		boolean check[][] = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!check[i][j]) {
					dfs(map, check, j, i, n, map[i][j]);
					normal++;
				}
			}
		}
		// 적록색약
		int rG = 0;
		boolean rCheck[][] = new boolean[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(!rCheck[i][j]) {
					dfs(rMap, rCheck, j, i, n, rMap[i][j]);
					rG++;
				}
			}
		}
		System.out.println(normal + " " + rG);
		

	}

}