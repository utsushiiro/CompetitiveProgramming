"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0006
"""

chars = list(input())
length = len(chars)

for i in range(length // 2):
    tmp = chars[i]
    chars[i] = chars[length - 1 - i]
    chars[length - 1 - i] = tmp

print("".join(chars))
