import numpy as np
from singly_linked_list import Node
from singly_linked_list import display
import time
def loop_detection(l):
	assert l._item != None, 'empty list'
	assert l != None, 'empty list'
	node_list = []
	while True:
		if l._next == None:
			for i in node_list:
				if l == i:
					return l
			return False
		else:
			node_list.append(l)
			p = l._next
			l._next = None
			l = p
		
	return 'Error'

if __name__ == '__main__':
	l = Node(np.random.randint(1, 10))
	count = 1
	p = l
	node = l
	for i in range(2):
		l.append(np.random.randint(1, 10))
		p = p._next
		count += 1
	print('p should be', p)
	for i in range(2):
		l.append(np.random.randint(1, 10))
		count += 1
	if np.random.randint(0, 2) > 0:
		l.append(p)
		count += 1
		print('Should be True')
	print('total %d s nodes' %count)
	p = l
	for i in range(count):
		print(p, end='->')
		p = p._next
	print('')
	result = loop_detection(l)
	print(result)




