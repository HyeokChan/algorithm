import sys
n, m ,v = map(int, sys.stdin.readline().rstrip("\n").split())
matrix = [[0]*(n+1) for _ in range(n+1)]
for i in range(0,m):
    num1, num2 = map(int, sys.stdin.readline().rstrip("\n").split())
    matrix[num1][num2] = 1
    matrix[num2][num1] = 1

visit = [0]*(n+1)

def dfs(v):
    visit[v]=1
    print(v,end=" ")
    for i in range(1,n+1):
        if(visit[i]==0 and matrix[v][i]==1):
            dfs(i)

def bfs(v):
    queue=[v]
    visit[v]=0
    while queue:
        v = queue.pop(0)
        print(v,end=" ")
        for i in range(1,n+1):
            if(visit[i]==1 and matrix[v][i]==1):
                queue.append(i)
                visit[i]=0

dfs(v)
print()
bfs(v)


