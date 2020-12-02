N, K = map(int,input().split())
N_list = []
count = 0
share = 0
for i in range(0,N):
    N_list.append(int(input()))

while(K!=0):
    share = K//N_list[N-1]
    if(share>=1):
        K = K - share * N_list[N-1]
        count = count + share
    else:
        N = N -1

print(count)