package ua.alvin.procedural;

public class AscendingSequenceImproved {
    public static void main(String[] args) {
        longestAscendingSubsequence(5123245);
        longestAscendingSubsequence(12342435);
        longestAscendingSubsequence(245123);
        longestAscendingSubsequence(752338338);
        longestAscendingSubsequence(1678912345);
        longestAscendingSubsequence(1235891234);
        longestAscendingSubsequence(1234186789);
    }


    static void longestAscendingSubsequence(int originalNumber) {
        //longest sequence of consecutive natural digits
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

        System.out.println("originalNumber: " + originalNumber);
        int count = 0;
        int currentPosition = originalNumber / coefficientOfShifting;
        int nextPosition;
        int currentDigit = 0;
        int nextDigit = 0;
        int lastDigit = originalNumber % 10;
        int length = 0;
//        System.out.println("lastDigit: " + lastDigit); //5
        //  int tempCoefOfShifting = coefficientOfShifting;
        int resultMaxSubsequence = 0;
        int tempSequence = 0;
        while (count < numberOfDigits) {
            if (coefficientOfShifting > 1) {
                currentDigit = currentPosition;
                currentPosition = (originalNumber % (coefficientOfShifting)) / (coefficientOfShifting / 10);
                nextDigit = currentPosition;
            } else {
                currentDigit = originalNumber % 10;
            }
            coefficientOfShifting = coefficientOfShifting / 10;
            if (tempSequence % 10 > currentDigit || ((tempSequence % 10) + 1) != currentDigit) {
                tempSequence = 0;
            }
            if (currentDigit == nextDigit - 1) {
                tempSequence = (tempSequence * 10) + currentDigit;
            } else {
                if ((currentDigit - 1) == tempSequence % 10) {
                    tempSequence = (tempSequence * 10) + currentDigit;
                }
                if (tempSequence > resultMaxSubsequence) {
//                    tempSequence = (tempSequence * 10) + currentDigit;
                    resultMaxSubsequence = tempSequence;
                    tempSequence = 0;
                }
            }
            count++;
        }
        //            System.out.println("currentDigit: " + currentDigit + ", nextDigit: " + nextDigit);
        System.out.println("resultMaxSubsequence: " + resultMaxSubsequence);

    }
}
