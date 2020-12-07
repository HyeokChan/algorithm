import sys
n = int(sys.stdin.readline().rstrip("\n"))
nums = list(map(int, sys.stdin.readline().rstrip("\n").split()))
nums = sorted(nums)
state=1
for num in nums:
    if(state<num):
        break
    else:
        state+=num
print(state)