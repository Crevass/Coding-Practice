import numpy as np
from linked_list import Node
from linked_list import display

def check_palindrome(l):
	assert l._item != None, 'Empty list'
	if l._next == None:
		return True
	pointer = l
	last = getLastNode(l)
	while True:
		if pointer._item != last._item:
			return False
		if pointer._next == last or pointer._next._next == last:
			return True
		pointer = pointer._next
		last = last._pre
	return True
		
def getLastNode(l):
	assert l._item != None, 'Empty list'
	while True:
		l = l._next
		if l._next == None:
			break
	return l

if __name__ == '__main__':
	l = Node()
	n = np.random.randint(1,10)
	print('N: %d' %n)
	if np.random.randint(0,2) > 0:
		if (n % 2) == 0:
			for i in range(n//2):
				l.append(i)
			for i in range(n//2):
				l.append(n//2 - i -1)
		else:
			for i in range((n//2) + 1):
				l.append(i)
			for i in range(n//2):
				l.append(n//2 - i -1)
	else:
		for i in range(n):
			l.append(np.random.randint(0,10))
	display(l)
	result = check_palindrome(l)
	print(result)
	