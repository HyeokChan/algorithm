import sys
import heapq
n, m = map(int, sys.stdin.readline().rstrip("\n").split())
nheaps = list(map(int, sys.stdin.readline().rstrip("\n").split()))
heapq.heapify(nheaps)
for i in range(m):
    num1 = heapq.heappop(nheaps)
    num2 = heapq.heappop(nheaps)
    sum = num1+num2
    heapq.heappush(nheaps,sum)
    heapq.heappush(nheaps, sum)

ans = 0
while nheaps:
    ans += heapq.heappop(nheaps)
print(ans)
