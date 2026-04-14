import java.util.List;
import java.util.ArrayList;
import java.math.*;

/**
 * Represents a graph structure for image segmentation.
 * This class manages pixels, edges, and regions for graph-based image processing,
 * typically used in algorithms like graph cuts for segmentation.
 */
public class Graph{
	/** The 2D array representing the image pixels */
	private Pixel[][] image;
	/** List of edges connecting adjacent pixels */
	private List<Edge> edges;
	/** List of regions or segments in the image */
	private List<Region> segments;
	/** Width of the image */
	int width;
	/** Height of the image */
	int height;
	
	/**
	 * Constructs a new Graph with the given image grid.
	 * Initializes the graph with the provided pixel grid and dimensions,
	 * and creates empty lists for edges and segments.
	 * @param gridImage the 2D array of pixels representing the image
	 * @param width the width of the image
	 * @param height the height of the image
	 */
	public Graph(Pixel[][] gridImage,int width, int height){
		this.width = width;
		this.height = height;
		image = gridImage;
		
		segments = new ArrayList<> ();
		edges = new ArrayList<>();
	}
	
	/**
	 * Creates initial segments by assigning each pixel to its own region.
	 * This method initializes the segmentation process where each pixel
	 * starts as its own individual segment.
	 */
	public void createSegments() {
		for(int i = 0; i< width; i++) {
			for(int j = 0; j<height; j++) {
				Region segment = new Region();
				segment.addPixel(image[i][j]);
				segments.add(segment);
			}
		}
	}
	
	/**
	 * Creates edges between adjacent pixels (right and down neighbors).
	 * For each pixel, edges are created to the pixel to its right and below it,
	 * with weights calculated based on the difference between the pixels.
	 */
	public void createEdges() {
		for(int y = 0; y< height; y++) {
			for(int x = 0; x<width; x++) {
				int id1 = image[y][x].getID();
				
				//Add right node
		        if (x < width - 1) {
		            int id2 = image[x+1][y].getID();
		            double w = diff(image[x][y], image[x+1][y]);
		            Edge edge = new Edge(id1, id2);
		            edge.setWeight(w);
		            edges.add(edge);
		        }
		        
		        //Add down node
		        if(y< height - 1) {
		        	int id2 = image[x][y+1].getID();
		            double w = diff(image[x][y], image[x][y+1]);
		            Edge edge = new Edge(id1, id2);
		            edge.setWeight(w);
		            edges.add(edge);
		        }
				
			}
		}
		
	}
	
	/**
	 * Calculates the Euclidean distance between two pixels based on their
	 * coordinates and RGB color values. This distance is used as the weight
	 * for edges connecting the pixels.
	 * @param p1 the first pixel
	 * @param p2 the second pixel
	 * @return the Euclidean distance between the two pixels
	 */
	private double diff(Pixel p1, Pixel p2) {
		int p1_x = p1.getCoordinate()[0];
		int p2_x = p2.getCoordinate()[0];
		int p1_y = p1.getCoordinate()[1];
		int p2_y = p2.getCoordinate()[1];
		int[] p1_RGB = p1.getRGB();
		int[] p2_RGB = p2.getRGB();
		
		double diff = Math.sqrt((p1_x - p2_x)^2 + 
								(p1_y - p2_y)^2 +
								(p1_RGB[0] - p2_RGB[0])^2 +
								(p1_RGB[1] - p2_RGB[1])^2 +
								(p1_RGB[2] - p2_RGB[2])^2);
		return diff;
	}
}