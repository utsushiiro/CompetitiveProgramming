"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0022
"""

n = int(input())
while n != 0:
    current_sum = int(input())
    max_sum = current_sum

    for _ in range(n - 1):
        a = int(input())

        if current_sum >= 0:
            current_sum += a
        else:
            current_sum = a

        if current_sum > max_sum:
            max_sum = current_sum

    print(max_sum)

    n = int(input())
