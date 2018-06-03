import java.lang.reflect.*;

public class ThreeInOneStack<T> {
	private T[] myArray;
	@SuppressWarnings("unchecked")
	private int pointer1 = 0;
	private int pointer2 = 1;
	private int pointer3 = 2;
	private int size;
	public ThreeInOneStack(Class<T> type, int s) {
		myArray = (T[])Array.newInstance(type, s);
		size = s;
	}
	public boolean push1(T data) {
		if (pointer1 >= size) return false;
		if (myArray[pointer1] == null) {
			myArray[pointer1] = data;
		} else {
			pointer1 += 3;
			myArray[pointer1] = data;
		}
		return true;
	}

	public boolean push2(T data) {
		if (pointer2 >= size) return false;
		if (myArray[pointer2] == null) {
			myArray[pointer2] = data;
		} else {
			pointer2 += 3;
			myArray[pointer2] = data;
		}
		return true;
	}

	public boolean push3(T data) {
		if (pointer3 >= size) return false;
		if (myArray[pointer3] == null) {
			myArray[pointer3] = data;
		} else {
			pointer3 += 3;
			myArray[pointer3] = data;
		}
		return true;
	}

	public T peek(int n) {
		switch (n) {
			case 1:
				return myArray[pointer1];
			
			case 2:
				return myArray[pointer2];
	
			case 3:
				return myArray[pointer3];
	
			default:
				return null;
		}
	}

	public T pop1() {
		if (pointer1 < 0) return null;
		T t = myArray[pointer1];
		pointer1 -= 3;
		return t;
	}
	public T pop2() {
		if (pointer2 < 1) return null;
		T t = myArray[pointer2];
		pointer2 -= 3;
		return t;
	}
	public T pop3() {
		if (pointer3 < 2) return null;
		T t = myArray[pointer3];
		pointer3 -= 3;
		return t;
	}
}