import sys
from collections import deque
n = int(sys.stdin.readline().rstrip("\n"))
num1, num2 = map(int, sys.stdin.readline().rstrip("\n").split())
m = int(sys.stdin.readline().rstrip("\n"))
visit=[0]*n
matrix=[[0]*n for _ in range(n)]
queue=deque()
for i in range(m):
    x,y = map(int, sys.stdin.readline().rstrip("\n").split())
    matrix[x-1][y-1]=1
    matrix[y-1][x-1] = 1

queue.append(num1-1)
while queue:
    num = queue.popleft()
    for i in range(n):
        if(matrix[num][i]==1 and visit[i]==0):
            visit[i] = visit[num]+1
            queue.append(i)

if visit[num2-1]>0:
    print(visit[num2-1])
else:
    print(-1)
