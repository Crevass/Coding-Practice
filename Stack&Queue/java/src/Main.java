public class Main {
	public static void main(String[] args) {
		AnimalShelter shelter = new AnimalShelter();
		System.out.println(shelter.isEmpty());
		for (int i = 0; i < 8 + Math.random() * 10; i++) {
			if (Math.random() > 0.5) {
				shelter.add(1);
				System.out.print("1->");
			} else {
				shelter.add(0);
				System.out.print("0->");
			}
		}
		System.out.print("\n");
		System.out.println("size of shelter " + shelter.num);
		System.out.println("Remove: ");
		System.out.println(shelter.removeDog());
		System.out.println("After removement");

		while (!shelter.isEmpty()) {
			System.out.print(shelter.remove() + "->\0");
		}
	}
}