class Solution {
    	private static boolean check(String a, String b) {
		boolean result = false;
		int tmp1 = Integer.parseInt(a+b);
		int tmp2 = Integer.parseInt(b+a);
		if(tmp2>tmp1) result = true;
		else result = false;
		return result;
	}
	private static void mergeSortDevide(String[] arr, int left, int right) {
        
        /*원소의 수가 2개 이상일경우 실행*/
        if (left < right) { 
            
            /*반으로 나누기 위한 변수*/
            int mid = (left + right) / 2; 
            
            /*앞(왼쪽)부분 재귀 호출*/
            mergeSortDevide(arr, left, mid); 
        
            /*뒤(오른쪽)부분 재귀 호출*/
            mergeSortDevide(arr, mid + 1, right);
            
            /*원소를 Merge하는 함수*/
            merge(arr, left, mid, right); 
        }
    }
 
    private static void merge(String[] arr, int left, int mid, int right) {
 
        int i = left;
        int j = mid + 1;
        int temp_index = left;
 
        String[] temp = new String[arr.length];
 
        while (i <= mid && j <= right) {
            if (!check(arr[i], arr[j])) { // 문자열 비교로 변환
                temp[temp_index++] = arr[i++];
            } else {
                temp[temp_index++] = arr[j++];
            }
        }
        
        /*앞(왼쪽)부분 배열에 원소가 남아있는 경우*/
        while (i <= mid) { 
            temp[temp_index++] = arr[i++];
        }
        
        /*뒤(오른쪽)부분 배열에 원소가 남아있는 경우*/
        while (j <= right) {
            temp[temp_index++] = arr[j++];
        }
 
        for (int index = left; index < temp_index; index++) {
            arr[index] = temp[index];
        }
    }
    public String solution(int[] numbers) {
        String arr[] = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            arr[i] = Integer.toString(numbers[i]);
        }
        mergeSortDevide(arr, 0, arr.length - 1);
        String answer = "";
        if(!arr[0].equals("0")){
            for(int i=0; i<arr.length; i++) {
                answer += arr[i];
            }
        }else{
            answer ="0";
        }
        return answer;
    }
}