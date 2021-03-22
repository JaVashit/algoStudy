import java.util.*;
public class B2775{
	public static void cal(int arr[][], int k, int n) {
		for(int i=0; i<=k; i++) {
			for(int j=1; j<=n; j++) {
				if(i==0) {
					arr[i][j] = j; // 0층 인원 수
				}else if(j==1) {
					arr[i][j] = 1; // 1호 인원 수
				}
				else {
					int tmp = 0;
					for(int t=1; t<=j; t++) {
						tmp += arr[i-1][t]; // k층 n호 인원의 누적
					}
					arr[i][j] = tmp;
				}
			}
		}
	}
public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for(int i=0; i<t; i++) {
			int k = scn.nextInt();
			int n = scn.nextInt();
			int arr[][] = new int[k+1][n+1];
			cal(arr, k, n);
			System.out.println(arr[k][n]);
		}
	}

}
