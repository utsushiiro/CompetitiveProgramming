"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0019
"""


def factorial(num):
    if num < 2:
        return 1
    else:
        return num * factorial(num - 1)


n = int(input())
print(factorial(n))
