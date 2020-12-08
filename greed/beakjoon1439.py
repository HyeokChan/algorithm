import sys
strings = sys.stdin.readline().rstrip("\n")
zero = 0
one = 0
state = strings[0]
for i in range(1,len(strings)):
    if state == strings[i]:
        continue
    elif state != strings[i] and state == "0":
        zero +=1
        state = strings[i]
    elif state != strings[i] and state == "1":
        one +=1
        state = strings[i]
if strings[len(strings)-1] == "0":
    zero += 1
elif strings[len(strings)-1] == "1":
    one += 1

print(min(zero, one))



