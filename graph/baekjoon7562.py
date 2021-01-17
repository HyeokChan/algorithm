import sys
from collections import deque
testcase = int(sys.stdin.readline().rstrip("\n"))
for _ in range(testcase):
    l = int(sys.stdin.readline().rstrip("\n"))
    sx, sy = map(int, sys.stdin.readline().rstrip("\n").split())
    fx, fy = map(int, sys.stdin.readline().rstrip("\n").split())
    matrix = [[0]*l for _ in range(l)]
    visit = [[0]*l for _ in range(l)]
    count=0
    queue = deque()
    visit[sy][sx]=1
    dx = [1,2,2,1,-1,-2,-2,-1]
    dy = [-2,-1,1,2,2,1,-1,-2]
    queue.append((sy, sx))
    while queue:
        y, x = queue.popleft()
        if (y == fy and x == fx):
            count = matrix[y][x]
            break
        for k in range(8):
            ny = y + dy[k]
            nx = x + dx[k]
            if (0 <= ny < l and 0 <= nx < l and visit[ny][nx] == 0):
                queue.append((ny, nx))
                visit[ny][nx] = 1
                matrix[ny][nx] = matrix[y][x] + 1

    print(count)

