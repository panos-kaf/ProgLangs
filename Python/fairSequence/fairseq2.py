import sys

def best(dif, p , t):
    cur = abs(2*p-t)
    if cur < dif:
        return cur
    return dif

f = open(sys.argv[1])
n = int(f.readline())
seq = []
for num in f.readline().split():
    seq.append(int(num))

total = sum(seq)
dif = total
partial = 0
i = 0

for i in range(n):
    partial += seq[i]
    if 2*partial > total:
        break

dif = best(dif,partial,total)
if best(dif,partial-seq[i],total)<2:
    print('(1st try)',best(dif,partial-seq[i],total))

for j in range(0,n):
    partial -= seq[j]
    if partial

print(i)