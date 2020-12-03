import sys

N = int(sys.stdin.readline().rstrip("\n"))
result = 1000 - N
count=0

count += result//500
result %= 500
count += result//100
result %= 100
count += result//50
result %= 50
count += result//10
result %= 10
count += result//5
result %= 5
count += result//1
result %= 1
print(count)

