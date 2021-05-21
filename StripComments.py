def stripComments(string,markers):
    lines = string.split('\n')
    ans = ""
    for i in lines:
        found = False
        for t in markers:
            if (i.find(t) != -1):
                toAdd = i[:i.find(t)]
                found = True

        if found == False:
            toAdd = i

        if (toAdd[-1] == " "):
            toAdd = toAdd[:-1] 

        ans += toAdd + '\n'

    return ans[:-1]

print (stripComments("apples, pears # and bananas\ngrapes\nbananas !#apples", ["#", "!"]))