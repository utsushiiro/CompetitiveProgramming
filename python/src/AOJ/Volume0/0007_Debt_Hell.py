"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0007
"""
import math

price = 100000
interest = 0.05

weeks = int(input())
for _ in range(weeks):
    price += price * interest
    price = math.ceil(price / 1000) * 1000

print(price)
