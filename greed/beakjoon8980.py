import sys
n, c = map(int, sys.stdin.readline().rstrip("\n").split())
m = int(sys.stdin.readline().rstrip("\n"))
nums = []
temps = [c]*(n)
for _ in range(m):
    nums.append(list(map(int, sys.stdin.readline().rstrip("\n").split())))
nums = sorted(nums, key=lambda x:x[1])
ans=0
for i in range(len(nums)):
    minNum=c+1
    for j in range(nums[i][0],nums[i][1]):
        if(temps[j]<minNum):
            minNum = temps[j]

    t = min(minNum,nums[i][2])
    ans += t
    for j in range(nums[i][0], nums[i][1]):
        temps[j] -= t


print(ans)