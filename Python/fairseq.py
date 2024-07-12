import sys

f = open(sys.argv[1])
n = int(f.readline())
seq = []
for num in f.readline().split():
 seq.append(int(num))


