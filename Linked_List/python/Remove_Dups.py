import numpy as np
from linked_list import Node
from linked_list import display

def remove_dups(l):
	assert l._item != None, 'Empty linked list'
	while l != None:
		runner = l
		while runner._next != None:
			if l._item == runner._next._item:
				runner._next = runner._next._next
				if runner._next != None:
					runner._next._pre = runner
			else:
				runner = runner._next
		l = l._next
	return True

def remove_dups_2(l):
	assert l != None, 'Empty list'
	appeared = [l._item]
	while l._next != None:
		if l._next._item in appeared:
			l._next = l._next._next
			if l._next != None:
				l._next._pre = l
		else:
			appeared.append(l._next._item)
			l = l._next
	return True	



if __name__ == '__main__':
	l = Node(np.random.randint(1, 10))
	for i in range(np.random.randint(5,10)):
		l.append(np.random.randint(1, 10))
	print('Before removal')
	display(l)
	remove_dups_2(l)
	print('After:')
	display(l)

