import sys

def printCodd():
    for i in range(c//2):
        print("D"*(r-1),end="")
        print("R",end="")
        print("U"*(r-1),end="")
        print("R",end="")
    print("D"*(r-1))

def printRoddCeven():
    for i in range(r//2):
        print("R"*(c-1),end="")
        print("D",end="")
        print("L"*(c-1),end="")
        print("D",end="")
    print("R"*(c-1))

def printRevenCeven(temps):
    min = 1000
    indexi=-1
    indexj=-1
    for i in range(r):
        for j in range(c):
            if((i+j)%2!=0 and min>temps[i][j]):
                min=temps[i][j]
                indexi=i
                indexj=j
    res = ('D'*(r-1)+'R'+'U'*(r-1)+'R')*(indexj//2)
    currentX=2*(indexj//2)
    currentY=0
    xbound=2*(indexj//2)+1
    while currentX!=xbound or currentY!=r-1:
        if(currentX<xbound and [currentY,xbound]!=[indexi,indexj]):
            currentX+=1
            res+='R'
        elif currentX == xbound and [currentY, xbound - 1] != [indexi,indexj]:
            currentX -= 1
            res += 'L'
        if currentY != r - 1:
            currentY += 1
            res += 'D'
    res += ('R' + 'U' * (r - 1) + 'R' + 'D' * (r - 1)) * ((c - indexj - 1) // 2)
    print(res)

r, c = map(int, sys.stdin.readline().rstrip("\n").split())
nums = []
for i in range(r):
    nums.append(list(map(int, sys.stdin.readline().rstrip().split())))
start=nums[0][0]
end=nums[r-1][c-1]
temps=nums[:]
if(c%2!=0):
    printCodd()
elif(r%2!=0):
    printRoddCeven()
elif(c%2==0 and r%2==0):
    printRevenCeven(temps)

