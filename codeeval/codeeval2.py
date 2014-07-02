import sys
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    # ...
    # ...
    base = {'I':1, 'V':5, 'X':10, 'L':50, 'C':100, 'D':500, 'M':1000}
    result = 0
    i = 0
    while i < len(test)-1:
        s = eval(test[i]) * base[test[i+1]]
        if len(test)-3 > i and base[test[i+1]] < base[test[i+3]]:
            result = result - s
        else:
            result = result + s
        i = i +2
    print result
test_cases.close()