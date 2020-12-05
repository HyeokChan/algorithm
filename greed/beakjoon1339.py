import sys

inputNums = int(sys.stdin.readline().rstrip("\n"))
nums = []
dic = {}
calNum = 9
answer=0
for i in range(0,26):
    dic[chr(i+65)] = 0

for i in range(0,inputNums):
    nums.append(sys.stdin.readline().rstrip("\n"))
    powNum = 1
    for j in range(len((nums[i]))-1,-1,-1):
        dic[nums[i][j]] += powNum
        powNum *= 10

numLists = list(dic.values())
numLists = sorted(numLists,reverse=True)
for numList in numLists:
    answer += numList * calNum
    calNum -= 1

print(answer)



