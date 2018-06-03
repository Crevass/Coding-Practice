import numpy as np

class Node(object):
	def __init__(self, item, next_node=None, pre_node=None):
		self._item = item
		self._next = next_node
		self._pre = pre_node
	def append(self, item):
		if self._item == None:
			self._item = item
		else:
			head = self
			while head._next != None:
				head = head._next
			head._next = Node(item, pre_node=head)
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
			print(' <--> ', end='')
			pointer = pointer._next
	print('\n-----------------------')
	while pointer != None:
		print(pointer, end='')
		if pointer._pre == None:
			break
		else:
			print(' <--> ', end='')
			pointer = pointer._pre
	print('\nEnd')
	return True
if __name__ == '__main__':
	l = Node()
	for i in range(10):
		l.append(i)
	display(l)
