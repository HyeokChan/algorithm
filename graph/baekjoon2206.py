import sys
from collections import deque
n, m = map(int, sys.stdin.readline().rstrip("\n").split())
matrix = []
dx=[-1,1,0,0]
dy=[0,0,-1,1]
visit=[[[0]*m for _ in range(n)] for _ in range(2)]
queue=deque()
for _ in range(n):
    matrix.append(list(map(int, sys.stdin.readline().rstrip("\n"))))

queue.append([1,0,0])
visit[1][0][0]=1
ans=-1
while queue:
    z, y, x = queue.popleft()
    if(y==n-1 and x==m-1):
        ans = visit[z][y][x]
        break
    for k in range(4):
        ny = y+dy[k]
        nx = x+dx[k]
        if(0<=ny<n and 0<=nx<m):
            if (matrix[ny][nx] == 1 and z == 1):
                visit[0][ny][nx] = visit[1][y][x] + 1
                queue.append([0, ny, nx])
            elif(matrix[ny][nx]==0 and visit[z][ny][nx]==0):
                visit[z][ny][nx] = visit[z][y][x]+1
                queue.append([z,ny,nx])

print(ans)
