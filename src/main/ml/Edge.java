/**
 * Represents an edge in a graph structure.
 * <p>
 * An edge connects two nodes (s1 and s2) and has an associated weight,
 */
public class Edge implements Comparable<Edge>{
    int s1, s2;
    int s2;
    double weight;

    /**
     * Constructs a new Edge.
     *
     * @param s1 the first vertex
     * @param s2 the second vertex
     * @param weight the weight of the edge
     */
    public Edge(int s1, int s2) {
        this.s1 = s1;
        this.s2 = s2;
        this.weight = 0.0; // Default weight, can be updated later
    }

    /**
     * Updates the weight of this edge.
     *
     * @param weight the new weight value
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Returns the current weight of this edge.
     *
     * @return the weight of the edge
     */
    public double getWeight() {
        return this.weight;
    }

    public int[] getVertices() {
        return new int[]{this.s1, this.s2};
    }

    /**
     * Compares this edge to another based on their weights for sorting purposes.
     * @param other the edge to compare to
     * @return a negative integer, zero, or a positive integer as this edge's weight
     *         is less than, equal to, or greater than the specified edge's weight
     */
    @Overrides
    public int compareTo(Edge other) {
        return Double.compare(this.weight, other.weight);
    }
}