import sys
from collections import deque
while(True):
    w, h = map(int, sys.stdin.readline().rstrip("\n").split())
    if(w==0 and h==0):
        break
    visit=[[0]*w for _ in range(h)]
    matrix=[]
    queue = deque()
    count=0
    dx=[-1,1,0,0,-1,1,-1,1]
    dy=[0,0,-1,1,-1,-1,1,1]
    for i in range(h):
        matrix.append(list(map(int, sys.stdin.readline().rstrip("\n").split())))

    for i in range(h):
        for j in range(w):
            if(matrix[i][j]==1 and visit[i][j]==0):
                queue.append((i,j))
                count+=1
                while queue:
                    y, x = queue.popleft()
                    for k in range(8):
                        ny = y+dy[k]
                        nx = x+dx[k]
                        if(0<=ny<h and 0<=nx<w and visit[ny][nx]==0 and matrix[ny][nx]==1):
                            queue.append((ny,nx))
                            visit[ny][nx]=1
    print(count)