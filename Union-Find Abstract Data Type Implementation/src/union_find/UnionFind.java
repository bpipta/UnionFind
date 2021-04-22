package union_find;

public interface UnionFind<E> {
	public void makeSet(E n);
	public void union(E n, E v);
	public E find(E n);

}
