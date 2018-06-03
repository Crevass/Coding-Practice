import numpy as np
from singly_linked_list import Node
from singly_linked_list import display

def check_intersection(l1, l2):
	assert l1._item != None, 'list1 is empty'
	assert l2._item != None, 'list2 is empty'	
	
	while True:
		p2 = l2
		while True:
			if l1 == p2:
				return p2
			else:
				if p2._next == None:
					break
				else:
					p2 = p2._next
		if l1._next == None:
			break
		else:
			l1 = l1._next
	return 'No intersecting node'

if __name__ == '__main__':
	l1 = Node(np.random.randint(1, 10))
	l2 = Node(np.random.randint(1, 10))
	for i in range(np.random.randint(0, 3)):
		l1.append(np.random.randint(1, 10))
	for i in range(np.random.randint(0, 3)):
		l2.append(np.random.randint(1, 10))
	inter = Node(item=128)
	l1.append(inter)
	l2.append(inter)
	for i in range(3):
		l1.append(np.random.randint(1,10))
	for i in range(np.random.randint(0,5)):
		l2.append(np.random.randint(1,10))

	print('L1:')
	display(l1)
	print('L2:')
	display(l2)
	result = check_intersection(l1, l2)
	print(result)
	