"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0029
"""
from collections import defaultdict

words = input().split(" ")
w2c = defaultdict(int)

max_num_of_letters = 0
longest_word = None
for word in words:
    w2c[word] += 1
    if len(word) > max_num_of_letters:
        max_num_of_letters = len(word)
        longest_word = word

sorted_w2c = sorted(w2c.items(), key=lambda x: x[1])
print(sorted_w2c[-1][0], longest_word)
