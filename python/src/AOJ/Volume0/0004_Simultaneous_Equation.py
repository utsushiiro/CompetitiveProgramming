"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0004
+ 0 for a minus zero
"""

while True:
    try:
        a, b, c, d, e, f = [int(n) for n in input().split()]
        x = round((c * e - b * f) / (a * e - b * d), 4) + 0
        y = round((-c * d + a * f) / (a * e - b * d), 4) + 0
        print("{x:.3f} {y:.3f}".format(x=x, y=y))
    except EOFError:
        break
