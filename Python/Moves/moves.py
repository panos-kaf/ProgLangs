import sys

with open(sys.argv[1], 'r') as file:
    n = int(file.readline())
    grid = [list(map(int, line.split())) for line in file]

print('n =',n,'\n\nGrid:')
for row in grid:
    print('~  ',end='')
    for x in row:
        print(x,' ',end='')
    print()



