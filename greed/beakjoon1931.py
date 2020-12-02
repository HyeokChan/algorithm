
def count(meeting):
    mCount = 0
    startTime = 0
    for time in meeting:
        if(time[0]>=startTime):
            startTime = time[1]
            mCount = mCount+1
    return mCount


if __name__ == "__main__":
    N = int(input())
    meeting = [ list(map(int,input().split())) for _ in range(0,N) ]
    meeting = sorted(meeting, key=lambda x: x[0])
    meeting = sorted(meeting, key=lambda x: x[1])
    print(count(meeting))
