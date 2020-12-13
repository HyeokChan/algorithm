import sys
import heapq
n = int(sys.stdin.readline().rstrip("\n"))
k = int(sys.stdin.readline().rstrip("\n"))
nums = list(map(int, sys.stdin.readline().rstrip("\n").split()))
if(n<=k):
    print(0)
else:
    nums = sorted(nums)
    distance = []
    for i in range(0,n-1):
        temp = nums[i+1]-nums[i]
        heapq.heappush(distance,(-temp,temp))
    for i in range(k-1):
        heapq.heappop(distance)
    sum=0
    while distance:
        sum+=heapq.heappop(distance)[1]
    print(sum)