package ua.alvin.procedural;

public class AscendingSequenceEdit {
    public static void main(String[] args) {
        System.out.println(longestAscendingSubsequence(5123245));
        System.out.println(longestAscendingSubsequence(12343467));
        System.out.println(longestAscendingSubsequence(2405123));
        System.out.println(longestAscendingSubsequence(752338338));
        System.out.println(longestAscendingSubsequence(1678912345));
        System.out.println(longestAscendingSubsequence(1235891234));
        System.out.println(longestAscendingSubsequence(1234186789));
        System.out.println(longestAscendingSubsequence(1238956789));
    }


    static int longestAscendingSubsequence(int inputSequence) {
        //longest sequence of consecutive natural digits
        int tempShiftFactor = inputSequence;
        int numberOfDigits = 0;
        while (tempShiftFactor != 0) {
            numberOfDigits++;
            tempShiftFactor /= 10;
        }

        int shiftFactor = 1;
        for (int i = 1; i < numberOfDigits; i++) {
            shiftFactor *= 10;
        }

        int count = 0;
        int currentPosition = inputSequence / shiftFactor;
        int currentDigit;
        int nextDigit = 0;
        int tempSubsequence = 0;
        int nextPositionInSubsequence;
        int longestSubsequence = 0;

        while (count < numberOfDigits) {
            nextPositionInSubsequence = tempSubsequence * 10;
            if (shiftFactor > 1) {
                currentDigit = currentPosition;
                shiftFactor = shiftFactor / 10;
                nextDigit = (inputSequence / (shiftFactor)) % 10;
            } else {
                currentDigit = inputSequence % 10;
            }
            if ((tempSubsequence % 10 > currentDigit)
                    || ((tempSubsequence % 10) + 1) != currentDigit) {
                tempSubsequence = 0;
                nextPositionInSubsequence = 0;
            }
            if (currentDigit == nextDigit - 1) {
                tempSubsequence = nextPositionInSubsequence + currentDigit;
            } else {
                if ((currentDigit - 1) == (tempSubsequence % 10)) {
                    tempSubsequence = nextPositionInSubsequence + currentDigit;
                }
                if (tempSubsequence > longestSubsequence) {
                    longestSubsequence = tempSubsequence;
                    tempSubsequence = 0;
                }
            }
            currentPosition = nextDigit;
            count++;
        }
        return longestSubsequence;
    }
}
