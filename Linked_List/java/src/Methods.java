import java.util.*;

public class Methods {
	
	public int lengthOfList(Node n) {
		int counter = 0;
		while (n != null) {
			counter++;
			n = n.next;
		}
		return counter;
	}

	public void deleteDups(Node n) {
		Node current = n;
		while (current != null) {
			Node runner = current;
			while (runner.next != null) {
				if (runner.next.data == current.data) {
					runner.next = runner.next.next;
				} else {
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}

	public void deleteDups2(Node n) {
		HashSet<Integer> set = new HashSet<Integer>();
		Node pre = null;
		while (n != null) {
			if (set.contains(n.data)) {
				pre.next = n.next;
			} else {
				set.add(n.data);
				pre = n;
			}
			n = n.next;
		}
	}

	public int returnKtoLast1(Node n, int k) {
		if (n == null) {
			return 0;
		} else {
			int i = returnKtoLast1(n.next, k) + 1;
			if (i == k) {
				System.out.println(n.data);
			}
			return i;
		}
	}

	public Node returnKtoLast2(Node n, int k) {
		Node current = n;
		Node runner = n;
		int counter = 0;
		while (counter < k) {
			runner = runner.next;
			counter++;
			if (runner == null) {
				System.out.println("Out of range.");
				return null;
			}
		}
		while(runner != null) {
			runner = runner.next;
			current = current.next;
		}
		return current;
	}

	public boolean deleteMiddleNode(Node n) {
		if (n == null){
			return false;
		}
		n.data = n.next.data;
		n.next = n.next.next;
		return true;
	}

	public Node partition(Node n, int p) {
		 Node righthead = null;
		 Node rigthtail = null;
		 Node lefthead = null;
		 Node lefttail = null;
		 Node current = null;
		 while (n != null) {
		 	current = n;
		 	n = n.next;
		 	current.next = null;
		 	if (current.data < p) {
		 		if (righthead == null && rigthtail == null) {
		 			righthead = current;
		 			rigthtail = current;
		 		} else {
		 			current.next = righthead;
		 			righthead = current;
		 		}
		 	} else {
		 		if (lefthead == null && lefttail == null) {
		 			lefttail = current;
		 			lefthead = current;
		 		} else {
		 			lefttail.next = current;
		 			lefttail = current;
		 		}
		 	}
		 }
		 if (rigthtail == null) {
		 	return lefthead;
		 } else {
		 	rigthtail.next = lefthead;
		 	return righthead;
		 }
	}

	public Node sumList(Node n1, Node n2, int carry) {
		if (n1 == null && n2 == null) {
			if (carry == 0) {
				return null;
			} else {
				return new Node(carry);
			}
		} else if (n1 == null) {
			carry = (int)((carry + n2.data) / 10);
			Node current = new Node((carry + n2.data) % 10);
			current.next = sumList(n1, n2.next, carry);
			return current;
		} else if (n2 == null) {
			carry = (int)((carry + n1.data) / 10);
			Node current = new Node((carry + n1.data) % 10);
			current.next = sumList(n1.next, n2, carry);
			return current;
		} else {
			carry = (int)((carry + n1.data + n2.data) / 10);
			Node current = new Node((carry + n1.data + n2.data) % 10);
			current.next = sumList(n1.next, n2.next, carry);
			return current;
		}
	}

	class Carries {
		public Node node;
		public int carry;
		public Carries(Node n, int c) {
			node = n;
			carry = c;
		}
	}

	public Node padList(Node n, int num) {
		if (num == 0) {
			return n;
		}
		Node head = null;
		for (int i = 0; i < num; i++) {
			head = new Node(0);
			head.next = n;
			n = head;
		}
		return head;
	}

	Carries addList(Node n1, Node n2) {
		if (n1.next == null && n2.next == null) {
			return new Carries(new Node((n1.data + n2.data)%10), (int)((n1.data + n2.data) / 10));
		} else {
			Carries nextCarry = addList(n1.next, n2.next);
			Carries current = new Carries(new Node((n1.data + n2.data + nextCarry.carry)%10), (int)((n1.data + n2.data + nextCarry.carry) / 10));
			current.node.next = nextCarry.node;
			return current;
		}
	}

	public Node sumList2(Node n1, Node n2) {
		int len1 = lengthOfList(n1);
		int len2 = lengthOfList(n2);
		if (len1 > len2) {
			n2 = padList(n2, len1-len2);
		} else {
			n1 = padList(n1, len2-len1);
		}
		Carries current = addList(n1, n2);
		if (current.carry != 0){
			Node result = new Node(current.carry);
			result.next = current.node;
			return result;
		} else {
			return current.node;
		}
	}

	public boolean palindrome(Node n) {
		Node fast = n;
		Node slow = n;
		Stack<Integer> stack = new Stack<Integer>();
		while (fast != null && fast.next != null) {
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		if (fast != null) {
			slow = slow.next;
		}
		while (slow != null) {
			if (slow.data != stack.pop().intValue()) {
				return false;
			} else {
				slow = slow.next;
			}
		}
		return true;
	} 

	class resultOfRecursive {
		boolean flag;
		Node backward;
		public resultOfRecursive(boolean f, Node b) {
			this.flag = f;
			this.backward = b;
		}
	}

	public resultOfRecursive recursiveOfPalindrome(Node n, int len) {
		if (len == 0) {
			return new resultOfRecursive(true, n);
		} else if (len == 1) {
			return new resultOfRecursive(true, n.next);
		}
		resultOfRecursive next = recursiveOfPalindrome(n.next, len - 2);
		if (next.flag == false) {
			return new resultOfRecursive(false, next.backward.next);
		} else {
			return new resultOfRecursive(next.backward.data == n.data, next.backward.next);
		}
	}

	public boolean palindrome2(Node n, int len) {
		if (n == null) {
			return false;
		}
		resultOfRecursive result = recursiveOfPalindrome(n, len);
		return result.flag;
	}

	public Node intersection(Node n1, Node n2) {
		Node runner1 = n1;
		Node runner2 = n2;
		int counter1 = 1;
		int counter2 = 1;
		while (runner1.next != null) {
			counter1++;
			runner1 = runner1.next;
		}
		while (runner2.next != null) {
			counter2++;
			runner2 = runner2.next;
		}
		if (runner2 != runner1) {
			return null;
		}

		if (counter1 > counter2) {
			for (int i = 0; i < counter1 - counter2; i++) {
				n1 = n1.next;
			}
			return findIntersection(n1, n2);
		} else {
			for (int i = 0; i < counter2 - counter1; i++) {
				n2 = n2.next;
			}
			return findIntersection(n1, n2);
		}
	}

	Node findIntersection(Node n1, Node n2) {
		while(n1 != n2 && n1 != null && n2 != null) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	public Node loopDetection(Node n) {
		Node fast = n;
		Node slow = n;
		int count = 0;
		while (true) {
			if (fast.next == null || fast.next.next == null) {
				return null;
			}
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}
		while (n != slow) {
			n = n.next;
			slow = slow.next;
		}
		return slow;
	}
}