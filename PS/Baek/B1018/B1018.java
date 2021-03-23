public class B1018{

	public static int check(String board[][], String orders[][], int w, int h, int n, int m) {
		int tmp[][] = new int[8][8];
		for(int y=0; y<8; y++) {
			for(int x=0; x<8; x++) {
				if(x+w>m-1 || h+y>n-1)continue;
				if(!orders[y][x].equals(board[y+h][x+w])) {
					tmp[y][x] = 1;
				}
			}
		}
		int cnt = 0;
		for(int y=0; y<8; y++) {
			for(int x=0; x<8; x++) {
				if(tmp[y][x] == 1) cnt++;
			}
		}
		return cnt;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		scn.nextLine();
		String board[][] = new String[n][m];
		String a[][] = {
				{"W","B","W","B","W","B","W","B"},
				{"B","W","B","W","B","W","B","W"},
				{"W","B","W","B","W","B","W","B"},
				{"B","W","B","W","B","W","B","W"},
				{"W","B","W","B","W","B","W","B"},
				{"B","W","B","W","B","W","B","W"},
				{"W","B","W","B","W","B","W","B"},
				{"B","W","B","W","B","W","B","W"},
				};
		String b[][] = {
				{"B","W","B","W","B","W","B","W"},
				{"W","B","W","B","W","B","W","B"},
				{"B","W","B","W","B","W","B","W"},
				{"W","B","W","B","W","B","W","B"},
				{"B","W","B","W","B","W","B","W"},
				{"W","B","W","B","W","B","W","B"},
				{"B","W","B","W","B","W","B","W"},
				{"W","B","W","B","W","B","W","B"},
				};
		
		for(int i=0; i<n; i++) {
			String str = scn.nextLine();
			board[i] = str.split("");
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<n; i++) {
			if(n<8+i)continue;
			int tmp1 = Integer.MAX_VALUE;
			int tmp2 = Integer.MAX_VALUE;
			for(int j=0; j<m; j++) {
				if(m<j+8)continue;
				tmp1 = check(board, a, j, i, n, m);
				tmp2 = check(board, b, j, i, n, m);
				if(tmp1>tmp2) {
					if(min>tmp2) min = tmp2;
				}else {
					if(min>tmp1) min = tmp1;
				}
			}
		}
		if(min == Integer.MAX_VALUE) min = 1;
		System.out.println(min);
	}

}