package datastructures;

/**
 * A basic Union-Find (disjoint set) data structure.
 *
 * <p>This class supports efficient find and union operations for grouping
 * elements into disjoint sets. It uses union by size to minimize tree height
 * and is useful for tracking connected components in graph algorithms and
 * segmentation tasks.</p>
 */
public class UnionFind {
	private int[] parents;
	private int[] size;

	/**
	 * Creates a UnionFind structure with {@code n} singleton sets.
	 *
	 * @param n the number of elements
	 */
	public UnionFind(int n) {
		parents = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parents[i] = i;
			size[i] = 1;
		}
	}
	
	/**
	 * Finds the representative/root of the set containing {@code s}.
	 *
	 * @param s the element whose set root is requested
	 * @return the root representative of {@code s}
	 */
	public int find(int s) {
		if (parents[s] == s) {
			return s;
		}
		return find(parents[s]);
	}
	
	/**
	 * Unites the sets containing {@code s1} and {@code s2}.
	 *
	 * <p>Uses union by size: the smaller set is attached to the larger set
	 * to keep trees balanced.</p>
	 *
	 * @param s1 the first element
	 * @param s2 the second element
	 */
	public void union(int s1, int s2) {
		int a = find(s1);
		int b = find(s2);
		if (a != b) {
			if (size[a] > size[b]) {
				parents[b] = a;
				size[a] += size[b];
			} else {
				parents[a] = b;
				size[b] += size[a];
			}
		}
	}
}
