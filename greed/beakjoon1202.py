import sys
import heapq

n, k = map(int, sys.stdin.readline().rstrip("\n").split())
nheaps = []
kLists = []
money=0
for i in range(n):
    m, v = map(int,sys.stdin.readline().rstrip("\n").split())
    heapq.heappush(nheaps,(m,v))

for i in range(k):
    kLists.append(int(sys.stdin.readline().rstrip("\n")))
kLists = sorted(kLists)

possible=[]
for i in range(0,len(kLists)):
    while nheaps and kLists[i]>=nheaps[0][0]:
        (m,v) = heapq.heappop(nheaps)
        heapq.heappush(possible,-v)
    if possible:
        money-=heapq.heappop(possible)
print(money)