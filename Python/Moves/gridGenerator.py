import sys

n = int(sys.argv[1])

grid = [[3*n for _ in range(n)] for _ in range(n)]

for i in range(n):
    grid[0][i] = 4*n-i
    grid[i][n-1-i] = 3*n-i+1
    grid[n-1][i] = 2*n - i

with open(sys.argv[2],'w') as f:
    print(n,file=f)
    for row in grid:
        for elem in row:
            print(elem,' ',file=f,end='')
        print('',file=f)