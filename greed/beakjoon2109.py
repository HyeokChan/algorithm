import sys
import heapq
n = int(sys.stdin.readline().rstrip("\n"))
nums = []
for _ in range(n):
    value, day = map(int, sys.stdin.readline().rstrip().split())
    nums.append([value, day])
nums = sorted(nums, key=lambda x:x[1])
sums = []
for num in nums:
    heapq.heappush(sums,num[0])
    if(len(sums) > num[1]):
        heapq.heappop(sums)
print(sum(sums))