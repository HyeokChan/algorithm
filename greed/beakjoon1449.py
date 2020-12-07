import sys
n,l = map(int, sys.stdin.readline().rstrip("\n").split())
locations = list(map(int, sys.stdin.readline().rstrip("\n").split()))
count=1
locations = sorted(locations)
start = locations[0]
end = locations[0]+l
for i in range(0,n):
    if(start<=locations[i] and locations[i]<end):
        continue
    else:
        start = locations[i]
        end = locations[i] + l
        count+=1

print(count)
