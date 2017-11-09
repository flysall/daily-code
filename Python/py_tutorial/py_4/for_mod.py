words = ['cat', 'window', 'defenestrate']
for w in words[:]:
    if len(w) > 1:
        words.insert(0,w)
    print(w)
print(words)
