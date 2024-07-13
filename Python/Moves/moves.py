import sys
from collections import deque

def solve(n,grid):
    frontier = deque()
    loc = (0,0)
    parent = {(0,0):None}
    distance = {(0,0):0}
    directions = {}
    frontier.append(loc)

    while(frontier):
        loc = frontier.pop()
        x,y = loc
        currentDistance = distance.get(loc)
        if loc==(n-1,n-1):
            return reconstruct(parent,directions,(n-1,n-1))
        neighbors = Neighbors(n,grid,x,y)
        for neighbor in neighbors:
            dir = neighbors.get(neighbor)
            if not distance.__contains__(neighbor):
                frontier.append(neighbor)
                distance[neighbor]=currentDistance+1
                parent[neighbor]=loc
                directions[neighbor]=dir
    return None

def reconstruct(parent,dir,end):
    path = []
    loc = end
    while not loc==None:
        if dir.__contains__(loc):
            path.append(dir[loc])
        loc = parent[loc]
    return path

def Neighbors(n,grid,x,y):
    res = {}

    neighbors = [
        (-1,-1),
        (-1, 0),
        (-1,+1),
        (0, -1),
        (0, +1),
        (+1,-1),
        (+1, 0),
        (+1,+1)
    ]

    directions = {
        neighbors[0]:"NW",
        neighbors[1]:"N",
        neighbors[2]:"NE",
        neighbors[3]:"W",
        neighbors[4]:"E",
        neighbors[5]:"SW",
        neighbors[6]:"S",
        neighbors[7]:"SE",
        }
    
    for neighbor in neighbors:
        xn = x + neighbor[0]
        yn = y + neighbor[1]
        if xn >= 0 and yn >= 0 and xn < n and yn < n and grid[xn][yn]<grid[x][y]:
            res[(xn,yn)] = directions[neighbor]
    return res


with open(sys.argv[1], 'r') as file:
    n = int(file.readline())
    grid = [list(map(int, line.split())) for line in file]

print('n =',n,'\n\nGrid:')
for row in grid:
    print('~  ',end='')
    for x in row:
        print(x,' ',end='')
    print()

print()

path = solve(n,grid)

if path == None:
    print("IMPOSSIBLE")
else:
    print(path)




