"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0029
"""

from collections import Counter

words = input().split()
counts = Counter(words)

max_num_of_letters = 0
longest_word = None
for word in words:
    l = len(word)
    if l > max_num_of_letters:
        max_num_of_letters = l
        longest_word = word

print(counts.most_common()[0][0], longest_word)
