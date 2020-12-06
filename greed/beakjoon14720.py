import sys
N = int(sys.stdin.readline())
inputs = list(map(int,sys.stdin.readline().rstrip("\n").split()))
state=0
count=0
for i in range(0,len(inputs)):
    if(inputs[i] == state%3):
       count+=1
       state+=1
print(count)



