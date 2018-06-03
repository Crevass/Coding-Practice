import numpy as np

class Node(object):
	def __init__(self, item, next_note=None):
		self._item = item
		self._next = next_note
	def append(self, item):
		head = self
		while head._next != None:
			head = head._next
		head._next = item if isinstance(item, Node) else Node(item)
	def __repr__(self):
		return str(self._item)

def display(node):
	assert node != None, 'Empty list!'
	pointer = node
	while pointer != None:
		print(pointer, end='')
		if pointer._next == None:
			break
		else:
			print(' -> ', end='')
			pointer = pointer._next
	print('\nEnd')
	return True

if __name__ == '__main__':
	l = Node()
	node1 = Node(1)
	print(l)
	print(node1)
	l.append(node1)
	print(l)

		
	
