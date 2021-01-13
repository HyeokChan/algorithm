import sys
from collections import deque
m, n, h = map(int, sys.stdin.readline().rstrip("\n").split())
matrix = []
visit = [[[0]*m for _ in range(n)] for _ in range(h)]
dx = [-1,1,0,0,0,0]
dy = [0,0,-1,1,0,0]
dz = [0,0,0,0,-1,1]
queue = deque()
ans = -1
for _ in range(h):
    temp=[]
    for _ in range(n):
        temp.append(list(map(int, sys.stdin.readline().rstrip("\n").split())))
    matrix.append(temp)

for i in range(h):
    for j in range(n):
        for k in range(m):
            if(matrix[i][j][k]==1):
                queue.append([i,j,k])

while queue:
    z, y, x = queue.popleft()
    visit[z][y][x]=1
    for t in range(6):
        nz = z + dz[t]
        ny = y + dy[t]
        nx = x + dx[t]
        if (0 <= nz < h and 0 <= ny < n and 0 <= nx < m
                and matrix[nz][ny][nx]==0 and visit[nz][ny][nx]==0):
            queue.append([nz, ny, nx])
            matrix[nz][ny][nx] = matrix[z][y][x] + 1
            visit[nz][ny][nx] = 1
check=False
for i in range(h):
    for j in range(n):
        for k in range(m):
            if(matrix[i][j][k]==0):
                check=True
            else:
                ans = max(ans, matrix[i][j][k])

if(check):
    print(-1)
else:
    print(ans-1)

