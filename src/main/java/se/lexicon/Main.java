package se.lexicon;

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



    static void main() {
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
                  int subChoice = Integer.parseInt(IO.readln("Your choice: "));
                  if (subChoice == 1) {
                      double celsius = Double.parseDouble(IO.readln("Enter temperature in Celsius: "));
                      double result = temperatureConverter(celsius, subChoice);
                      IO.println("Result: " + celsius + " C = " + String.format("%.2f", result) + " F");
                  } else {
                      double fahrenheit = Double.parseDouble(IO.readln("Enter temperature in Fahrenheit: "));
                      double result = temperatureConverter(fahrenheit, subChoice);
                      IO.println("Result: " + fahrenheit + " C = " + String.format("%.2f", result) + " F");
                  }


              }

              //CURRENCY CONVERTER
              case 2 -> {
                  IO.println("--- Currency Converter ---");
                  IO.println("""
                              Convert:
                                1. SEK to USD
                                2. SEK to EUR""");
                  int subChoice2 = Integer.parseInt(IO.readln("Your choice: "));
                  double amount = Double.parseDouble(IO.readln("Enter amount in SEK: "));
                  if (subChoice2 == 1) {

                      double result2 = currencyConverter(amount, subChoice2);
                      IO.println("Result: " + amount + " SEK = " + String.format("%.2f", result2) + " USD");
                  } else {

                      double result2 = currencyConverter(amount, subChoice2);
                      IO.println("Result: " + amount + " SEK = " + String.format("%.2f", result2) + " EUR");
                  }


              }


              //BMI CALCULATOR
              case 3 -> {
                  IO.println("--- BMI Calculator ---");
                  double weight =Double.parseDouble( IO.readln("Enter weight in kg: "));
                  double height = Double.parseDouble(IO.readln("Enter height in meters: "));
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
              }


              //EXIT
              case 4 -> {
                  IO.println("Goodbye!");
                  return;
              }

              //INVALID CHOICE
              default -> IO.println("Invalid choice!");

          }

          answer = IO.readln("Continue? (yes/no): ");
      }while(answer.equalsIgnoreCase("yes"));

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
        return Integer.parseInt(IO.readln("Choose an option: "));

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
}
