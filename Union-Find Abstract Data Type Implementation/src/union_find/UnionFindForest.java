package union_find;

import java.util.TreeMap;

public class UnionFindForest<E> implements UnionFind<E>{
	
	private class Node {
		private E value;
		private Node parent;
		private int rank;
		
		public Node(E n) {
			this.value = n;
			this.parent = null;
			this.rank = 0;
		}
	}
	
	private TreeMap<E, Node> tree;
	
	public UnionFindForest() {
		tree = new TreeMap<>();
	}
	
	public void union(E n, E v) {
		Node node1 = tree.get(find(n));
		Node node2 = tree.get(find(v));
		
		if(node1 == node2) {
			return;
		} 
		if(node1.rank == node2.rank) {
			node2.parent = node1;
			node1.rank++;
			
		} else if (node1.rank > node2.rank) {
			node2.parent = node1;
			node1.rank++;
			
		} else {
			node1.parent = node2;
			node2.rank++;
		}
	}
	
	public void makeSet(E n) {
		if(!tree.containsKey(n)) {
			Node newNode = new Node(n);
			newNode.parent = newNode;
			tree.put(n, newNode);
		}
	}
	
	private Node findHelper(Node n) {
		if(n.parent == n) {
			return n;
		}
		n.parent = findHelper(n.parent);
		return n.parent;
	}
	
	public E find(E n) {
		if(!tree.containsKey(n)) {
			throw new IllegalStateException("Key does not exist");
		}
		E value = findHelper(tree.get(n)).value;
		return value;
	}
	
}
