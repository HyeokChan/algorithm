import sys
n, k = map(int, sys.stdin.readline().rstrip("\n").split())
devices = list(map(int, sys.stdin.readline().rstrip("\n").split()))
count=0
tabs = []
temp=-1
deltab=-1
for i in range(0,len(devices)):
    if(len(tabs)<n and devices[i] not in tabs):
        tabs.append(devices[i])
    else:
        if(devices[i] in tabs):
            continue
        else:
            max = -1
            for tab in tabs:
                for j in range(i,k):
                    if(tab==devices[j]):
                        temp=(j-i)
                        break
                    elif(tab!=devices[j]):
                        temp=k

                if(max<temp):
                    max=temp
                    deltab = tab

            tabs.remove(deltab)
            tabs.append(devices[i])
            count+=1

print(count)
