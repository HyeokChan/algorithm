import sys
from collections import deque
n = int(sys.stdin.readline().rstrip("\n"))
m = int(sys.stdin.readline().rstrip("\n"))
state = []
virus=[1]
queue=deque()
queue.append(1)
for i in range(m):
    state.append(list(map(int, sys.stdin.readline().rstrip("\n").rstrip("\n").split())))
while queue:
    x = queue.popleft()
    for i in range(len(state)):
        if(state[i][0]==x and state[i][1] not in virus):
            queue.append(state[i][1])
            virus.append(state[i][1])
        elif(state[i][1]==x and state[i][0] not in virus):
            queue.append(state[i][0])
            virus.append(state[i][0])

print(len(virus)-1)