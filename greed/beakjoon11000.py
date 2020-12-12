import sys
import heapq
n = int(sys.stdin.readline().rstrip("\n"))
classes = []
for i in range(n):
    classes.append(list(map(int, sys.stdin.readline().rstrip("\n").split())))
classes = sorted(classes, key=lambda x:x[0])
nheapps = []
heapq.heapify(nheapps)
heapq.heappush(nheapps, classes[0][1])

for i in range(1,n):
    if(nheapps[0] <= classes[i][0]):
        heapq.heappop(nheapps)
        heapq.heappush(nheapps,classes[i][1])
    else:
        heapq.heappush(nheapps,classes[i][1])

print(len(nheapps))

