def stairs(n)
	arr = [0,1,2,4]
	if n <= 3
		return arr[n]
	end

	for i in 4 .. n
		arr[i] = arr[i-1] + arr[i-2]*2 + arr[i-3]*4
	end
	arr[n]
end

def robots(x,y)
	arr = Array.new(x+1, Array.new(y+1,0))
	arr[0][0] = 0
	for i in 1 .. y
		arr[0][i] = 1
	end
	for i in 1 .. x
		arr[i][0] = 1
	end

	for i in 1 .. x
		for y in 1 .. y
			arr[x][y] = arr[x-1][y] + arr[x][y-1]
		end
	end
	arr[x][y]
end

def magic(arr, i, j)
	if i == j
		if arr[i] != i
			return nil
		else
			return i
		end
	end

	mid = (i+j)/2
	if arr[mid] == mid
		return mid
	end
	if arr[mid] < mid
		magic(arr, mid+1, j)
	else
		magic(arr, i, mid-1)
	end
end

def subsets(sets)
	if sets.size == 0
		return Array.new(0)
	elsif sets.size == 1
		return [[], sets]
	end
	old = subsets(sets - [sets[sets.size-1]])
	for i in old
		old += [i + [sets[sets.size-1]]]
	end
	return old
end

def perm(pre, str)
	if str.size == 0
		return [pre]
	else
		arr = []
		for i in str.split("")
			arr += perm(pre+i, (str.split("") - [i]).join())
		end
	end
	arr
end


def paran(str, l, r)
	if l==0 and r==0
		return [str]
	elsif r < l or r < 0 or l < 0
		return []
	else
		arr = []
		arr += paran(str + "(",l-1,r) + paran(str + ")", l, r-1)
	end
	return arr
end
			


			


			

m = [-3,-1,0,1,2,3,6,13]