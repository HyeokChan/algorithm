import sys
n = int(sys.stdin.readline().rstrip("\n"))

if(n%5==0):
    print(n//5)
else:
    for i in range(n//5,-1,-1):
        count = -1
        temp = n-5*i
        if(temp%2==0):
            count += 1
            count+=i
            count+=temp//2
            break
    print(count)

