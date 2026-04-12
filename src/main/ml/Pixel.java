/**
 * Represents a single pixel in an image or grid.
 * <p>
 * A pixel is defined by its x and y position, an integer color value,
 * and a red-green-blue component array.
 */
public class Pixel {
    private int x;
    private int y;
    private int[] RGB;

    /**
     * Constructs a new Pixel.
     *
     * @param x the x coordinate of the pixel
     * @param y the y coordinate of the pixel
     * @param rgb the RGB component array for this pixel
     */
    public Pixel(int x, int y, int[] rgb) {
        this.x = x;
        this.y = y;
        this.RGB = rgb;
    }

    /**
     * Updates the RGB component array for this pixel.
     *
     * @param rgb the new RGB component array
     */
    public void setRGB(int[] rgb) {
        this.RGB = rgb;
    }

    /**
     * Updates the pixel coordinates.
     *
     * @param x the new x coordinate
     * @param y the new y coordinate
     */
    public void setCoodinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the current pixel coordinates.
     *
     * @return an array containing {x, y}
     */
    public int[] getCoordinate() {
        return new int[]{this.x, this.y};
    }

    /**
     * Returns the RGB component array for this pixel.
     *
     * @return the RGB values stored for this pixel
     */
    public int[] getRBG() {
        return this.RGB;
    }
}

