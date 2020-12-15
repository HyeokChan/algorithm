import sys
sts = sys.stdin.readline().rstrip("\n")
splitSts = sts.split(".")
ans = []
fail=False
for splitSt in splitSts:
    if(len(splitSt)>=4 and len(splitSt)%2==0):
        splitSt = "AAAA"*(len(splitSt)//4) + "BB"*((len(splitSt)%4)//2)
        ans.append(splitSt)
    elif(len(splitSt)%2==0):
        splitSt = "BB"*(len(splitSt)//2)
        ans.append(splitSt)
    else:
        fail=True
        break

if(fail):
    print(-1)
else:
    for i in range(len(ans)):
        if(i==len(ans)-1):
            print(ans[i])
        else:
            print(ans[i],end=".")

