package edu.ipfw.geometry;

/**
 * Created by JasonWynkoop on 9/25/17.
 */
public class Location implements Cloneable{

    private double x;               //The x coordinate of the Location
    private double y;               //The y coordinate of the Location

    public Location(double xInitial, double yInitial){
        x = xInitial;
        y = yInitial;
    }

    public Location clone(){
        //Clone a new Location
        Location answer;

        try {
            answer = (Location) super.clone();
        } catch (CloneNotSupportedException e){
            //The exception should not occur.  But if it does, it would indicate a programming
            //error that made super.clone unavailable.  The most common cause would be
            //forgetting the "implements Cloneable" clause at the start of the Class.
            throw new RuntimeException("This class does not implement Cloneable");
        }
        return answer;
    }

    public static double distance(Location p1, Location p2){
        double a, b, c_squared;

        //Check whether one of the Locations is null.
        if(p1 == null || p2 == null){
            return Double.NaN;
        }

        //Calculate the differences in x and y coordinates
        a = p1.x - p2.x;
        b = p1.y - p2.y;

        //Use Pythagorean Theorem to calculate the square of the distance
        //between the Locations
        c_squared = a*a + b*b;

        return Math.sqrt(c_squared);
    }

    public boolean equals(Object obj){
        if(obj instanceof Location){
            Location candidate = (Location) obj;
            return (candidate.x == x) && (candidate.y == y);
        }else{
            return false;
        }
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public static Location midpoint(Location p1, Location p2){
        double xMid, yMid;

        //Check whether one of the Locations is null.
        if((p1 == null) || (p2 == null)){
            return null;
        }

        //Compute the x and y midpoints
        xMid = (p1.x/2) + (p2.x/2);
        yMid = (p1.y/2) + (p2.y/2);

        //Create a new Location and return it.
        Location answer = new Location(yMid, xMid);
        return answer;
    }

    public void rotate90(){
        double xNew;
        double yNew;

        //For a 90-degree clockwise rotation, the x is the original y,
        //and the new y is -1 times the original x.
        xNew = y;
        yNew = -x;
        x = xNew;
        y = yNew;
    }

    public void shift(double xAmount, double yAmount){
        x += xAmount;
        y += yAmount;
    }

    public String toString(){
        return "(x=" + x + "  y=" + y + ")";
    }
}

