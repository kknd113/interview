import sys
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    # ...
    # ...
    test = test.replace("\n", "")
    arr = test.split(" ")
    l = eval(arr[0])
    d = eval(arr[1])
    n = eval(arr[2])

    arr2 = map(lambda x : eval(x), arr[3:])
    arr2.sort()
    a = [6] + arr2 + [l-6]
    print arr2
    count = 0
    i = 0
    while i < len(arr2) - 1:
        a,b = arr2[i], arr2[i+1]
        count += ( (b-a) / d )- 1
        i += 2
    if n > 0:
        a,b = 6, arr2[0]
        if a < b:
            count += 1
            count += ( (b-a) / d ) - 1
    if n > 0:
        a,b = arr2[n-1], l-6
        if a < b:
            count += 1
            count += ( (b-a) / d ) - 1
    print count
test_cases.close()
