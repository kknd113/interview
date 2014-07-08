import java.util.*;

public class BNode {
	int item;
	BNode left;
	BNode right;
	BNode parent;
	boolean visited;
	BNode(int item) {
		this.item = item;
		this.left = null;
		this.right = null;
		this.parent = null;
		this.visited = false;
	}

	BNode (int item, BNode parent) {
		this.item = item;
		this.parent = parent;
	}

	public void insertLeft(int item) {
		BNode n = new BNode(item);
		n.parent = this;
		this.left = n;
	}

	public void insertRight(int item) {
		BNode n = new BNode(item);
		n.parent = this;
		this.right = n;
	}

	public int getHeight() {
		if (this.left == null && this.right == null) { return 0; }
		int l = this.left == null? 0 : left.getHeight();
		int r = this.right == null? 0 : right.getHeight();
		return Math.max(l,r) + 1;
	}
}