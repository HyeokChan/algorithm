import sys

useDay, allDay, vacDay = map(int, sys.stdin.readline().split())
count=1
while(useDay!=0 and allDay!=0 and vacDay!=0):
    a = vacDay//allDay
    b = vacDay%allDay
    result = useDay * a
    if(b <= useDay):
        result+=b
    else:
        result += useDay
    print("Case %d: %d"%(count,result))
    count+=1
    useDay, allDay, vacDay = map(int, sys.stdin.readline().split())