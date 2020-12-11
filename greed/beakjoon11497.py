import sys
import heapq
testCases = int(sys.stdin.readline().rstrip("\n"))
for i in range(testCases):
    n = int(sys.stdin.readline().rstrip("\n"))
    nheaps = list(map(int, sys.stdin.readline().rstrip("\n").split()))
    heapq.heapify(nheaps)
    temp = []
    while nheaps:
        temp.append(heapq.heappop(nheaps))
        if(nheaps):
            temp.insert(0,heapq.heappop(nheaps))

    max=-1
    for i in range(0, len(temp)):
        if(i+1<len(temp)):
            if(abs(temp[i]-temp[i+1])>max):
                max = abs(temp[i]-temp[i+1])
        else:
            if(abs(temp[len(temp)-1]-temp[0])>max):
                max = abs(temp[len(temp)-1]-temp[0])
    print(max)