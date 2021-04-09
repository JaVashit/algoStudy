import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>(); // 타임체크
        Queue<Integer> truck = new LinkedList<>(); // 트럭
        Queue<Integer> q2 = new LinkedList<>(); // 트럭
        for(int i=0; i<truck_weights.length; i++){
            truck.offer(truck_weights[i]);
        }
        int time = 0;
        int now_weight = 0;
        while(!truck.isEmpty() || !q.isEmpty()){
        	int size =  q.size();
            for(int i=0; i<size;i++){
                if(time-q.peek() == 0){
                    q.poll();
                    now_weight -= q2.poll();
                }
            }
            if(!truck.isEmpty() && (now_weight+truck.peek()<=weight)){
                q.add(time+bridge_length);
                q2.add(truck.peek());
                now_weight += truck.poll();
                // 건널 수 있다면 신규 트럭 추가    
            }// 새롭게 트럭이 다리를 건널 수 있는지 무게 체크
            
            // 건너고 있는 트럭별로 시간 증가
            time++;// 시간 증가
            // 만일 트럭이 다리를 다 건넜다면 제외처리
            
        }
        answer = time;
        return answer;
    }
}