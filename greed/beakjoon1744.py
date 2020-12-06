import sys
n = int(sys.stdin.readline().rstrip("\n"))
numsPlus = []
numsMinu = []
newNums=[]
sum=0
for i in range(n):
    temp = int(sys.stdin.readline().rstrip("\n"))
    if(temp==1):
        sum += 1
    elif(temp>1):
        numsPlus.append(temp)
    else:
        numsMinu.append(temp)

numsPlus = sorted(numsPlus, reverse=True)
numsMinu = sorted(numsMinu)

for i in range(0, len(numsPlus),2):
    if(i+1<len(numsPlus)):
        newNums.append(numsPlus[i] * numsPlus[i + 1])
    else:
        newNums.append(numsPlus[i])

for i in range(0,len(numsMinu),2):
    if(i+1<len(numsMinu)):
        newNums.append(numsMinu[i]*numsMinu[i+1])
    else:
        newNums.append(numsMinu[i])

for newNum in newNums:
    sum += newNum
print(sum)
