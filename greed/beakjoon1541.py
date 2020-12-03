import sys
def answer(nums):
    sums = []
    for num in nums:
        temp = list(map(int, num.split("+")))
        sums.append(sum(temp))

    total = sums[0]
    for i in range(1,len(sums)):
        total -= sums[i]
    return total

if __name__ == "__main__":
    nums = sys.stdin.readline().rstrip("\n").split("-")
    print(answer(nums))

