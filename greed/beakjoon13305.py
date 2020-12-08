import sys
n = int(sys.stdin.readline())
distance = list(map(int, sys.stdin.readline().rstrip("\n").split()))
distance.append(0)
price = list(map(int, sys.stdin.readline().rstrip("\n").split()))
dicLists = []
for i in range(0,n-1):
    dicLists.append([price[i],distance[i]])
money = 0
distanceSum=0
minPrice=1000000000
for i in range(0,len(dicLists)):
    if(dicLists[i][0] < minPrice):
        minPrice=dicLists[i][0]
    money+=minPrice*dicLists[i][1]
print(money)
