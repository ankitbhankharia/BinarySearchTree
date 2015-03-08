
public class Node {
	Node left;
	Node right;
	
	int key;
	String name;
	
	Node(int key, String name) {
		this.key = key;
		this.name = name;
	}
	
	public String toString() {
		return name + " for the key " + key;
	}
}
