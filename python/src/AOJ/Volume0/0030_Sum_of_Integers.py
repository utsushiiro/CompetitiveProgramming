"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0030
"""


def resolve(start, depth, cum, limit):
    if depth > limit:
        return 0

    count = 0
    for num in range(start, 10):
        tmp_cum = cum - num
        if tmp_cum == 0:
            if depth == limit:
                count += 1
            else:
                break
        elif tmp_cum > 0:
            count += resolve(num + 1, depth + 1, tmp_cum, limit)
        else:
            break

    return count


while True:
    n, s = [int(i) for i in input().split(" ")]
    if (n, s) == (0, 0):
        break
    c = resolve(0, 1, s, n)
    print(c)
