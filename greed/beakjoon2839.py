import sys
def answer(N):
    for i in range(0,1001):
        for j in range(0,1001):
            if(5*j+3*i == N):
                count = i+j
                return count
    return -1


if __name__ == "__main__":
    N = int(sys.stdin.readline().rstrip("\n"))
    print(answer(N))

