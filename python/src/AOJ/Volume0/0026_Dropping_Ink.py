"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0026
"""

grid = [[0 for i in range(10)] for j in range(10)]


def drop_small(x, y):
    grid[x][y] += 1
    if x + 1 <= 9:
        grid[x + 1][y] += 1
    if x - 1 >= 0:
        grid[x - 1][y] += 1
    if y + 1 <= 9:
        grid[x][y + 1] += 1
    if y - 1 >= 0:
        grid[x][y - 1] += 1


def drop_medium(x, y):
    drop_small(x, y)
    if x + 1 <= 9 and y + 1 <= 9:
        grid[x + 1][y + 1] += 1
    if x + 1 <= 9 and y - 1 >= 0:
        grid[x + 1][y - 1] += 1
    if x - 1 >= 0 and y + 1 <= 9:
        grid[x - 1][y + 1] += 1
    if x - 1 >= 0 and y - 1 >= 0:
        grid[x - 1][y - 1] += 1


def drop_large(x, y):
    drop_medium(x, y)
    if x + 2 <= 9:
        grid[x + 2][y] += 1
    if x - 2 >= 0:
        grid[x - 2][y] += 1
    if y + 2 <= 9:
        grid[x][y + 2] += 1
    if y - 2 >= 0:
        grid[x][y - 2] += 1


while True:
    try:
        x, y, s = [int(n) for n in input().split(",")]

        if s == 1:
            drop_small(x, y)
        elif s == 2:
            drop_medium(x, y)
        elif s == 3:
            drop_large(x, y)
    except EOFError:
        break

max_density = 0
white_count = 0
for i in range(10):
    for j in range(10):
        density = grid[i][j]
        if density == 0:
            white_count += 1
        if density > max_density:
            max_density = density

print(white_count)
print(max_density)
