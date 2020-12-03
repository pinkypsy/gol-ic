package ua.alvin.procedural;

public class AscendingSequence {
    public static void main(String[] args) {
        longestAscendingSubsequence(123245);
    }

    static void longestAscendingSubsequence(int originalNumber) {
        int tempShiftPos = originalNumber;
        int digitCount = 0;
        int max = 0;
        while (tempShiftPos != 0) {
            digitCount++;
            tempShiftPos = tempShiftPos / 10;
        }

        int coefficientOfShifting = 1;
        for (int i = 1; i < digitCount; i++) {
            coefficientOfShifting = coefficientOfShifting * 10;
        }

//        int currentPosition = originalNumber;
////        int maxSum = 0;
//        int currentPosition;
//        int nextDigit;
//
//        while (currentPosition != 0) {
//            currentPosition = currentPosition % 10;
//            currentPosition /= 10;
//            nextDigit = currentPosition % 10;
//
//
//        }
//123245
        int currentPosition = originalNumber / coefficientOfShifting;
        int currentDigit = 0;
        int nextDigit = 0;
        int lastDigit = originalNumber % 10;
        int resultSubsequence = 0;
        System.out.println(lastDigit); //5
        int tempCoefOfShifting = coefficientOfShifting;
        while (currentPosition != lastDigit){


           /* currentDigit = currentPosition;
            nextDigit = currentPosition * 10;

            System.out.println(currentDigit);
            System.out.println(nextDigit);*/

//            if (currentPosition <= )

            System.out.println(currentPosition);
            currentPosition = (originalNumber % (tempCoefOfShifting)) / (tempCoefOfShifting/10);
            tempCoefOfShifting = tempCoefOfShifting / 10;
        }


/*        System.out.println(coefficientOfShifting);

        System.out.println(digitCount);

        System.out.println(originalNumber / coefficientOfShifting);*/
    }
}
