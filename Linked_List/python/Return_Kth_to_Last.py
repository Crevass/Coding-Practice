import numpy as np
from singly_linked_list import Node
from singly_linked_list import display

def return_k_to_last(n,k):
	assert n != None, 'Empty list'
	elements = []
	while n != None:
		elements.append(n._item)
		n = n._next
	if len(elements) < k:
		return 'Not enough elements'
	else:
		return elements[len(elements) - k]

def return_k_to_last_2(n, k):
	assert n != None, 'Empty list'
	length = 0
	runner = n
	while runner != None:
		length += 1
		runner = runner._next
	if length < k:
		return 'List is not long enough'
	else:
		for i in range(length - k):
			n = n._next
		return n

def return_k_to_last_3(n, k):
	assert n != None, 'Empty list'
	distance = 0
	runner = n
	while runner != None:
		if distance >= k:
			runner = runner._next
			n = n._next
		else:
			runner = runner._next
			distance += 1
	if distance < k:
		return 'List is no long enough'
	else:
		return n
	

	
if __name__ == '__main__':
	l = Node(np.random.randint(1,10))
	for i in range(np.random.randint(7,10)):
		l.append(np.random.randint(1,10))
	k = np.random.randint(1, 12)
	display(l)
	print('From %dth to last' %k)
	result = return_k_to_last_3(l, k)
	print(result)
	