import sys
from collections import deque
m, n = map(int, sys.stdin.readline().rstrip("\n").split())
matrix = []
queue=deque()
dx=[-1,1,0,0]
dy=[0,0,-1,1]
for i in range(n):
    matrix.append(list(map(int, sys.stdin.readline().rstrip("\n").split())))

for i in range(n):
    for j in range(m):
        if(matrix[i][j]==1):
            queue.append((i,j))
while queue:
    x,y = queue.popleft()
    for k in range(4):
        nx = x+dx[k]
        ny = y+dy[k]
        if(0<=nx<n and 0<=ny<m and matrix[nx][ny]==0):
            queue.append((nx,ny))
            matrix[nx][ny] = matrix[x][y]+1
max=-1
breaker=False
for i in range(n):
    for j in range(m):
        if(matrix[i][j]==0):
            print(-1)
            breaker=True
            break
        else:
            if(max<matrix[i][j]):
                max=matrix[i][j]
    if(breaker):
        break
if(not breaker):
    print(max-1)
