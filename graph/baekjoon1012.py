import sys
from collections import deque
testcases = int(sys.stdin.readline().rstrip("\n"))
for _ in range(testcases):
    m, n, k = map(int, sys.stdin.readline().rstrip("\n").split())
    matrix = [[0]*m for _ in range(n)]
    visit = [[0]*m for _ in range(n)]
    dx=[-1,1,0,0]
    dy=[0,0,-1,1]
    queue = deque()
    count=0
    for i in range(k):
        x, y = map(int, sys.stdin.readline().rstrip("\n").split())
        matrix[y][x] = 1
    for i in range(n):
        for j in range(m):
            if(matrix[i][j]==1 and visit[i][j]==0):
                queue.append((i,j))
                visit[i][j]=1
                count+=1
                while queue:
                    y, x = queue.popleft()
                    for k in range(4):
                        nx = x+dx[k]
                        ny = y+dy[k]
                        if(0<=nx<m and 0<=ny<n and matrix[ny][nx]==1 and visit[ny][nx]==0):
                            queue.append((ny,nx))
                            visit[ny][nx]=1
    print(count)

