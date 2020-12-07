import sys
g = int(sys.stdin.readline().rstrip("\n"))
p = int(sys.stdin.readline().rstrip("\n"))
pLists = [int(sys.stdin.readline().rstrip("\n")) for _ in range(0,p)]

def findParent(x):
   if parent[x] == x:
       return x
   p = findParent(parent[x])
   parent[x]=p
   return parent[x]

def unionParent(x,y):
    x = findParent(x)
    y = findParent(y)
    if x<y:
        parent[y] = x
    else:
        parent[x] = y
# 이중 반복문으로는 시간 초과 => union-find이용
parent = {i:i for i in range(0,g+1)} #{0:0, 1:1, 2:2, 3:3, 4:4}
count=0
for pList in pLists:
    x = findParent(pList)
    if x==0:
        break
    unionParent(x,x-1)
    count+=1
print(count)