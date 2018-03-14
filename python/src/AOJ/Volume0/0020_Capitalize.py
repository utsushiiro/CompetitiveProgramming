"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0020
"""

text = list(input())
capitalized_text = []

for char in text:
    if ord('a') <= ord(char) <= ord('z'):
        capitalized_text.append(chr(ord(char) - ord('a') + ord('A')))
    else:
        capitalized_text.append(char)

print("".join(capitalized_text))
