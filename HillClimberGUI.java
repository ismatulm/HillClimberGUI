
/*
 Prashant Uprety
 Iterative Hill Climber GUI 
 */

import java.util.Scanner;
import javax.swing.*;

public class HillClimberGUI {

    public static void main(String[] args) {
        HillClimberGUI obj = new HillClimberGUI();

        obj.calculatioMethod();
    }
    /*
     *Miminize f(v) = f(x1, x2, x3) = x1^2 + x2^2 + x3^2 for -10 <= x1, x2, x3 <= +15.
     *That is, find the vector v = {x1, x2, x3} such that f(v) is the minimum in the given range.
     *
     *Input: N, MAX, DESIRED_FUNCTION_VALUE
     *Output: t, v_c, f(v_c)
     */

    public void calculatioMethod() {
        Scanner sc = new Scanner(System.in);
        HillClimberGUI obj1 = new HillClimberGUI();
        final int MIN_RANGE = 10;
        final int MAX_RANGE = 25;
        //double desired_function_value = 10;//Desired value 
        double initial_point_1 = Math.random() * (MAX_RANGE) - MIN_RANGE;//this returns the value between -10.0 and 15.0 inclusive
        double initial_point_2 = Math.random() * (MAX_RANGE) - MIN_RANGE;//this returns the value between -10.0 and 15.0 inclusive
        double initial_point_3 = Math.random() * (MAX_RANGE) - MIN_RANGE;//this returns the value between -10.0 and 15.0 inclusive
        double neighbour_point1;
        double neighbour_point2;
        double neighbour_point3;
        double neighbour_function_value;
        int loop_Count = 0;//counts the number of iterations in finding the optimal desired_function_value.

        String k = JOptionPane.showInputDialog(null, "Please enter the desired function value");
        if (k == null) {
            JOptionPane.showMessageDialog(null, "Error please try again", "Message", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        if (k.equals("")) {
            JOptionPane.showMessageDialog(null, "Error please try again", "Message", JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        double desired_function_value = Double.parseDouble(k);

        
        double function_value = Math.pow(initial_point_1, 2) + Math.pow(initial_point_2, 2) + Math.pow(initial_point_3, 2);
        
        String initialVectorPoints = obj1.toString(initial_point_1, initial_point_2, initial_point_3);
        
        String initialfunctionValue = obj1.toString(function_value);
        JOptionPane.showMessageDialog(null, initialVectorPoints + "\n" + initialfunctionValue);
       

        if (function_value <= desired_function_value) {
            desired_function_value = function_value;
           
            
            String optimalVectorPoints = obj1.toString(initial_point_1, initial_point_2, initial_point_3);
            
            String optimalVectorValue = obj1.toString(desired_function_value);
           
            JOptionPane.showMessageDialog(null, "The function value is less than the initial desired function value\n"
                    + " Now, the desired function value and vector points are: \n\n"
                    + optimalVectorPoints + optimalVectorValue, "Message", JOptionPane.INFORMATION_MESSAGE);
           
        } else {

            //iterates until the optimum value is found
            // until (neighbour_function_value <= desired_function_value) is true
            while (true) {

                //maintaing the range given -10.0 to 15.0
                while (true) {
                    neighbour_point1 = initial_point_1 + (Math.random() * (25) - 10);
                    if (neighbour_point1 >= -10.0 && neighbour_point1 <= 15.0) {
                        break;
                    }
                }
                //maintaing the range given -10.0 to 15.0
                while (true) {
                    neighbour_point2 = initial_point_2 + (Math.random() * (25) - 10);
                    if (neighbour_point2 >= -10.0 && neighbour_point2 <= 15.0) {
                        break;
                    }
                }
                //maintaing the range given -10.0 to 15.0
                while (true) {
                    neighbour_point3 = initial_point_3 + (Math.random() * (25) - 10);
                    if (neighbour_point3 >= -10.0 && neighbour_point3 <= 15.0) {
                        break;
                    }
                }

                neighbour_function_value = Math.pow(neighbour_point1, 2) + Math.pow(neighbour_point2, 2) + Math.pow(neighbour_point3, 2);

        
                if (neighbour_function_value <= desired_function_value) {

                    desired_function_value = neighbour_function_value;
                    initial_point_1 = neighbour_point1;
                    initial_point_2 = neighbour_point2;
                    initial_point_3 = neighbour_point3;

                    break;
                }
                loop_Count++;
            }
        
            String iteration = obj1.toString("\nNumber of total iterations: t = ", loop_Count);
            String newOptimalVectorPoints = obj1.toString("New Optimal vector points v_c =", initial_point_1, initial_point_2, initial_point_3);
            String newOptimalVectorValue = obj1.toString("New Optimal vector value: f(v_c) =", desired_function_value);
            JOptionPane.showMessageDialog(null, iteration + newOptimalVectorPoints + newOptimalVectorValue);
        }

    }

    public String toString(double a, double b, double c) {
        return String.format("Initial vector points = {%.6f}, {%.6f}, {%.6f}\n", a, b, c);
    }

    public String toString(String message, double a, double b, double c) {
        return String.format("%s {%.6f}, {%.6f}, {%.6f}\n", message, a, b, c);
    }

    public String toString(double a) {
        return String.format("Initial function value = %.6f\n\n", a);
    }

    public String toString(String message, double a) {
        return String.format("%s %.6f\n", message, a);
    }

    public String toString(String message, int a) {
        return String.format("%s %d\n", message, a);
    }
}
