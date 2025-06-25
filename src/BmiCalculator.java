import java.util.Scanner;
import java.util.Locale;

public class BmiCalculator {


        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            scanner.useLocale(Locale.US);

            char repeat = 0;

            do {

                //ALL OUR CODE
                int unitChoice =getUnitChoice(scanner);

                double weight = (unitChoice == 1)? getValidInput(scanner, "Enter your weight in kilograms: ",10, 600, 5)
                        :getValidInput(scanner, "Enter your weight in pounds", 22, 1300, 5);

                double height = (unitChoice == 1) ? getValidInput(scanner, "Enter your height in meters: ",0.5, 2,5)
                        :getValidInput(scanner, "Enter your weight in inches", 20 , 100, 5);

                double bmi = calculateBMI(unitChoice ,weight, height);
                System.out.println("Your BMI is " + bmi);

                //repeat =askToRepeat(scanner);
                System.out.println();
                

            }while (repeat == 'y' || repeat == 'Y');

        }

        //Unit - Metric and Imperial
        public static int getUnitChoice(Scanner scanner) {
            int choice;

            while(true) {
                System.out.printf("Select a preffered unit:\n"
                        + "1. Metric (kg,m)\n"
                        + "2. Imperial (lbs,in)\n"
                        + "Please select either option 1 or option 2");

                if(scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if(choice == 1 || choice == 2) {
                        break;
                    }else {
                        System.out.println("Invalid choice. Please select either 1 or 2");
                    }
                }else {
                    System.out.println("Invalid input.Please enter a number(1 or 2");
                    scanner.next();
                }
            }


            return choice;
        }

        public static double getValidInput(Scanner scanner, String prompt, double min, double max, int i) {
            double value;

            while(true) {
                System.out.println(prompt);

                if(scanner.hasNextDouble()) {
                    value = scanner.nextDouble();
                    if (value >= min && value <= max) {
                        break;
                    }else {
                        System.out.printf("Please enter a value between %.1f and %.1f.\n", min, max);
                    }
                } else {
                    System.out.println("Invalid input.Please enter a value");
                    scanner.next();
                }
            }

            return value;

        }

        public static double calculateBMI(int unitChoice,double weight, double height) {
            double totalBMI;

            if (unitChoice == 1) {
                totalBMI = weight / (height * height);
            } else {
                totalBMI = (703 * weight) / (height / height);
            }
            return totalBMI;
        }

    }
