"""
http://judge.u-aizu.ac.jp/onlinejudge/description.jsp?id=0017
"""

while True:
    try:
        encrypted_words = input().split(" ")

        alphabets = [chr(i) for i in range(ord('a'), ord('z') + 1)]

        for shift_amount in range(0, 26):
            shifted_words = []
            for word in encrypted_words:
                chars = list(word)
                shifted_word = []
                for char in chars:
                    if ord('a') <= ord(char) <= ord('z'):
                        shifted_char_num = (ord(char) - ord('a') + shift_amount) % 26
                        shifted_word.append(chr(shifted_char_num + ord('a')))
                    else:
                        shifted_word.append(char)
                shifted_words.append("".join(shifted_word))

            if "the" in shifted_words or "this" in shifted_words or "that" in shifted_words:
                print(" ".join(shifted_words))
                break
    except EOFError:
        break
