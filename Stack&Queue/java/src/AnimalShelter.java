public class AnimalShelter {

	public int num;
	public AnimalShelter() {
		num = 0;
	}

	private class Node {
		int kind;
		public Node(int s) {
			kind =s;
		}
		Node next;
		Node pre;
		public boolean isCat() {
			return this.kind == 0;
		}
	}
	private Node oldestDog;
	private Node oldestCat;
	private Node oldest;
	private Node newest;

	public boolean add(int s) {
		Node n = new Node(s);
		if (isEmpty()) {
			oldest = n;
			newest = n;
		} else {
			newest.next = n;
			n.pre = newest;
			newest = n;
		}
		if (n.isCat() && oldestCat == null) oldestCat = n;
		if (!n.isCat() && oldestDog == null) oldestDog = n;
		this.num++;
		return true;
	}

	public int remove() {
		if (isEmpty()) throw new EmptyStackException();
		int data = oldest.kind;
		oldest = oldest.next;
		this.num--;
		if (!isEmpty()) {
			oldest.pre = null;
			if (oldest.isCat()) oldestCat = updateCat(oldest);
			else oldestDog = updateDog(oldest);
		} else {
			newest = null;
			oldestCat = null;
			oldestDog = null;
		}
		return data;
	}

	public int removeDog() {
		if (isEmpty()) throw new EmptyStackException();
		if (oldestDog == null) throw new NoSuchElementException();
		if (oldest == oldestDog) return remove();
		int data = oldestDog.kind;
		join(oldestDog);
		oldestDog = updateDog(oldestDog.next);
		this.num--;
		return data;
	}

	private boolean join(Node n) {
		if (n == null) throw new NoSuchElementException();
		if (n.pre != null) n.pre.next = n.next;
		if (n.next != null) n.next.pre = n.pre;
		return true;
	}

	public int removeCat() {
		if (isEmpty()) throw new EmptyStackException();
		if (oldestCat == null) throw new NoSuchElementException();
		if (oldest == oldestCat) return remove();
		int data = oldestCat.kind;
		join(oldestCat);
		oldestCat = updateCat(oldestCat.next);
		num--;
		return data;
	}

	public boolean isEmpty() {
		return this.num == 0;
	}

	private Node updateCat(Node n) {
		while (n != null) {
			if (n.kind == 0) break;
			n = n.next;
		}
		return n;
	}

	private Node updateDog(Node n) {
		while(n != null) {
			if (n.kind == 1) break;
			n = n.next;
		}
		return n;
	}
}