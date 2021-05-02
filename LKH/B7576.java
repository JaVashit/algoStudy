import java.util.*;
public class Main{

    public static class Pair{
        int x;
        int y;
        int len;
        Pair(int x, int y, int len){
            this.x = x;
            this.y = y;
            this.len = len;
        }
    }
    
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};

    public static int bfs(int map[][], Queue<Pair> q, boolean check[][], int n, int m){
        int min = Integer.MAX_VALUE;
        int now = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            now = p.len;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0 || nx>m-1 || ny<0 || ny>n-1 || map[ny][nx] == -1) continue;
                else if(check[ny][nx]) continue;
                else{
                    q.add(new Pair(nx, ny, now+1));
                    check[ny][nx] = true;
                }
            }
        }
        boolean isOk = true;
        // 토마토 검사 로직
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(map[i][j]!=-1 && !check[i][j]){
                    isOk = false;
                    break;
                }
            }
        }
        min = now;
        if(!isOk) min = -1;
        return min;

    }

    public static void main (String[] args){
        Scanner scn = new Scanner(System.in);
        int m = scn.nextInt();
        int n = scn.nextInt();
        int map[][] = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        boolean check[][] = new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m ; j++){
                map[i][j] = scn.nextInt();
                if(map[i][j] == 1){
                    q.add(new Pair(j, i, 0));
                    check[i][j] = true;
                }
            }
        }
        
        int answer = bfs(map, q, check, n, m);
        System.out.println(answer);
        
    }
}