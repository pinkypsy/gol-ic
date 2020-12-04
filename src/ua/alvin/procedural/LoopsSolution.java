//package com.solution;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
///**
// * Class <code>LoopsSolution</code> contains methods
// * @author Maksim Zamanov
// */
//public class LoopsSolution {
//
//    /**
//     * Log4j logger
//     */
//    private static final Logger LOG =
//            LogManager.getLogger(LoopsSolution.class);
//
//    /**
//     * Main method that invokes methods according to homework
//     * @param args The command line arguments.
//     */
//    public static void main(String[] args) {
//        int testValue = 1239456780;
//        int testRangeStart = 1;
//        int testRangeEnd = 12;
//
//        LOG.info("sumOfEven(" + testValue + "): " + sumOfEven(testValue));
//
//        biggerThanFive(testValue);
//
//        LOG.info("After removing " + 3 + " from " + testValue
//                + " it turns into " + removeDigit(testValue, 3));
//
//        LOG.info("biggestDigit(" + testValue + "): " + biggestDigit(testValue));
//
//        LOG.info("biggestSumOfNeighbors "
//                + biggestSumOfNeighbors(testValue));
//
//        LOG.info("longestAscendingSubsequence in " + testValue + " is "
//                + longestAscendingSubsequence(testValue));
//
//        LOG.info("findPrimeDigitsInNumber(" + testValue + "):");
//        findPrimeDigitsInNumber(testValue);
//
//        LOG.info("findPrimeNumbersInRange(" + testRangeStart + ", "
//                + testRangeEnd + "):");
//        findPrimeNumbersInRange(testRangeStart, testRangeEnd);
//
//    }
//
//    /**
//     * Calculates sum of even digits in natural number
//     * @param originalNumber Input data to process
//     * @return Sum of even digits of input value
//     */
//    static int sumOfEven(int originalNumber) {
//        int currentDigit;
//        int currentPosition = originalNumber;
//        int resultSum = 0;
//
//        while (currentPosition != 0) {
//            currentDigit = currentPosition % 10;
//            currentPosition /= 10;
//            if (currentDigit % 2 == 0) {
//                resultSum += currentDigit;
//            }
//        }
//        return resultSum;
//    }
//
//    //#2
//    static void biggerThanFive(int originalNumber) {
//        int currentDigit;
//        int currentPosition = originalNumber;
//
//        LOG.info("In " + originalNumber + " bigger than five is:");
//        while (currentPosition != 0) {
//            currentDigit = currentPosition % 10;
//            currentPosition /= 10;
//            if (currentDigit > 5) {
//                LOG.info("biggerThanFive: " + currentDigit);
//            }
//        }
//    }
//
//    //#3
//    static int removeDigit(int originalNumber, int digitToRemove) {
//        int revolvedTempNumber = 0;
//        int revolvedTempNumberNextPos;
//        int currentPosition = originalNumber;
//
//        while (currentPosition != 0) {
//            revolvedTempNumberNextPos = revolvedTempNumber * 10;
//            int currentDigit = currentPosition % 10;
//            currentPosition = currentPosition / 10;
//            if (currentDigit == digitToRemove) {
//                continue;
//            } else {
//                revolvedTempNumber = revolvedTempNumberNextPos + currentDigit;
//            }
//        }
//
//        int resultNumber = 0;
//        int resultNumberNextPosition;
//
//        while (revolvedTempNumber != 0) {
//            resultNumberNextPosition = resultNumber * 10;
//            resultNumber = resultNumberNextPosition + (revolvedTempNumber % 10);
//            revolvedTempNumber = revolvedTempNumber / 10;
//        }
//        int lastDigit = originalNumber % 10;
//        if (lastDigit == 0) {
//            resultNumber = resultNumber * 10;
//        }
//        return resultNumber;
//    }
//
//    //#4
//    static int biggestDigit(int originalNumber) {
//        int currentPosition = originalNumber;
//        int maxDigit = 0;
//        int currentDigit;
//
//        while (currentPosition != 0) {
//            currentDigit = currentPosition % 10;
//            currentPosition /= 10;
//            if (currentDigit > maxDigit) {
//                maxDigit = currentDigit;
//            }
//        }
//        return maxDigit;
//    }
//
//    //#5
//    static int biggestSumOfNeighbors(int originalNumber) {
//        int currentPosition = originalNumber;
//        int maxSum = 0;
//        int currentDigit;
//        int nextDigit;
//
//        while (currentPosition != 0) {
//            currentDigit = currentPosition % 10;
//            currentPosition /= 10;
//            nextDigit = currentPosition % 10;
//            int currentSum = currentDigit + nextDigit;
//            if (currentSum > maxSum) {
//                maxSum = currentSum;
//            }
//        }
//        return maxSum;
//    }
//
//    //#6 longest sequence of consecutive natural digits
//    static int longestAscendingSubsequence(int inputSequence) {
//        int tempShiftFactor = inputSequence;
//        int numberOfDigits = 0;
//
//        while (tempShiftFactor != 0) {
//            numberOfDigits++;
//            tempShiftFactor /= 10;
//        }
//
//        int shiftFactor = 1;
//        for (int i = 1; i < numberOfDigits; i++) {
//            shiftFactor *= 10;
//        }
//
//        int count = 0;
//        int currentPosition = inputSequence / shiftFactor;
//        int currentDigit;
//        int nextDigit = 0;
//        int tempSubsequence = 0;
//        int nextPositionInSubsequence;
//        int longestSubsequence = 0;
//
//        while (count < numberOfDigits) {
//            nextPositionInSubsequence = tempSubsequence * 10;
//            if (shiftFactor > 1) {
//                currentDigit = currentPosition;
//                shiftFactor /= 10;
//                nextDigit = (inputSequence / (shiftFactor)) % 10;
//            } else {
//                currentDigit = inputSequence % 10;
//            }
//            if ((tempSubsequence % 10 > currentDigit)
//                    || ((tempSubsequence % 10) + 1) != currentDigit) {
//                tempSubsequence = 0;
//                nextPositionInSubsequence = 0;
//            }
//            if (currentDigit == nextDigit - 1) {
//                tempSubsequence = nextPositionInSubsequence + currentDigit;
//            } else {
//                if ((currentDigit - 1) == (tempSubsequence % 10)) {
//                    tempSubsequence = nextPositionInSubsequence + currentDigit;
//                }
//                if (tempSubsequence > longestSubsequence) {
//                    longestSubsequence = tempSubsequence;
//                    tempSubsequence = 0;
//                }
//            }
//            currentPosition = nextDigit;
//            count++;
//        }
//        return longestSubsequence;
//    }
//
//    //#7
//    static void findPrimeDigitsInNumber(int originalNumber) {
//        int currentPosition = originalNumber;
//        int currentDigit;
//
//        while (currentPosition != 0) {
//            currentDigit = currentPosition % 10;
//            currentPosition /= 10;
//            boolean isPrime = true;
//            if (currentDigit < 2) {
//                continue;
//            } else if (currentDigit == 2) {
//                LOG.info(currentDigit + " is prime number");
//            } else {
//                for (int dividend = 2; dividend < currentDigit; dividend++) {
//                    if (currentDigit % dividend == 0) {
//                        isPrime = false;
//                        break;
//                    }
//                }
//                if (isPrime) {
//                    LOG.info(currentDigit + " is prime number");
//                }
//            }
//        }
//    }
//
//    //#8
//    static void findPrimeNumbersInRange(int start, int end) {
//        for (int candidate = start; candidate <= end; candidate++) {
//            boolean isPrime = true;
//            if (candidate < 2) {
//                continue;
//            } else if (candidate == 2) {
//                LOG.info(candidate + " is prime number");
//            } else {
//                for (int dividend = 2; dividend < candidate; dividend++) {
//                    if (candidate % dividend == 0) {
//                        isPrime = false;
//                        break;
//                    }
//                }
//                if (isPrime) {
//                    LOG.info(candidate + " is prime number");
//                }
//            }
//        }
//    }
//}
