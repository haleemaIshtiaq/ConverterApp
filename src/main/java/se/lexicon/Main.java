package se.lexicon;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Temperature  converter
    static final double FAHRENHEIT_FACTOR = 9.0/5.0;
    static final double FAHRENHEIT_OFFSET = 32.0;



    static void main() {
      String answer;
      //do-while used for continue until user enter no
      do {
          int choice = menu();
          switch (choice) {
              case 1 -> {
                  IO.println("--- Temperature Converter ---");
                  IO.println("Convert:\n" +
                          "  1. Celsius to Fahrenheit\n" +
                          "  2. Fahrenheit to Celsius");
                  int subChioce = Integer.parseInt(IO.readln("Your choice: "));
                  if (subChioce == 1) {
                      double celsius = Double.parseDouble(IO.readln("Enter temperature in Celsius: "));
                      double result = temperatureConverter(celsius, subChioce);
                      IO.println("Result: " + celsius + " C = " + String.format("%.2f", result) + " F");
                  } else {
                      double fahrenheit = Double.parseDouble(IO.readln("Enter temperature in fahrenheit: "));
                      double result = temperatureConverter(fahrenheit, subChioce);
                      IO.println("Result: " + fahrenheit + " C = " + String.format("%.2f", result) + " F");
                  }


              }


              case 2 -> {
                  IO.println("--- Currency Converter ---");
                  IO.println("Convert:\n" +
                          "  1. SEK to USD\n" +
                          "  2. SEK to EUR");
                  int subChioce2 = Integer.parseInt(IO.readln("Your choice: "));
                  double amount = Double.parseDouble(IO.readln("Enter amount in SEK: "));
                  if (subChioce2 == 1) {

                      double result2 = currencyConverter(amount, subChioce2);
                      IO.println("Result: " + amount + " SEK = " + String.format("%.2f", result2) + " USD");
                  } else {

                      double result2 = currencyConverter(amount, subChioce2);
                      IO.println("Result: " + amount + " SEK = " + String.format("%.2f", result2) + " EUR");
                  }


              }


              case 3 -> {
                  IO.println("--- BMI Calculator ---");
                  double weight =Double.parseDouble( IO.readln("Enter weight in kg: "));
                  double height = Double.parseDouble(IO.readln("Enter height in meters: "));
                  double bmi = BMICalculator(weight,height);
                  String bmiStatus;
                  if(bmi < 18.5){
                      bmiStatus = "Underweight";
                  }
                  else if ( bmi< 25){
                      bmiStatus = "Normal weight";
                  }
                  else if ( bmi< 30){
                      bmiStatus = "Overweight";
                  }
                  else{
                      bmiStatus = "Obese";
                  }

                  IO.println("BMI: " + String.format("%.2f", bmi) + " ->   "  +bmiStatus);


              }



              case 4 -> {
                  IO.println("Goodbye!");
                  return;
              }
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
        int choice = Integer.parseInt(IO.readln("Choose an option: "));
        return choice;
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
            return  amount / 10.87;

        }
        else{
            return  amount / 11.32;
        }

    }

    //BMI calculator
    public static double BMICalculator(double weight, double height){
       return  weight / Math.pow(height, 2);
    }
}
