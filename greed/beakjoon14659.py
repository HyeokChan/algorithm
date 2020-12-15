import sys
n = int(sys.stdin.readline().rstrip("\n"))
nums = list(map(int, sys.stdin.readline().rstrip("\n").split()))
max = -1
for i in range(n-1):
    count=0
    for j in range(i+1,n):
        if(nums[i]>nums[j]):
            count+=1
        else:
            break
    if(max<count):
        max = count
print(max)