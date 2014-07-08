import sys
test_cases = open(sys.argv[1], 'r')

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

for test in test_cases:
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    # ...
    # ...
    test = test.replace("\n","")
    test = test.split(',')
    axl,axr,ayu,ayd = test[0],test[2],test[1],test[3]
    bxl,bxr,byu,byd = test[4],test[6],test[5],test[7]
    xinter = xintersects(axl,axr,bxl,bxr)
    yinter = yintersects(ayu,ayd,byu,byd)
    print (xinter and yinter)


test_cases.close()
