import sys
from collections import deque
n, k = map(int, sys.stdin.readline().rstrip("\n").split())
dx = [-1,1,2]
queue = deque()
visit=[0]*100001
visit[n]=1
queue.append(n)
x=0
while queue:
    x = queue.popleft()
    if (x == k):
        break
    for i in range(len(dx)):
        if (i == 2):
            num = x * dx[i]
        else:
            num = x + dx[i]
        if (0 <= num <= 100000 and visit[num] == 0):
            visit[num] = visit[x] + 1
            queue.append(num)

print(visit[x] - 1)



