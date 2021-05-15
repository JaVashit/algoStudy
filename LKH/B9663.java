import java.util.*;
public class Main {
	static int cnt = 0;
    static int tmp = 0;
	public static void drawQueen(int visited[][],int n, int y, int x) {
		for(int i=y; i<n; i++) {
			for(int j=0; j<n; j++) {
				if((i==y || j==x) && visited[i][j] == 0) {
					visited[i][j] = y+1;
				}
				else if((i==y+tmp && j==x+tmp) && visited[i][j] == 0 ) {
					visited[i][j] = y+1;
				}
				else if((i==y+tmp && j==x-tmp) && visited[i][j] == 0) {
					visited[i][j] = y+1;
				}
			}
			tmp++;
		}
		tmp = 0;
	}
	public static void removeQueen(int visited[][],int n, int y, int x) {
		for(int i=y; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(visited[i][j] ==y+1) {
					visited[i][j] = 0;
				}
			}
		}
	}
	
	public static void nQueen(int n, int arr[][], boolean check[], int depth) {
		if(depth == n) {
			boolean checking = true;
			for(int i=0; i<n; i++) {
				if(!check[i]) checking = false;
			}
			if(checking)
				cnt++;
			return;
		}
		for(int i=0; i<n; i++) {
			if(arr[depth][i] ==0) {
				check[depth] = true;
				drawQueen(arr, n, depth, i);
				nQueen(n, arr, check, depth+1);
				removeQueen(arr, n, depth, i);	
			}
			
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[][] = new int[n][n];
		boolean check[] = new boolean[n];
		nQueen(n, arr,check, 0);
		System.out.println(cnt);
	}
}
