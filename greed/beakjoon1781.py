import sys
import heapq
n = int(sys.stdin.readline().rstrip("\n"))
nums=[]
temps=[0]*(n+1)
for _ in range(n):
    deadline, value = map(int, sys.stdin.readline().rstrip("\n").split())
    nums.append((deadline,value))

nums = sorted(nums)
heaps=[]

for num in nums:
    heapq.heappush(heaps, num[1])
    if(num[0] < len(heaps)):
        heapq.heappop(heaps)
print(sum(heaps))
