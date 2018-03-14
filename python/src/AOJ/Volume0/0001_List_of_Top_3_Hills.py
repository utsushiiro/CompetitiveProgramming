"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0001
"""

records = [int(input()) for i in range(10)]
records.sort()
for _ in range(3):
    print(records.pop())
