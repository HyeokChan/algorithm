import sys
n = int(sys.stdin.readline().rstrip("\n"))
nums = []
nums = [int(sys.stdin.readline().rstrip("\n")) for _ in range(n)]
ans=0
for i in range(n-2,-1,-1):
    if(nums[i] >= nums[i+1]):
        value = nums[i]-nums[i+1]+1
        nums[i] =  nums[i]-value
        ans+=value
print(ans)
