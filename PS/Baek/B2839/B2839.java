import java.util.*;

public class B2839 {
	public static int cal(int n) {
		int a = 1;
		int b = 1;
		int min = Integer.MAX_VALUE;
		
		if(n%3 == 0 && n%5!=0) min = n/3;
		else if(n%5 == 0 && n%3!=0) min = n/5;
		else if(n%3==0 && n%5==0) min = n/5;
		
		for(int i=1; i<=1000; i++) {
			for(int j=1; j<=1000; j++) {
				if(3*i + 5*j == n) {
					if(min>(i+j))min = (i+j);
				}
				if(5*j>n) break;
			}
			if(3*i>n) break;
		}
		if(min == Integer.MAX_VALUE) min = -1;
		return min;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(cal(n));
	}

}