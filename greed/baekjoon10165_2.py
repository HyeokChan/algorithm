import sys
n = int(sys.stdin.readline().rstrip("\n"))
m = int(sys.stdin.readline().rstrip("\n"))
infos1=[]
infos2=[]
for i in range(m):
    start, end = map(int, sys.stdin.readline().rstrip("\n").split())
    if(start>end):
        infos1.append([start-n,end,i+1])
        infos2.append([start,end+n,i+1])
    else:
        infos1.append([start,end,i+1])
        infos2.append([start,end,i+1])

infos1 = sorted(infos1, key=lambda x:(x[0],-x[1]))
infos2 = sorted(infos2, key=lambda x:(x[0],-x[1]))
exceptList=[]
check=[1]*(m+1)
state = infos1[0]
for i in range(1,m):
    if(state[1]>=infos1[i][1]):
        exceptList.append(infos1[i][2])
        check[infos1[i][2]] = 0
    elif(state[1]<infos1[i][1]):
        state=infos1[i]
state = infos2[0]
for i in range(1,m):
    if(state[1]>=infos2[i][1]):
        exceptList.append(infos2[i][2])
        check[infos2[i][2]] = 0
    elif(state[1]<infos2[i][1]):
        state=infos2[i]

for i in range(1,m+1):
    if(check[i]>0):
        print(i,end=" ")
