import sys
from collections import deque
n = int(sys.stdin.readline().rstrip("\n"))
visit=[[0]*n for _ in range(n)]
matrix=[]
matrixRG=[]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
queue = deque()
count=0
countRG=0
alphabet=""

for i in range(n):
    temp = sys.stdin.readline().rstrip("\n")
    matrix.append(list(temp))
    temp = temp.replace("G","R")
    matrixRG.append(list(temp))
for i in range(n):
    for j in range(n):
        if(visit[i][j]==0):
            count+=1
            visit[i][j]=1
            queue.append((i,j))
            alphabet=matrix[i][j]
            while queue:
                y,x = queue.popleft()
                for k in range(4):
                    ny = y+dy[k]
                    nx = x+dx[k]
                    if(0<=ny<n and 0<=nx<n and visit[ny][nx]==0 and matrix[ny][nx]==alphabet):
                        visit[ny][nx]=1
                        queue.append((ny,nx))

visit=[[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if(visit[i][j]==0):
            countRG+=1
            visit[i][j]=1
            queue.append((i,j))
            alphabet=matrixRG[i][j]
            while queue:
                y,x = queue.popleft()
                for k in range(4):
                    ny = y+dy[k]
                    nx = x+dx[k]
                    if(0<=ny<n and 0<=nx<n and visit[ny][nx]==0 and matrixRG[ny][nx]==alphabet):
                        visit[ny][nx]=1
                        queue.append((ny,nx))

print(count, countRG)