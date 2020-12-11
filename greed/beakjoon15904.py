import sys
inputSts = sys.stdin.readline().rstrip("\n")
UCPCLists = []
for inputSt in inputSts:
    if(ord(inputSt)>=65 and ord(inputSt)<97):
        UCPCLists.append(inputSt)
temps = ['U','C','P','C']
count=0
for temp in temps:
    for i in range(0,len(UCPCLists)):
        if(temp == UCPCLists[i]):
            count+=1
            UCPCLists[i]='0'
            break
        else:
            UCPCLists[i] = '0'
if(count==4):
    print("I love UCPC")
else:
    print("I hate UCPC")
