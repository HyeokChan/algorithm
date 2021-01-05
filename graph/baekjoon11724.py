import sys

n, m = map(int, sys.stdin.readline().rstrip("\n").split())
visit=[0]*(n+1)
count=0
matrix = [[0]*(n+1) for _ in range(n+1)]
def dfs(i):
    visit[i]=1
    for j in range(1,n+1):
        if(matrix[i][j]==1 and visit[j]==0):
            dfs(j)

for i in range(m):
    num1, num2 = map(int, sys.stdin.readline().rstrip("\n").split())
    matrix[num1][num2]=1
    matrix[num2][num1]=1

for i in range(1,n+1):
    if(visit[i]==0):
        dfs(i)
        count+=1
print(count)