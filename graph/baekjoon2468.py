import sys
from collections import deque
import copy
n = int(sys.stdin.readline().rstrip("\n"))
matrix=[]
dx=[-1,1,0,0]
dy=[0,0,-1,1]
for i in range(n):
    matrix.append(list(map(int, sys.stdin.readline().rstrip("\n").split())))
maxh = max(max(matrix))
ans=-1
for i in range(0,maxh+1):
    tempMatrix=copy.deepcopy(matrix)
    visit=[[0]*n for _ in range(n)]
    queue=deque()
    count=0
    for p in range(n):
        for q in range(n):
            if(tempMatrix[p][q]<=i):
                tempMatrix[p][q]=0
    for p in range(n):
        for q in range(n):
            if(tempMatrix[p][q]!=0 and visit[p][q]==0):
                queue.append((p,q))
                visit[p][q]=1
                count+=1
                while queue:
                    y, x = queue.popleft()
                    for k in range(4):
                        ny = y+dy[k]
                        nx = x+dx[k]
                        if(0<=ny<n and 0<=nx<n and visit[ny][nx]==0 and tempMatrix[ny][nx]!=0):
                            queue.append((ny,nx))
                            visit[ny][nx]=1
    if(ans<count):
        ans = count
print(ans)


