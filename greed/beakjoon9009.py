import sys
t = int(sys.stdin.readline().rstrip("\n"))
pibo=[1,2]
for i in range(2,46):
    pibo.append(pibo[i-1]+pibo[i-2])
for i in range(t):
    n = int(sys.stdin.readline().rstrip("\n"))
    ans = []
    while(n):
        for j in range(46):
            if(pibo[j]<=n):
                temp = pibo[j]
        n-=temp
        ans.append(temp)

    for j in range(len(ans)-1,-1,-1):
        print(ans[j], end=" ")
    print("")

