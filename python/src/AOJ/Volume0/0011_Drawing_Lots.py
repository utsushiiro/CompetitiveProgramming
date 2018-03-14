"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0011
"""

w = int(input())
n = int(input())
jumper = []
for _ in range(n):
    jumper.append(tuple(map(int, input().split(","))))

numbers = [i for i in range(1, w + 1)]

for i in range(len(jumper)):
    a, b = jumper[i]
    tmp = numbers[a - 1]
    numbers[a - 1] = numbers[b - 1]
    numbers[b - 1] = tmp

for number in numbers:
    print(number)
