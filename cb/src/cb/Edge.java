/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cb;

/**
 *
 * @author hp
 */
public class Edge {
     public final Vector[] points;

    public Edge(Vector v1, Vector v2) {
        points = new Vector[]{v1, v2};
    }
    
}
