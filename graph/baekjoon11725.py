import sys
sys.setrecursionlimit(100000)
n = int(sys.stdin.readline().rstrip("\n"))
matrix=[[] for _ in range(n+1)]
visit=[0]*(n+1)
for i in range(n-1):
    start, end = map(int, sys.stdin.readline().rstrip("\n").split())
    matrix[start].append(end)
    matrix[end].append(start)

def dfs(start, matrix, visit):
    for i in matrix[start]:
        if(visit[i]==0):
            visit[i]=start
            dfs(i,matrix,visit)
dfs(1, matrix, visit)

for i in range(2,len(visit)):
    print(visit[i])