"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0025
"""

while True:
    try:
        imagined_nums = [int(_) for _ in input().split()]
        chose_nums = [int(_) for _ in input().split()]
        hit = 0
        blow = 0

        for i, chose_num in enumerate(chose_nums):
            for j, imagined_num in enumerate(imagined_nums):
                if chose_num == imagined_num:
                    if i == j:
                        hit += 1
                    else:
                        blow += 1
        print(hit, blow, sep=" ")
    except EOFError:
        break
