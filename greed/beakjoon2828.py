import sys
n, m = map(int, sys.stdin.readline().rstrip("\n").split())
j = int(sys.stdin.readline().rstrip("\n"))
nums=[]
for i in range(j):
    nums.append(int(sys.stdin.readline().rstrip("\n")))
count=0
size=m-1
left=1
right = left+size
for i in range(len(nums)):
    if(left<=nums[i] and nums[i]<=right):
        continue
    if(nums[i]>right):
        temp = abs(nums[i]-right)
        count+=temp
        right+=temp
        left+=temp
    if(nums[i]<left):
        temp = abs(nums[i]-left)
        count+=temp
        left-=temp
        right-=temp


print(count)