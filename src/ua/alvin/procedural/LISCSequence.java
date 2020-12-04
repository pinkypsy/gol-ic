package ua.alvin.procedural;

public class LISCSequence {
    public static void main(String[] args) {
//        System.out.println(longestAscendingSubsequence(123245));
//        System.out.println(longestAscendingSubsequence(1324512345));
        System.out.println(longestAscendingSubsequence(245123));
//        System.out.println(longestAscendingSubsequence(752338338));
    }

    static int longestAscendingSubsequence(int originalNumber) {
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
        int currentPosition = originalNumber / coefficientOfShifting;
        int nextPosition;
        int currentDigit = 0;
        int nextDigit = 0;
        int lastDigit = originalNumber % 10;
        int resultMaxSubsequence = 0;
        int tempSequence = 0;
        int count = 0;
        while (count < numberOfDigits - 1) {
            currentDigit = currentPosition;
            currentPosition = (originalNumber % (coefficientOfShifting)) / (coefficientOfShifting / 10);
            nextDigit = currentPosition;
            coefficientOfShifting = coefficientOfShifting / 10;
//            System.out.println("currentDigit: " + currentDigit + ", nextDigit: " + nextDigit);
            if (tempSequence % 10 > currentDigit) {
//                resultMaxSubsequence = tempSequence;
                tempSequence = 0;
            }
//            System.out.println("current tempSequence: " + tempSequence);
            if (currentDigit == nextDigit - 1) {
                tempSequence = (tempSequence * 10) + currentDigit;
              /*  count++;
                continue;*/
            } else if ((currentDigit - 1) == tempSequence % 10) {
                tempSequence = (tempSequence * 10) + currentDigit;
                   /* count++;
                    continue;*/
            } else{
                tempSequence = 0;
            }
                if (tempSequence > resultMaxSubsequence) {
                    resultMaxSubsequence = tempSequence;
//                    tempSequence = 0;
                }

            count++;
        }
        return resultMaxSubsequence;
    }
}
