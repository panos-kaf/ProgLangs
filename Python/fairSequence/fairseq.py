import sys

def findBest(i, partial):
    if i == n: 
        return abs(2*partial - total)
    
    if (i, partial) in bestFound: 
        return bestFound[(i, partial)]

    bestFound[(i,partial)] = min(findBest(i+1, partial),findBest(i+1, partial+seq[i]))
    return bestFound[(i,partial)]

seq = []
with open(sys.argv[1]) as f:
    n = int(f.readline())
    for num in f.readline().split():
        seq.append(int(num))

total = sum(seq)
bestFound = {}
print(findBest(0,0))