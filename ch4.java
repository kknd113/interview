import java.util.*;

public class ch4 {

	public static int checkHeight(BNode n) {
		if (n == null) { return 0; }
		int l = checkHeight(n.left);
		int r = checkHeight(n.right);
		if (l == -1 || r == -1) { return -1; }
		int diff = Math.abs(l-r);
		if (diff > 0 ) { return -1; }
		else {
			return l+1;
		}
	}

	public static boolean isBalanced(BTree t) {
		BNode r = t.root;
		if (checkHeight(r) == -1) { return false; }
		else { return true; }
	}

	public static BNode getBST(int[] arr, int a, int b) {
		if (a == b) { return new BNode(arr[a]); }
		else if ( a > b) { return null; }
		else {
			int len = arr.length;
			BNode n = new BNode(arr[(a+b)/2]);
			n.left = getBST(arr, a, ((a+b)/2)-1);
			n.right = getBST(arr, ((a+b)/2)+1, b);
			if (n.left != null) { n.left.parent = n; }
			if (n.right != null) { n.right.parent = n; }
			return n;
		}
	}

	public static boolean isBST(BNode n, int min, int max) {
		if (n == null) { return true; }
		if (n.item < min || n.item >= max) { return false; }
		else {
			return isBST(n.left, min, n.item) && isBST(n.right, n.item, max);
		}
	}

	public static BNode getNext(BNode n) {
		if (n.right != null) {
			n = n.right;
			while ( n.left != null) {
				n = n.left;
			}
			return n;
		} else {
			int i = n.item;
			while (n.parent != null && n.item <= i) {
				n = n.parent;
			}
			if (n.item > i) { return n; }
			else { return null; }
		}
	}

	public static BTree createBST() {
		BTree tree = new BTree(3);
		BNode r = tree.root;
		r.insertLeft(1);
		r.insertRight(4);
		BNode n = r.left;
		BNode nn = r.right;
		n.insertRight(2);
		nn.insertRight(5);
		return tree;
	}

	public static void createLinkedList(BNode r, ArrayList<LinkedList> lists, int level) {
		LinkedList<BNode> list = null;
		if ( r == null ) { return ;}
		if (lists.size() == level) {
			list = new LinkedList<BNode>();
			lists.add(list);
		} else {
			list = lists.get(level);
		}
		list.add(r);
		createLinkedList(r.left, lists, level+1);
		createLinkedList(r.right, lists, level+1);
	}

	public static void printLinkedList(LinkedList<BNode> list) {
		for (BNode n : list) {
			System.out.print(n.item + ", ");
		}
		System.out.println("");
	}

	public static BNode firstCC(BTree t, BNode p, BNode q) {
		while (p != null) {
			p.visited = true;
			p = p.parent;
		}

		while (q != null && !q.visited) {
			q = q.parent;
		}

		return q;
	}

	public static boolean covers(BNode r, BNode p) {
		if (r == null) { return false; }
		if (r == p) { return true; }
		else {
			return covers(r.left, p) || covers(r.right, p);
		}
	}

	public static BNode firstCC2(BNode r, BNode p, BNode q) {
		if (r == null || !covers(r,p) || !covers(r,q)) { return null; }
		if (r == p || r == q) { return r; }
		boolean pLeft = covers(r.left, p);
		boolean qLeft = covers(r.left, q);
		if (pLeft != qLeft) { return r; }
		else {
			if (pLeft) { return firstCC2(r.left, p, q); }
			return firstCC2(r.right, p, q);
		}
	}

	public static String preString(BNode r) {
		StringBuilder s = new StringBuilder();
		if (r == null) {
			return new String("-1, ");
		} else {
			s.append(r.item + ", ");
			s.append(preString(r.left));
			s.append(preString(r.right));
		}
		return new String(s);
	}

	public static boolean isSubtree(BTree t1, BTree t2) {
		String s1 = preString(t1.root);
		String s2 = preString(t2.root);
		return s1.indexOf(s2) != -1;
	}

	public static void main(String[] args) {
		System.out.println("Chapter 4 START!");
		BTree t = createBST();
		System.out.println(isBalanced(t));

		int[] a = {1,2,3,4,5};
		BNode n = getBST(a,0, 4);
		System.out.println(n.item);
		System.out.println(n.left.item);
		System.out.println(n.left.right.item);
		System.out.println(isBST(t.root, -999, 999));

		BNode s = t.root;
		//System.out.println(s.item);
		//System.out.println(s.left.right.parent.item);
		System.out.println(getNext(s.right).item);

		ArrayList<LinkedList> lists = new ArrayList<LinkedList>(0);
		createLinkedList(t.root, lists, 0);
		for (LinkedList list : lists) {
			printLinkedList(list);
		}

		System.out.println("\n\n\n");
		BTree tt = createBST();
		BNode r = new BNode(1);
		tt.root = r;
		r.insertLeft(2);
		r.insertRight(3);
		BNode l = r.left;
		BNode rrr = r.right;
		l.insertLeft(4);
		l.insertRight(5);
		rrr.insertLeft(6);
		rrr.insertRight(7);
		BNode  rr = rrr.right;
		rr.insertRight(8);
		rr.insertLeft(9);
		System.out.println(firstCC(tt, r.right.left, r.right.right).item);
		System.out.println(covers(rrr, r));
		System.out.println(firstCC2(tt.root, r.right.left, r.right.right).item);

		System.out.println("\n\n\n");
		System.out.println(preString(r));
		BTree ttt = new BTree();
		ttt.root = tt.root.left;
		System.out.println(isSubtree(tt, t));
	}
}