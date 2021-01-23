import sys
import copy
n, m = map(int, sys.stdin.readline().rstrip("\n").split())
INF=n
matrix=[[INF]*n for _ in range(n)]
floyd=[]
ans=[]
for _ in range(m):
    a, b = map(int, sys.stdin.readline().rstrip("\n").split())
    matrix[a-1][b-1]=1
    matrix[b-1][a-1]=1

for i in range(n):
    matrix[i][i]=0

floyd = copy.deepcopy(matrix)
#거쳐가는 노드
for k in range(n):
    #출발 노드
    for i in range(n):
        #도착 노드
        for j in range(n):
            if(floyd[i][k]+floyd[k][j] < floyd[i][j]):
                floyd[i][j] = floyd[i][k]+floyd[k][j]

for low in floyd:
    ans.append(sum(low))
min = ans[0]
minIndex=1
for i in range(len(ans)):
    if(min>ans[i]):
        min=ans[i]
        minIndex=i+1
print(minIndex)
