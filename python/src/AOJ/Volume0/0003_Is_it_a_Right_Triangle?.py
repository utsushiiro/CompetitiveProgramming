"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0003
"""


def is_right_triangle(sides):
    for i in range(3):
        if sides[i % 3] ** 2 + sides[(i + 1) % 3] ** 2 == sides[(i + 2) % 3] ** 2:
            return True
    return False


size = int(input())
for _ in range(size):
    sides = [int(n) for n in input().split()]
    if is_right_triangle(sides):
        print("YES")
    else:
        print("NO")
