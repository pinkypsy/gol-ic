package ua.alvin.procedural;

public class AscendingSequenceEdit {
    public static void main(String[] args) {
        System.out.println(longestAscendingSubsequence(5123245));
        System.out.println(longestAscendingSubsequence(12342435));
        System.out.println(longestAscendingSubsequence(2405123));
        System.out.println(longestAscendingSubsequence(752338338));
        System.out.println(longestAscendingSubsequence(1678912345));
        System.out.println(longestAscendingSubsequence(1235891234));
        System.out.println(longestAscendingSubsequence(1234186789));
        System.out.println(longestAscendingSubsequence(1234567890));
    }

    static int longestAscendingSubsequence(int originalNumber) {
        //longest sequence of consecutive natural digits
        int tempShiftPos = originalNumber;
        int numberOfDigits = 0;
        while (tempShiftPos != 0) {
            numberOfDigits++;
            tempShiftPos = tempShiftPos / 10;
        }

        int shiftFactor = 1;
        for (int i = 1; i < numberOfDigits; i++) {
            shiftFactor = shiftFactor * 10;
        }

        int count = 0;
        int currentPosition = originalNumber / shiftFactor;
        int currentDigit;
        int nextDigit = 0;
        int tempSubsequence = 0;
        int nextPositionInSubsequence;

        int resultMaxSubsequence = 0;
        while (count < numberOfDigits) {
            nextPositionInSubsequence = tempSubsequence * 10;
            if (shiftFactor > 1) {
                currentDigit = currentPosition;
                shiftFactor = shiftFactor / 10;
                nextDigit = (originalNumber / (shiftFactor)) % 10;
            } else {
                currentDigit = originalNumber % 10;
            }
            if ((tempSubsequence % 10) > currentDigit
                    || ((tempSubsequence % 10) + 1) != currentDigit) {
                tempSubsequence = 0;
            }
            if (currentDigit == nextDigit - 1) {
                tempSubsequence = (nextPositionInSubsequence) + currentDigit;
            } else {
                if ((currentDigit - 1) == tempSubsequence % 10) {
                    tempSubsequence = (nextPositionInSubsequence) + currentDigit;
                }
                if (tempSubsequence > resultMaxSubsequence) {
//                    tempSubsequence = (tempSubsequence * 10) + currentDigit;
                    resultMaxSubsequence = tempSubsequence;
                    tempSubsequence = 0;
                }
            }
            currentPosition = nextDigit;
            count++;
        }
        //            System.out.println("currentDigit: " + currentDigit + ", nextDigit: " + nextDigit);
//        System.out.println("resultMaxSubsequence: " + resultMaxSubsequence);
        return resultMaxSubsequence;
    }
}
