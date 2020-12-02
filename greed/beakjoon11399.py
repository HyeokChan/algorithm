import sys
def answer(times):
    sum = 0
    total = 0
    times = sorted(times)
    for time in times:
        sum += time
        total += sum
    return total



if __name__ == "__main__":
    N = int(sys.stdin.readline())
    times = list(map(int,sys.stdin.readline().split()))
    print(answer(times))

