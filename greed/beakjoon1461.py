import sys
n, m = map(int, sys.stdin.readline().rstrip("\n").split())
nums = list(map(int, sys.stdin.readline().rstrip("\n").split()))
minus = []
plus = []
for num in nums:
    if(num<0):
        minus.append(num)
    else:
        plus.append(num)
minus = sorted(minus)
plus = sorted(plus,reverse=True)
minus_num=0
if(len(minus)>0):
    minus_num = min(minus)
plus_num = 0
if(len(plus)>0):
    plus_num = max(plus)
if(abs(minus_num) >= abs(plus_num)):
    last_value = minus_num
    for _ in range(m):
        if (len(minus) > 0):
            minus.remove(minus[0])
else:
    last_value = plus_num
    for _ in range(m):
        if (len(plus) > 0):
            plus.remove(plus[0])
ans=0
for i in range(0,len(minus),m):
    ans+=abs(minus[i])*2
for i in range(0,len(plus),m):
    ans+=plus[i]*2
ans += abs(last_value)
print(ans)
