# 백트래킹
백트래킹 알고리즘 **더이상 탐색을 할 수 없을 경우 이전 단계로 돌아간다** 라는 특성을 갖고 있다. 즉, 완전탐색을 기본적으로 진행하는 과정에서 불필요한 과정을 배제하여 탐색을 진행한다는 것이다.

![N-Queen](https://t1.daumcdn.net/cfile/tistory/99B8D13F5A927B1132)

위 그림을 보자. 체스에서 가장 강력한 말인 퀸은 해당 위치로부터 가로, 세로, 대각선(4방향) 총 8방향으로 움직일 수 있는 말이다. 만일 4X4의 크기의 체스판에서 4개의 퀸을 놓을 수 있는 위치를 찾는 상황이 주어진다면, 모든 위치에 퀸을 놓으면서 해당 조건을 만족하는 위치를 모두 탐색하면 찾을 수 있다. 하지만 그 과정은 많은 불필요한 과정을 갖고 있다.

그래서 백트래킹의 개념인 완전 탐색하는 과정에서 **불필요한 조건(환경)** 을 배제하고 탐색하는 환경을 조성한다면 보다 빠르고 효율적으로 위 문제를 해결할 수 있다. 즉, **백트래킹** 은 나무가 원활하게 자랄 수 있도록 **가지치기**  하는 것 처럼 탐색 과정에서 굳이 탐색할 필요없는 순서를 사전에 미리 제거를 하고 난 뒤에 탐색을 진행하는 방법이다.

-   정리하자면, 백트래킹은 모든 가능한 경우의 수 중에서  **특정한 조건을 만족하는 경우만 살펴보는 것**이다.
    
-   즉  **답이 될 만한지 판단하고 그렇지 않으면 그 부분까지 탐색하는 것을 하지 않고 가지치기 하는 것**을 백트래킹이다.
-   주로 문제 풀이에서는  **DFS 등으로 모든 경우의 수를 탐색하는 과정**에서,  **조건문 등을 걸어 답이 절대로 될 수 없는 상황을 정의하고, 그러한 상황일 경우에는 탐색을 중지시킨 뒤 그 이전으로 돌아가서 다시 다른 경우를 탐색하게끔**  구현할 수 있음.