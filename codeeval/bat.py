import sys
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    # ...
    # ...
    test = test.replace("\n","")
    arr = test.split(" ")
    arr = map(lambda x: eval(x), arr)
    l,d,n = arr[0], arr[1], arr[2]
    arr2 = arr[3:]
    arr2 = arr2.sort()
    a = [6] + arr2 + [l-6]

    if a[1] - a[0] < d:
    	a[0] = 0
    else:
    	count+=1
    if l-6-arr2[len(arr2)-1] < d:
    	a[len(a)-1] = l
    else:
    	count += 1

    
test_cases.close()
