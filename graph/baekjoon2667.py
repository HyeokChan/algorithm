import sys
n = int(sys.stdin.readline().rstrip("\n"))
matrix=[]
visit=[[0]*n for _ in range(n)]
for i in range(n):
    matrix.append(list(map(int,sys.stdin.readline().rstrip("\n"))))
dx=[-1,1,0,0]
dy=[0,0,-1,1]
count=1
sortList=[]
for i in range(n):
    for j in range(n):
        if(matrix[i][j]==1 and visit[i][j]==0):
            queue=[(i,j)]
            visit[i][j]=count
            tempCount=1
            while queue:
                x,y = queue.pop(0)
                for k in range(4):
                    nx = x + dx[k]
                    ny = y + dy[k]
                    if(0<=nx<n and 0<=ny<n and matrix[nx][ny]==1
                            and visit[nx][ny]==0):
                        visit[nx][ny]=count
                        tempCount+=1
                        queue.append((nx,ny))
            count+=1
            sortList.append(tempCount)

sortList = sorted(sortList)
print(count-1)
for sortNum in sortList:
    print(sortNum)
