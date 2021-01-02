import sys
n, m = map(int, sys.stdin.readline().rstrip("\n").split())
matrix = []
for i in range(n):
    temp = list(map(int, sys.stdin.readline().rstrip("\n")))
    matrix.append(temp)
visit=[[0]*m for _ in range(n)]

dx = [-1,1,0,0]
dy = [0,0,-1,1]
queue=[(0,0)]
visit[0][0]=1

while queue:
    x,y=queue.pop(0)
    if x==n-1 and y==m-1:
        print(visit[x][y])
        break
    for i in range(4):
        x_ = x + dx[i]
        y_ = y + dy[i]
        if(x_>=0 and x_<n and y_>=0 and y_<m):
            if(visit[x_][y_] == 0 and matrix[x_][y_]==1):
                visit[x_][y_] = visit[x][y] + 1
                queue.append((x_,y_))