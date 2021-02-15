package edu.ipfw.simulations;
public class TemperatureConversion {

    public static void main(String[] args) throws IllegalAccessException {

        //Declare values that control the table's bounds.
        final double TABLE_BEGIN = -50; //The tables first celsius temp.
        final double TABLE_END = 50.0;  //The tables final celsius temp.
        final double TABLE_STEP = 10.0; //Increment between temps in table.

        double celsius;                 //A celsius temp
        double fahrenheit;              //the equivalent Fahrenheit temp

        System.out.println("TEMPERATURE CONVERSION");
        System.out.println("----------------------");
        System.out.println("Celsius     Fahrenheit");
        for (celsius = TABLE_BEGIN; celsius <= TABLE_END; celsius += TABLE_STEP) {
            //The for loop has set celsius to the next celsius temp of the table.
            fahrenheit = celsiusToFahrenheit(celsius);
            System.out.printf("%6.2fC", celsius);
            System.out.printf("%14.2fF\n", fahrenheit);
        }

        System.out.println("----------------------");
    }



    public static double celsiusToFahrenheit(double c) throws IllegalAccessException {
        final double MINIMUM_CELSIUS = -273.15;
        if (c < MINIMUM_CELSIUS) {
            throw new IllegalAccessException("Argument " + c + " is too small.");
        }

        return (9.0 / 5.0) * c + 32;
    }

}

