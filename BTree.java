public class BTree {
	BNode root;
	int size;

	BTree () {
		this.root = null;
		this.size = 0;
	}

	BTree (int item) {
		this.root = new BNode(item);
		this.size = 1;
	}
}