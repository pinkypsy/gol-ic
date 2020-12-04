package ua.alvin.procedural;

public class AscendingSequence {
    public static void main(String[] args) {
        longestAscendingSubsequence(5123245);
        longestAscendingSubsequence(12342435);
        longestAscendingSubsequence(245123);
        longestAscendingSubsequence(752338338);
        longestAscendingSubsequence(1324512345);
    }

    static void longestAscendingSubsequence(int originalNumber) {
        int tempShiftPos = originalNumber;
        int numberOfDigits = 0;
        int max = 0;
        while (tempShiftPos != 0) {
            numberOfDigits++;
            tempShiftPos = tempShiftPos / 10;
        }

        int coefficientOfShifting = 1;
        for (int i = 1; i < numberOfDigits; i++) {
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
        System.out.println("originalNumber: " + originalNumber);
        int count = 0;
        int currentPosition = originalNumber / coefficientOfShifting;
        int nextPosition;
        int currentDigit = 0;
        int nextDigit = 0;
        int lastDigit = originalNumber % 10;
        int resultMaxSubsequence = 0;
        int tempSequence = 0;
        int length = 0;
//        System.out.println("lastDigit: " + lastDigit); //5
        //  int tempCoefOfShifting = coefficientOfShifting;
        while (count < numberOfDigits - 1) {
            currentDigit = currentPosition;
            currentPosition = (originalNumber % (coefficientOfShifting)) / (coefficientOfShifting / 10);
            nextDigit = currentPosition;
            coefficientOfShifting = coefficientOfShifting / 10;
//            System.out.println("currentDigit: " + currentDigit + ", nextDigit: " + nextDigit);

            if (currentDigit == nextDigit - 1) {
//            if (tempSequence % 10 < currentDigit){
                tempSequence = (tempSequence * 10) + currentDigit;

            } else {

                /*if ((tempSequence % 10) + 1 == currentDigit) {
                    tempSequence = (tempSequence * 10) + currentDigit;
                }*/
                if (tempSequence > resultMaxSubsequence) {
                    tempSequence = (tempSequence * 10) + currentDigit;
                    resultMaxSubsequence = tempSequence;
                    tempSequence = 0;
                }
            }
            count++;
        }
        System.out.println("resultMaxSubsequence: " + resultMaxSubsequence);

    }
}

//while (count < numberOfDigits - 1) {
//        currentDigit = currentPosition;
//        currentPosition = (originalNumber % (coefficientOfShifting)) / (coefficientOfShifting / 10);
//        nextDigit = currentPosition;
//        coefficientOfShifting = coefficientOfShifting / 10;
//        System.out.println("currentDigit: " + currentDigit + ", nextDigit: " + nextDigit);
//
//        if (currentDigit == nextDigit - 1) {
////            if (tempSequence % 10 < currentDigit){
//        tempSequence = (tempSequence * 10) + currentDigit;
//
//        } else {
//
//                /*if ((tempSequence % 10) + 1 == currentDigit) {
//                    tempSequence = (tempSequence * 10) + currentDigit;
//                }*/
//        if (tempSequence > resultMaxSubsequence) {
//        resultMaxSubsequence = tempSequence;
//        tempSequence = 0;
//        }
//        }
//        count++;
//        }