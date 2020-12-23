import sys
n = int(sys.stdin.readline().rstrip("\n"))
m = int(sys.stdin.readline().rstrip("\n"))
infosA=[]
infosB=[]
for i in range(m):
    start, end = map(int, sys.stdin.readline().rstrip("\n").split())
    if(start<end):
        infosA.append([start,end,i+1])
    elif(end<start):
        infosB.append([start,end,i+1])

infosA = sorted(infosA, key=lambda x:(x[0],-x[1]))
infosB = sorted(infosB, key=lambda x:(x[0],-x[1]))
#정방향-정방향
if(len(infosA)>0):
    stateA = infosA[0]
for i in range(1,len(infosA)):
    if(stateA[1]>=infosA[i][1]):
        infosA[i][2]=-1
    else:
        stateA = infosA[i]
#역방향-역방향
if(len(infosB)>0):
    stateB = infosB[0]
for i in range(1,len(infosB)):
    if(stateB[1]>=infosB[i][1]):
        infosB[i][2] = -1
    else:
        stateB = infosB[i]
#역방향-정방향
sB = infosB[0][0]
temp = sorted(infosB[:],key=lambda x:-x[1])
eB = temp[0][1]
for i in range(len(infosA)):
    if(infosA[i][0]>=sB or infosA[i][1]<=eB):
        infosA[i][2] = -1

ans = []
for i in range(len(infosA)):
    if(infosA[i][2]>0):
        ans.append(infosA[i][2])
for i in range(len(infosB)):
    if(infosB[i][2]>0):
        ans.append(infosB[i][2])
ans = sorted(ans)
for a in ans:
    print(a,end=" ")




