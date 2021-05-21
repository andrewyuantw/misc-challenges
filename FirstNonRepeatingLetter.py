def first_non_repeating_letter(string):
    counter = 1
    for i in string:
        if string.lower().find(str(i).lower()) == string.lower().rfind(str(i).lower()):
            return i
        counter += 1
    return ""

print (first_non_repeating_letter("chraaihyaa"))