"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0016
"""
import math

x = 0
y = 0
theta = 90

while True:
    d, a = list(map(int, input().split(",")))
    if (d, a) == (0, 0):
        break
    x += d * math.cos(theta * math.pi / 180)
    y += d * math.sin(theta * math.pi / 180)
    theta -= a

print(int(x), int(y), sep='\n')
