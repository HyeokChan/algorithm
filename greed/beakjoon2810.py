import sys
import heapq
n = int(sys.stdin.readline())
seatStrings = list(sys.stdin.readline().rstrip("\n"))
seatStrings = sorted(seatStrings,reverse=True)
heapq.heapify(seatStrings)
ans=1
while seatStrings:
    temp = heapq.heappop(seatStrings)
    if(temp=="L"):
        ans+=1
        heapq.heappop(seatStrings)
    elif(temp=="S"):
        ans+=1
    if(ans==n):
        break

print(ans)