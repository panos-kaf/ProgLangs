import sys

def findBest(best, p, t):
    current = abs(2*p - t)
    if best > current:
        best = current
    return best

f = open(sys.argv[1])
n = int(f.readline())
seq = []
for num in f.readline().split():
    seq.append(int(num))

total = sum(seq)
best = total
j=0
new_j = 0
partial = 0

for i in range(n):
    if best<2:
        break
    for j in range(new_j,n):
        partial += seq[j] 
        if 2*partial > total : 
            temp = findBest(best,partial,total)
            if temp<best :
                best = temp
                new_j = j+1
            temp = findBest(best,partial-seq[j],total)
            if temp<best :
                new_j = j
                partial -= seq[j]
            break
    partial -= seq[i]

print(best)