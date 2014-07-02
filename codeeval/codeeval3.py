import sys
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    # ...
    # ...
    count=0;
    amt = eval(test)
    while amt > 0 :
        if amt >= 5:
            amt -= 5
        elif amt >= 3:
            amt -=3
        else:
            amt -= 1
        count += 1
    print count

test_cases.close()
