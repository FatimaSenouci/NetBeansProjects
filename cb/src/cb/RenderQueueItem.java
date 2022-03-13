/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cb;

import java.awt.Point;
import java.awt.Polygon;

/**
 *
 * @author hp
 */
public class RenderQueueItem {
     public final Polygon polygon;
    public final double depth;

    public RenderQueueItem(double depth, Point... points) {
        int[] xpoints = new int[points.length];
        int[] ypoints = new int[points.length];
        for (int i=0; i<points.length; i++) {
            xpoints[i] = points[i].x;
            ypoints[i] = points[i].y;
        }
        this.polygon = new Polygon(xpoints, ypoints, points.length);
        this.depth = depth;
    }
    
}
