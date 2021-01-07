import sys
sys.setrecursionlimit(10000)
w, h, k = map(int, sys.stdin.readline().rstrip("\n").split())
matrix=[[0]*w for _ in range(h)]
ans = []
dx=[-1,1,0,0]
dy=[0,0,-1,1]
count=0
def dfs(q,p):
    global count
    matrix[q][p]=1
    count+=1
    for t in range(4):
        ny = q+dy[t]
        nx = p+dx[t]
        if(0<=ny<h and 0<=nx<w and matrix[ny][nx]==0):
            dfs(ny,nx)

for i in range(k):
    y1,x1,y2,x2=map(int, sys.stdin.readline().rstrip("\n").split())
    for q in range(y1, y2):
        for p in range(x1,x2):
            matrix[q][p]=-1


for q in range(h):
    for p in range(w):
        if(matrix[q][p]==0):
            count=0
            dfs(q,p)
            ans.append(count)

ans = sorted(ans)
print(len(ans))
for ansIndex in ans:
    print(ansIndex,end=" ")
