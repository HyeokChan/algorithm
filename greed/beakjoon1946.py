import sys

testCase = int(sys.stdin.readline().rstrip("\n"))

for i in range(0,testCase):
    lanks = []
    count = 0
    applicant = int(sys.stdin.readline().rstrip("\n"))
    for i in range(0,applicant):
        lanks.append(list(map(int,sys.stdin.readline().rstrip("\n").split())))
    lanks = sorted(lanks, key=lambda x:x[0])
    min = lanks[0][1]
    for i in range(1,len(lanks)):
        if(lanks[i][1]<min):
            min = lanks[i][1]
        else:
            count+=1
    print(len(lanks)-count)


