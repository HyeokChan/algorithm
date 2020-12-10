import sys
testCase = int(sys.stdin.readline().rstrip("\n"))
for i in range(testCase):
    n, k = map(int, sys.stdin.readline().rstrip("\n").split())
    nLists=[0]*(n+1)
    kLists=[[0,0]]
    for i in range(k):
        a, b = map(int, sys.stdin.readline().rstrip("\n").split())
        kLists.append([a,b])
    kLists = sorted(kLists, key=lambda x:x[0])
    kLists = sorted(kLists, key=lambda x:x[1])
    count=0
    for i in range(1, len(kLists)):
        for j in range(kLists[i][0], kLists[i][1]+1):
            if(nLists[j]==0):
                nLists[j]=1
                count+=1
                break
    print(count)
