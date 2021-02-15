package edu.ipfw.simulations;


/**
 * Created by JasonWynkoop on 9/24/17.
 */
public class Assertions {

    public static void main(String[] args){
        System.out.println(maxOf3(12, 65, 1000));
    }


    public static int maxOf3(int a, int b, int c){
        int answer;

        //Set answer to the largest of a, b, and c
        answer = a;                 //initially set answer to a
        if(b > answer){             //maybe change the answer to b
            answer = b;
        }
        if(c > answer){             //maybe change the answer to c
            answer = c;
        }

        //Check that the computation did what we expected
        assert (answer == a) || (answer == b) || (answer == c)
                : "maxOf3 anser is not equal to one of the arguments";
        assert (answer >= a) && (answer >= b) && (answer >= c)
                : "maxOf3 answer is not equal to the largest argument";

        return answer;
    }

    //Methods like this can be implemented for more complex checking
    static boolean contains(int[] a, int value){
        int i;

        for(i = 0; i < a.length; i++){
            if(a[i] == value) {
                return true;
            }
        }

        return false;
    }

    static boolean greaterOfEqual(int[] a, int value){
        int i;

        for(i = 0; i < a.length; i++){
            if(a[i] > value){
                return false;
            }
        }

        //The loop finished without finding an array element that exceeds the value,
        //so we can return true;
        return true;
    }

    public static int maxOfArray(int[] a){
        int answer;
        int i;

        //Set answer to the largest value in the Array.
        answer = a[0];              //Initially set answer to the first element
        for(i = 0; i < a.length; i++){
            answer = a[i];
        }

        //Check that the computation did what we expected
        assert contains(a, answer)
                : "maxOfArray answer is not equal in the array";
        assert greaterOfEqual(a, answer)
                : "macOfArray answer is less than an array element";
        return answer;
    }

}
