import sys
testCases = int(sys.stdin.readline().rstrip("\n"))
for _ in range(testCases):
    n = int(sys.stdin.readline().rstrip("\n"))
    mapSt1 = sys.stdin.readline().rstrip("\n")
    mapSt2 = sys.stdin.readline().rstrip("\n")
    count=0
    Bcount=0
    Wcount=0
    ans=0
    mapList1=[]
    mapList2=[]
    for i in range(n):
        if(mapSt1[i]!=mapSt2[i]):
            mapList1.append(mapSt1[i])
            mapList2.append(mapSt2[i])


    mapList1 = sorted(mapList1)
    mapList2 = sorted(mapList2)
    for i in range(len(mapList1)):
        if (mapList1[i] == mapList2[i]):
            ans += 0.5
        else:
            ans += 1
    print(int(ans))
