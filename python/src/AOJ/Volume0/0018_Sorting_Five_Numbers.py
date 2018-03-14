"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0018
"""

nums = [int(n) for n in input().split(" ")]
length = len(nums)

for i in range(0, length):
    max_index = i
    for j in range(i, length):
        if nums[max_index] < nums[j]:
            max_index = j
    tmp = nums[max_index]
    nums[max_index] = nums[i]
    nums[i] = tmp

print(" ".join(map(str, nums)))
