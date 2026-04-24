package image_segmentation;
import java.util.ArrayList;

public class SuperPixel{
	private int root;
    private double[] meanRGB;
    private int size;
    private double internalDiff;
    private ArrayList<Pixel> pixels;

    public SuperPixel(Pixel root){
        this.meanRGB = new double[]{0, 0, 0};
        this.pixels = new ArrayList<>();
        this.pixels.add(root);
        this.size++;
        this.root = root.getID();
    }

    public void addPixel(Pixel p){
        this.pixels.add(p);
        this.size++;

        // Update mean RGB values
        for(int i = 0; i < 3; i++){
            meanRGB[i] = (meanRGB[i] + p.getRGB()[i]) / 2;
        }
    }
    
    public void addPixels(ArrayList<Pixel> newPixels) {
    	for(Pixel p: newPixels) {
    		pixels.add(p);
    		size++;
    	}
    }
    
    public double[] getMeanRGB() {
    	return meanRGB;
    }
    
    public double internalDiff(ArrayList<Edge> edges) {
    	//look for the first appearance of the first pixel in this segment
    	//because the edges are sorted by weight
    	
    	for(Edge e: edges) {
    		int[] vertices = e.getVertices();
    		if(pixels.get(0).getID() == vertices[0] || pixels.get(0).getID() == vertices[1]) {
    			internalDiff = e.getWeight();
    		}
    	}
    	return internalDiff;
    }
    
    public int size() {
    	return this.size;
    }
    
    public double getInternalDiff() {
    	return this.internalDiff;
    }
    
    public Pixel rootPixel() {
    	return pixels.get(0);
    }
    
    public ArrayList<Pixel> getPixels(){
    	return this.pixels;
    }
    
    public boolean find(int s) {
    	for(Pixel p: pixels) {
    		if(s == p.getID()) return true;
    	}
    	return false;
    }
    
    public void setRoot(int s) {
    	this.root = s;
    }
    
    public int getRoot() {
    	return this.root;
    }
}