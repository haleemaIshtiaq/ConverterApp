package se.lexicon;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    //Temperature  converter
    static final double FAHRENHEIT_FACTOR = 9.0/5.0;
    static final double FAHRENHEIT_OFFSET = 32.0;

    //Currency converter
    static final double USD_RATE = 10.87;
    static final double EUR_RATE = 11.32;

    //BMI calculator
    static final double UNDERWEIGHT_LIMIT= 18.5;
    static final double NORMAL_LIMIT= 25.0;
    static final double OVERWEIGHT_LIMIT= 30.0;

    //validation
    static final double MIN_CELSIUS= -273.15;
    static final double MIN_FAHRENHEIT= -459.67;




    static void main() {
        //Create an empty list
        ArrayList<String>  history = new ArrayList<>();
      String answer;

      //do-while used for continue until user enter no
      do {
          int choice = menu();
          switch (choice) {

              //TEMPERATURE CONVERTER
              case 1 -> {
                  IO.println("--- Temperature Converter ---");
                  IO.println("""
                          Convert:
                            1. Celsius to Fahrenheit
                            2. Fahrenheit to Celsius""");
                  //int subChoice = Integer.parseInt(IO.readln("Your choice: "));

                  //Taking number from user and check also if it is not a number
                  int subChoice = readInt("Your choice: ");

                  //Checking if user enter other than 1 or 2
                  while(subChoice != 1 && subChoice != 2){
                      IO.println("Invalid input. please enter 1 or 2");
                      subChoice = readInt("Your choice: ");
                  }

                  //Checking either it is 1 or 2
                  if (subChoice == 1) {
                      //Taking value and checking for number
                      double celsius = readDouble("Enter temperature in Celsius: ");

                      //Checking temperature if it is below absolute zero
                      while(celsius < MIN_CELSIUS){
                          IO.println("Invalid value. Temperature cannot be below absolute zero (-273.15 C).");
                          celsius = readDouble("Enter temperature in Celsius: ");
                      }

                      double result = temperatureConverter(celsius, subChoice);
                      IO.println("Result: " + celsius + " C = " + String.format("%.2f", result) + " F");

                      //Store result in history session
                      history.add(String.format("%.2f C = %.2f F",celsius,result));

                  }
                  else  {
                      //Taking value and checking for number
                      double fahrenheit = readDouble("Enter temperature in Fahrenheit: ");

                      //Checking temperature if it is below absolute zero
                      while(fahrenheit < MIN_FAHRENHEIT){
                          IO.println("Invalid value. Temperature cannot be below (-459.67 F).");
                          fahrenheit = readDouble("Enter temperature in Fahrenheit: ");

                      }

                      double result = temperatureConverter(fahrenheit, subChoice);
                      IO.println("Result: " + fahrenheit + " C = " + String.format("%.2f", result) + " F");

                      //Store result in history session
                      history.add(String.format("%.2f C = %.2f F",fahrenheit,result));
                  }



              }

              //CURRENCY CONVERTER
              case 2 -> {
                  IO.println("--- Currency Converter ---");
                  IO.println("""
                              Convert:
                                1. SEK to USD
                                2. SEK to EUR""");

                  //Taking number from user and check also if it is not a number
                  int subChoice2 = readInt("Your choice: ");

                  //Checking if user enter other than 1 or 2
                  while(subChoice2 != 1 && subChoice2 != 2){
                      IO.println("Invalid input. please enter 1 or 2");
                      subChoice2 = readInt("Your choice: ");
                  }

                  //Taking value in SEK and checking if it is a number
                  double amount = readDouble("Enter amount in SEK: ");

                  //Amount should be positive or 0
                  while(amount < 0){
                      IO.println("Invalid amount. Please enter zero or a positive number.");
                      amount = readDouble("Enter amount in SEK: ");
                  }

                  if (subChoice2 == 1) {

                      double result2 = currencyConverter(amount, subChoice2);
                      IO.println("Result: " + amount + " SEK = " + String.format("%.2f", result2) + " USD");

                      //Store result in history session
                      history.add(String.format("%.2f SEK = %.2f USD",amount,result2));
                  } else {

                      double result2 = currencyConverter(amount, subChoice2);
                      IO.println("Result: " + amount + " SEK = " + String.format("%.2f", result2) + " EUR");

                      //Store result in history session
                      history.add(String.format("%.2f SEK = %.2f EUR",amount,result2));
                  }


              }


              //BMI CALCULATOR
              case 3 -> {
                  IO.println("--- BMI Calculator ---");

                  //Taking value and checking for number
                  double weight = readDouble("Enter weight in kg: ");

                  //Checking for invalid input eg 0 oe less than 0
                  while(weight<=0){
                      IO.println("Invalid weight! Please enter a value greater than zero");
                      weight = readDouble("Enter weight in kg: ");
                  }

                  //Taking value and checking for number
                  double height = readDouble("Enter height in meters: ");

                  //Checking for invalid input eg 0 oe less than 0
                  while(height<=0){
                      IO.println("Invalid height! Please enter a value greater than zero");
                      height = readDouble("Enter height in meters: ");
                  }

                  double bmi = BMICalculator(weight,height);
                  String bmiStatus;
                  if(bmi < UNDERWEIGHT_LIMIT){
                      bmiStatus = "Underweight";
                  }
                  else if ( bmi< NORMAL_LIMIT){
                      bmiStatus = "Normal weight";
                  }
                  else if ( bmi< OVERWEIGHT_LIMIT){
                      bmiStatus = "Overweight";
                  }
                  else{
                      bmiStatus = "Obese";
                  }

                  IO.println("BMI: " + String.format("%.2f", bmi) + " ->   "  +bmiStatus);

                  //Store BMI and weight category in session history
                  history.add(String.format("BMI: %.2f -> %s"  , bmi, bmiStatus));
              }


              //EXIT
              case 4 -> {
                  answer = "no";
              }

              //INVALID CHOICE
              default -> IO.println("Invalid choice!");

          }
          //don't ask for continue if user wants to exit
          if(choice == 4){
              break;
          }
          answer = IO.readln("Continue? (yes/no): ");

          //Ask the user again to enter if user enter other than yes or no
          while(!answer.equalsIgnoreCase("yes")&& !answer.equalsIgnoreCase("no")){
              IO.println("Invalid input! please enter yes or no");
              answer = IO.readln("Continue? (yes/no): ");

          }

      }while(answer.equalsIgnoreCase("yes"));

      IO.println();  //For one line gap
      //Displaying whole history
      IO.println("=== Conversion History ===");
      int count = 1;
      for(String record : history){
          IO.println(count + ". " +record);
          count++;
      }
      IO.println("==========================");
      IO.println("Total conversions: " +history.size());

      IO.println("Goodbye!");

    }

    //Main menu method
    public static int menu() {
        //Converter App
        IO.println("==============================");
        IO.println("    LEXICON CONVERTER APP     ");
        IO.println("============================= ");
        IO.println("1. Temperature Converter");
        IO.println("2. Currency Converter");
        IO.println("3. BMI Calculator");
        IO.println("4. Exit");
        IO.println("==============================");

            return readInt("Choose an option: ");


    }


    //Method to convert temperatures
    public static double temperatureConverter(double value, int subChoice){
        if(subChoice==1) {
            return value * FAHRENHEIT_FACTOR + FAHRENHEIT_OFFSET;
        }
        else{
            return  (value - FAHRENHEIT_OFFSET) /FAHRENHEIT_FACTOR;
        }
    }


    //Method to convert currency
    public static double currencyConverter(double amount, int subChoice2){
        if(subChoice2==1) {
            return  amount / USD_RATE;
        }
        else{
            return  amount / EUR_RATE;
        }

    }
    //BMI calculator
    public static double BMICalculator(double weight, double height){
       return  weight / Math.pow(height, 2);
    }


    //Validation for int
    public static int readInt(String prompt){
        while(true){
            try{
                int number = Integer.parseInt(IO.readln(prompt));
                return number;
            } catch (NumberFormatException e){

                IO.println("Invalid input.Please enter a number.");
            }

        }
    }

    //Validation for double
    public static double readDouble(String prompt){
        while(true){
            try{
                double number = Double.parseDouble(IO.readln(prompt));

                //Checking for finite number(no Infinity and NaN accepted)
                if (Double.isFinite(number)) {
                    return number;
                }
                else{
                    IO.println("Invalid input! Please enter a finite number");
                }

            } catch (NumberFormatException e){

                IO.println("Invalid input.Please enter a number.");
            }

        }
    }
}


