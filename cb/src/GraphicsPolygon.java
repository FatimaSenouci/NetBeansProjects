
import cb.GraphicsShape;
import java.awt.Polygon;
import java.awt.image.BufferedImage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class GraphicsPolygon extends GraphicsShape {
    public GraphicsPolygon(int[] xpoints, int[] ypoints, int npoints) {
       // super(xpoints, ypoints, npoints);
    }

    public void drawToImage(BufferedImage image) {
        System.out.println("Drawing shape to image");
        for (int x=0; x<image.getHeight(); x++) {
            for (int y=0; y<image.getWidth(); y++) {
                if (contains(x, y)) {
                    image.setRGB(x, y, 0xff33b5e5);
                }
            }
        }
    }

    private boolean contains(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
