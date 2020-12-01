package ua.alvin.procedural;

import java.util.Arrays;

public class QuadraticEquation {
    public static void main(String[] args) {

        int a = 1;
        int b = 6;
        int c = 5;

        int disc = calcDiscriminant(a, b, c);
        System.out.println("disc: " + disc);

        int numOfRoots = numOfRoots(disc);

        System.out.println("numOfRoots: " + numOfRoots);

        int [] roots = calcRoots(a, b, disc, numOfRoots);

        System.out.println(Arrays.toString(roots));

        getArgumentsOfEquation("x-4x-5");
    }

    static int [] getArgumentsOfEquation(String input){
        String expression = input.replace(" ", "");
        char [] elements = expression.toCharArray();
        String [] arguments = new String[3];

        String first = "";
        String second = "";
        String third = "";

        if (expression.charAt(0) == '-') {
            first += expression.charAt(0);
            expression = expression.substring(1);
        }

        int pos = 0;

            while (pos < expression.length()){
                if (Character.isDigit(expression.charAt(pos))) {
                    pos++;
                }
                first += expression.substring(0,pos);
            }
            expression = expression.substring(pos);

            while (pos < expression.length()){
                if (Character.isDigit(expression.charAt(pos))) {
                    pos++;
                }
                second += expression.substring(0,pos);
            }
            expression = expression.substring(pos);

            while (pos < expression.length()){
                if (Character.isDigit(expression.charAt(pos))) {
                    pos++;
                }
                third += expression.substring(0,pos);
            }


        System.out.println(first);
        System.out.println(second);
        System.out.println(third);


 /*       for (int i = 0; i < expression.length(); i++) {

            char element = expression.charAt(i);
            if (element)
        }*/
return null;
    }
    
    static int [] calcRoots(int a, int b, int disc, int numOfRoots){

        if (numOfRoots < 1){
            throw new ArithmeticException("No roots");
        }
        int [] roots = new int [numOfRoots];

        roots[0] = (-(b) + (int) Math.sqrt(disc)) / (2 * a);

        if (numOfRoots > 1) {
            roots[1] = (-(b) - (int) Math.sqrt(disc)) / (2 * a);
        }

        return roots;
    }

    static int numOfRoots(int disc){
        return (disc < 0) ? 0 :
                (disc > 0) ? 2 : 1;
    }
    
    static int calcDiscriminant(int a, int b, int c){
        return (int) Math.pow(b, 2) - 4 * a * c;
    }
}
