# 스택과 큐의 필요성
알고리즘 문제를 풀다보면 배열이라는 자료구조에 한계가 있을때가 많다. 그래서 자료구조에서 가장 기초적인 스택(Stack)과 큐(Queue)에 대해서 알아볼 필요가 있다. 향후 DFS / BFS 알고리즘을 배울 때 백트래킹이 아닌 스택 혹은 큐로 해당 알고리즘을 구현할 수 있다.


# 스택(Stack)

스택(Stack)은 **선입후출(First In Last Out)** 의 구조를 띈 자료구조이다. 데이터를 순차적으로 저장한 뒤에 다시 데이터 끄집어 낼 때의 순서가 역순으로 배출하는 구조를 갖고 있다.
![스택](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FchSIl3%2Fbtqx60O47Om%2Fg4dMrq8KSyobAkspK6JLJ0%2Fimg.png)
위 그림을 보면 PUSH를 통해 데이터를 순차적으로 쌓는 모습을 확인할 수 있다. 그리고 POP을 통해 스택 안에 있는 데이터를 삭제(추출)을 할 수 있다.

해당 개념은 재귀함수에서도 확인 할 수 있다.
![재귀함수](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FdzKRgB%2Fbtqx7mK8pAB%2FBtC7WQBS3xB0FU7ty1y1W1%2Fimg.png)
재귀함수 즉, 자기 자신의 함수를 계속 호출 한 뒤에 그 함수가 종료되면 가장 늦게 호출한 함수부터 종료되는 것을 확인 할 수 있다.

## 큐(QUEUE)

**큐(Queue)** 는 스택과 정반대의 성질을 띈 자료구조이다. **선입선출(First In First Out)** 의 특징을 갖는다. 즉, 가장 먼저들어온 자료가 가장 먼저 삭제(추출) 된다는 의미를 뜻한다. 
![재귀함수](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FzHUPa%2Fbtqx60VRYdp%2FQPMF62rkahGSL5tzl5TYbK%2Fimg.png)
우리가 흔히 접할 수 있는 순서대로 처리하는 형태이다.
물건을 구매하기 위해, 줄을 선 순서대로 살 수 있는 그러한 구조이다.
이러한 구조이기에, 마지막에 삽입한 요소를 삭제하기 위해서는 앞에 요소들이 전부 삭제되어야한다.


## 덱(Deque / Double-ended Queue)

![데큐](https://t1.daumcdn.net/cfile/tistory/273851475639BB6510)
위 그림을 보면 좀 더 빠르게 이해할 수 있다. 덱(Deque)는 앞/뒤로 데이터를 삽입과 삭제가 가능한 자료구조이다. 즉, 스택과 큐의 특징을 둘다 보유하고 있는 자료구조이다. 이를 사용하기 위해서는 **Front** 와 **Rear** 를 유지켜줘야한다. 데이터가 앞에서 들어올 경우 최근에 들어온 데이터가 Front가 된다. 반대로 뒤로 들어온 데이터는 Rear 위치의 기준이 된다.
