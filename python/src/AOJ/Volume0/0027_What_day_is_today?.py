"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0027
"""

import datetime

weekday_string = [
    "Monday",
    "Tuesday",
    "Wednesday",
    "Thursday",
    "Friday",
    "Saturday",
    "Sunday"
]

while True:
    m, d = [int(n) for n in input().split()]
    if (m, d) == (0, 0):
        break

    dt = datetime.date(2004, m, d)
    print(weekday_string[dt.weekday()])
