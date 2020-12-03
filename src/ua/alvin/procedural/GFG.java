package ua.alvin.procedural;

class GFG {

    /*
     * Program to delete Nth digit of a Number
     * https://www.geeksforgeeks.org/program-to-delete-nth-digit-of-a-number/
     */

    public static void main(String[] args) {
//        System.out.println(deleteFromStart(123,3));
        System.out.println(deleteDigit1(504695, 5));
    }

    static int deleteDigit1(int num, int digitToRemove) {
        int digitCount = 0;
        int tempNum = num;
        while (tempNum > 0) {
            tempNum /= 10;
            digitCount++;
        }

/*        // Get the number of digits
        int digitCount = (int) Math.log10(num) + 1;*/

        // Declare a variable
        // to form the reverse resultant number
        int revolvedTempNum = 0;

        // Loop with the number

        int shiftPos = num;
        while (shiftPos != 0) {
            int currentDigit = shiftPos % 10;
            shiftPos = shiftPos / 10;

            if (currentDigit == digitToRemove) {
                continue;
            } else {

                revolvedTempNum = (revolvedTempNum * 10) + currentDigit;
            }
        }


        // Declare a variable
        // to form the resultant number
        int resultNum = 0;

        // Loop with the number
        while (revolvedTempNum != 0) {
            int firstDigit = (int) (revolvedTempNum / Math.pow(10, digitCount - 1));

            if (firstDigit == 0) {
                resultNum = (resultNum * 10) + (revolvedTempNum % 10);

                revolvedTempNum = revolvedTempNum / 10;
                continue;
            }
            resultNum = (resultNum * 10) + (revolvedTempNum % 10);

            revolvedTempNum = revolvedTempNum / 10;
        }

        // Return the resultant number
        return resultNum;
    }

}