import java.util.*;
class Solution {
    static ArrayList<Integer> list = new ArrayList<>();
    static void perm(String[] arr, String[] output, boolean[] visited, int depth, int n, int r) {
	        if(depth == r) {
                String str = "";
	            str = print(output, r);
                int num = Integer.parseInt(str);
                if(check(num)){
                	boolean isOk = true;
                    for(int i=0; i<list.size(); i++) {
                    	if(list.get(i) == num) {
                    		isOk = false;
                    	}
                    }
                    if(isOk) list.add(num);
                }
	            return;
	        }
	    
	        for(int i=0; i<n; i++) {
	            if(visited[i] != true) {
	                visited[i] = true;
	                output[depth] = arr[i];
	                perm(arr, output, visited, depth + 1, n, r);    
	                visited[i] = false;;
	            }
	        }
	    }
	 
	    static String print(String[] arr, int r) {
            String str = "";
	        for(int i=0; i<r; i++){
                str += arr[i];
            }
	        return str;
	    }
    
    public static boolean check(int num){
        boolean isSosu = true;
        if(num < 2) {
			isSosu = false;
            return isSosu;
		}
		
		// 2 는 소수다
		if(num == 2) {
			isSosu = true;
            return isSosu;
		}
		
        
		for(int i = 2; i < num; i++) {
			// 소수가 아닐경우
			if(num % i == 0) {
                isSosu = false;
                break;
			}
		}
        return isSosu;
    }
    public int solution(String numbers) {
        int answer = 0;
        String arr[] = numbers.split("");
        
        for(int i=1; i<=arr.length; i++){
            boolean visited[] = new boolean[arr.length];
            String output[] = new String[i];
            perm(arr, output, visited, 0, arr.length, i);
        }
        int cnt = list.size();
        answer = cnt;
        return answer;
        
    }
}