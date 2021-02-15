/**
 * Created by JasonWynkoop on 9/24/17.
 */

package edu.ipfw.simulations;

public class Throttle {

    private int top;                //The topmost position of the lever
    private int position;           //The current position of the lever

    public Throttle(int size){
        if(size <= 0){
            throw new IllegalArgumentException("Size <= 0: " + size);
        }
        top = size;
        //No assignment needed for position -- it is the default value of zero.
    }

    public double getFlow(){
        return (double) position/(double) top;
    }

    public boolean isOn(){
        return (getFlow() > 0);
    }

    public void shutOff(){
        position = 0;
    }

    public void shift(int amount){

        if(amount > top - position){
            //adding amount would put the position above the top.
            position = top;
        }else if(position + amount < 0){
            //adding amount would pet the position below zero.
            position = 0;
        }else {
            //adding amount puts position in the range [o...top].
            position += amount;
        }
    }
}
