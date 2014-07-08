import sys
test_cases = open(sys.argv[1], 'r')
<<<<<<< HEAD

def xintersects(a1,a2,b1,b2):
    if a1 < b1:
        return a2 >= b1
    else:
        return b2 >= a1

def yintersects(a1,a2,b1,b2):
    if a1 > b1:
        return a2 <= b1
    else:
        return b2 <= a1

=======
>>>>>>> be8bcc40059f8a373248d58ba931c70cf774d9e8
for test in test_cases:
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    # ...
    # ...
<<<<<<< HEAD
    test = test.replace("\n","")
    test = test.split(',')
    axl,axr,ayu,ayd = test[0],test[2],test[1],test[3]
    bxl,bxr,byu,byd = test[4],test[6],test[5],test[7]
    xinter = xintersects(axl,axr,bxl,bxr)
    yinter = yintersects(ayu,ayd,byu,byd)
    print (xinter and yinter)


=======
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
>>>>>>> be8bcc40059f8a373248d58ba931c70cf774d9e8
test_cases.close()
