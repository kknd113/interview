import sys
test_cases = open(sys.argv[1], 'r')
for test in test_cases:
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    # ...
    # ...
    result = ""
    arr = test.split(" ")
    i=0
    while i < len(arr):
    	flag = arr[i]
    	seq = arr[i+1]
    	i = i+2
    	if flag == "00":
    		result += seq.replace("0", "1")
    	else:
    		result += seq
    print int(result, 2)

test_cases.close()
