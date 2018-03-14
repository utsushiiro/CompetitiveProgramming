"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0008
"""


def resolve(num, depth):
    if depth > 3:
        return 0

    count = 0
    for x in range(0, 10):
        diff = num - x
        if diff == 0:
            count += 1
            break
        elif diff < 0:
            break
        else:
            count += resolve(diff, depth + 1)

    return count


while True:
    try:
        n = int(input())
        print(resolve(n, 0))
    except EOFError:
        break
