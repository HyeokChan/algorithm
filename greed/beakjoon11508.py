import sys
n = int(sys.stdin.readline().rstrip("\n"))
nums=[int(sys.stdin.readline().rstrip("\n")) for _ in range(n)]
nums = sorted(nums, reverse=True)
k=2
ans=0
for i in range(n):
    if(i==k):
        k+=3
        continue
    ans+=nums[i]
print(ans)