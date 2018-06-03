import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Node n1 = new Node(0);
		Node n2 = new Node((int)(3 + Math.random() * 10));
		Node runner1 = n1;
		Node startOfLoop = runner1;
		Methods method = new Methods();
		for (int i = 1; i < (int)(Math.random() * 8); i++) {
			n1.append((int)(Math.random() * 10));
			runner1 = runner1.next;
			startOfLoop = runner1;
		}
		for (int i = 1; i < 7; i++) {
			n1.append((int)(Math.random() * 10));
			runner1 = runner1.next;
		}
		for (int i = 1; i < (2 + (int)(Math.random() * 2)); i++) {
			n2.append((int)(Math.random() * 10));
		}
		System.out.print("List 1 is : ");
		n1.display(n1);
		runner1.next = startOfLoop;
		System.out.println("start point is: " + startOfLoop.data);
		Node result = method.loopDetection(n1);
		System.out.println(result.data);
	}
}