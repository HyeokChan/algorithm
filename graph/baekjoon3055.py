import sys
from collections import deque
r, c = map(int,sys.stdin.readline().rstrip("\n").split())
matrix=[]
visitWater=[[0]*c for _ in range(r)]
visitDoch=[[0]*c for _ in range(r)]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
queue=deque()
water=deque()
for _ in range(r):
    matrix.append(list(sys.stdin.readline().rstrip("\n")))

for i in range(r):
    for j in range(c):
        if(matrix[i][j]=="*"):
            water.append([i,j])
            visitWater[i][j]=1
        if (matrix[i][j]=="S"):
            queue.append([i,j])
            visitDoch[i][j]=1
        if (matrix[i][j]=="D"):
            goalY=i
            goalX=j

while water:
    y,x = water.popleft()
    for k in range(4):
        ny = y+dy[k]
        nx = x+dx[k]
        if(0<=ny<r and 0<=nx<c and matrix[ny][nx]!="D" and matrix[ny][nx]!="X"
                and visitWater[ny][nx]==0):
            water.append([ny,nx])
            visitWater[ny][nx] = visitWater[y][x]+1

while queue:
    y,x = queue.popleft()
    for k in range(4):
        ny = y + dy[k]
        nx = x + dx[k]
        if (0<=ny<r and 0<=nx<c and visitDoch[ny][nx] == 0 and matrix[ny][nx]!="X"):
            visitDoch[ny][nx] = visitDoch[y][x] + 1
            if(visitDoch[ny][nx]<visitWater[ny][nx] or visitWater[ny][nx]==0):
                queue.append([ny, nx])


if(visitDoch[goalY][goalX]==0):
    print("KAKTUS")
else:
    print(visitDoch[goalY][goalX]-1)