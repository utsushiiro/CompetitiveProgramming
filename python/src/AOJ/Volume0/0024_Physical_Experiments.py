"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0024
"""
import math

while True:
    try:
        v = float(input())
        t = v / 9.8
        y = 4.9 * (t ** 2)
        N = (y + 5) / 5
        N = math.ceil(N)
        print(N)
    except EOFError:
        break
