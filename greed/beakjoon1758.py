import sys
n = int(sys.stdin.readline().rstrip("\n"))
values = []
for _ in range(n):
    values.append(int(sys.stdin.readline().rstrip("\n")))
values = sorted(values,reverse=True)
coin=0
for i in range(len(values)):
    temp = values[i]-((i+1)-1)
    if(temp<0):
        temp=0
    coin+=temp
print(coin)