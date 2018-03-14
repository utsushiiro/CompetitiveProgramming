"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0002
"""


def get_digit_number(n):
    if n // 10 > 0:
        return get_digit_number(n // 10) + 1
    else:
        return 1


while True:
    try:
        a, b = [int(n) for n in input().split()]
        print(get_digit_number(a + b))
    except EOFError:
        break
