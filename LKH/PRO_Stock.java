import java.util.*;
class Stock{
	int price;
	int order;
	public Stock(int price, int order){
		this.price = price;
		this.order = order;
	}
}
class Solution {
    public int[] solution(int[] prices) {
     		int[] result = new int[prices.length];
 		int stockInfo[][] = new int[1][2];
 		int maxPrice = 0;
 		int minPrice = 0;
 		Stack<Stock> stocks = new Stack<>();
 		// i, price는 기록
 		// 확실하게 알수 있는 것은 스택에 있는 가장 작은 주식 값과 현재 시간의 주식 값을 비교할 수 있다.
 		// 그외는??
 		// 만약 현재 시간의 주식 값이 가장 작은 값과 가장 큰 값 사이의 값이라면 비교해야 됨
 		//  -> 현재 값보다 큰 것들은 전부 스택에서 pop / 현재 값은 다시 push ...1번
 		// 만약 가장 작은 값보다 작다면 전부 스택에서 pop / 현재 값은 다시 push...2번
 		// 만약 가장 큰 값보다 크면 그 값은 push 그리고 가장 큰 값을 해당 값으로 비교 ...3번
 		// 반복문이 종료될 시 스택의 모든 값을 pop하고 result를 return
 		
 		for(int i=0; i<prices.length; i++) {
 			if(i==prices.length-1) {
 				while(!stocks.isEmpty()){
 					stocks.pop();
 				}
 				break;
 			}
 			if(stocks.isEmpty()) {
 				stocks.push(new Stock(prices[i],i));
 				maxPrice = prices[i];
 				minPrice = prices[i];
 			} // 반복문이 종료 되기 전, 스택이 비어있을 시
 			else if(maxPrice<prices[i]) {
 				stocks.push(new Stock(prices[i],i));
 				maxPrice = prices[i];
 			} // 최대 가격보다 현재 주식 가격이 더 클 경우
 			else if(minPrice>prices[i]) {
 				while(!stocks.isEmpty()) {
 					stocks.pop();
 				}
 				stocks.push(new Stock(prices[i],i));
 				maxPrice = prices[i];
 				minPrice = prices[i];
 			} // 최소 가격보다 현재 주식 가격이 더 작은 경우
 			else if(maxPrice>prices[i]) {
 				for(int j=stocks.size(); j>=0; j--) {
 					if(stocks.get(j-1).price>prices[i]) {
 						stocks.pop();
 					}
 					else {
 						break;
 					}
 				}
 				stocks.push(new Stock(prices[i],i));
 				maxPrice = prices[i];
 			}  // 현재 주식 가격이 최소와 최대 사이에 있을 경우
 			else if(maxPrice == prices[i]) {
 				stocks.push(new Stock(prices[i],i));
 			}
 			for(int k=0; k<stocks.size(); k++) {
 				result[stocks.get(k).order]++;
 			}
 		}
 		
 		return result;
    }
    
}