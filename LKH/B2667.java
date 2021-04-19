import java.util.*;
public class Main{
   public static class Pair{
    	int x;
    	int y;
    	public Pair(int x, int y){
    		this.x = x;
    		this.y = y;
    	}
    }
    static int dy[] = {-1,1,0,0};
    static int dx[] = {0,0,-1,1};
    public static int dfs(int arr[][], boolean check[][], int sx, int sy, int m, int n) {
    	Stack<Pair> s = new Stack<>();
    	s.add(new Pair(sx, sy));
    	
    	check[sy][sx] = true;
    	int cnt = 1;
    	while(!s.isEmpty()) {
    		Pair p = s.pop();
    		int x = p.x;
    		int y = p.y;
    		for(int i=0; i<4; i++) {
    			int nx = x+dx[i];
    			int ny = y+dy[i];
    			if(nx>=0 && nx<n && ny>=0 && ny<m) {
    				if(check[ny][nx]) continue;
    				else if(arr[ny][nx] == 0) continue;
    				else if(arr[ny][nx] == 1) {
    					s.add(new Pair(nx, ny));
    					check[ny][nx] = true;
    					cnt++;
    				}
    			}
    		}
    	}
    	
    	return cnt;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[][] = new int[n][n];
		for(int i=0; i<n; i++) {
			String str = scn.next();
			String tmp[] = str.split("");
			for(int j=0; j<n; j++) {
				arr[i][j] = Integer.parseInt(tmp[j]);
			}
		}
		boolean check[][] = new boolean[n][n];
		ArrayList<Integer> list = new ArrayList<>(); 
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		if(arr[i][j] == 1 && !check[i][j])
        			list.add(dfs(arr, check, j, i, n, n));
        	}
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(int i=0; i<list.size();i++) {
        	System.out.println(list.get(i));
        }
	} 
}