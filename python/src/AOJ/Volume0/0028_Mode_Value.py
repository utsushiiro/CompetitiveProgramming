"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0028
"""

counts = [0 for _ in range(101)]

while True:
    try:
        i = int(input())
        counts[i] += 1
    except EOFError:
        break

max_count = max(counts)
for i, count in enumerate(counts):
    if count == max_count:
        print(i)
