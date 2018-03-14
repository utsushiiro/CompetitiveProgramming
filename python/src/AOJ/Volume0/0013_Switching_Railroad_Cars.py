"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0013
"""

stack = []
while True:
    try:
        n = int(input())
        if n == 0:
            print(stack.pop())
        else:
            stack.append(n)
    except EOFError:
        break
