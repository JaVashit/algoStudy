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

    public static int bfs(String map[][], int sx, int sy, int n, int m){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sx, sy, 1));
        boolean check[][] = new boolean[n][m];
        check[sy][sx] = true;
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int x = p.x;
            int y = p.y;
            int now = p.len;
            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx<0 || nx>m-1 || ny<0 || ny>n-1 || map[ny][nx].equals("0")) continue;
                else if(check[ny][nx]) continue;
                else{
                    if(nx == m-1 && ny==n-1){
                        if(min>now+1){
                            min = now+1;
                        }
                    }else{
                        q.add(new Pair(nx, ny, now+1));
                        check[ny][nx] = true;
                    }
                    
                }
            }
        }
        return min;

    }

    public static void main (String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        String map[][] = new String[n][m];
        for(int i=0; i<n; i++){
            String tmp = scn.next();
            map[i] = tmp.split("");
        }
        int answer = bfs(map, 0, 0, n, m);
        System.out.println(answer);
        
    }
}