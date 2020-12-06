import sys
a, b = map(int,sys.stdin.readline().rstrip("\n").split())
listA = [list(map(int,sys.stdin.readline().rstrip("\n"))) for _ in range(0,a)]
listB = [list(map(int,sys.stdin.readline().rstrip("\n"))) for _ in range(0,a)]
count=0

def reverseList(t,s):
    global count
    count += 1
    for i in range(t,t+3):
        for j in range(s,s+3):
            listA[i][j] = abs(1-listA[i][j])


for i in range(0,a-2):
    for j in range(0,b-2):
        if(listA[i][j] != listB[i][j]):
            reverseList(i,j)

for i in range(0,a):
    for j in range(0,b):
        if(listA[i][j] != listB[i][j]):
            count = -1

print(count)

