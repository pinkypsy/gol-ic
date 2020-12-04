//package ua.alvin.procedural;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//public class LoopsSolution {
//
//*
//     * org.apache.logging.log4j.Logger (LOG4J)
//
//
//    private static final Logger LOG4J_LOG =
//            LogManager.getLogger(LoopsSolution.class);
//
//    public static void main(String[] args) {
//
//        int testValue = 123890;
//        int testRangeStart = -4;
//        int testRangeEnd = 12;
//        LOG4J_LOG.info("sumOfEven: " + sumOfEven(testValue));
//
//        LOG4J_LOG.info("biggestDigit " + biggestDigit(testValue));
//
//        biggerThanFive(testValue);
//
//        LOG4J_LOG.info("findPrimeNumbersInRange(" + testRangeStart + ", " + testRangeEnd + "):");
//        findPrimeNumbersInRange(testRangeStart, testRangeEnd);
//
//        LOG4J_LOG.info("findPrimeDigitsInNumber(" + testValue + "):");
//        findPrimeDigitsInNumber(testValue);
//
//        LOG4J_LOG.info("biggestSumOfNeighbors "
//                + biggestSumOfNeighbors(testValue));
//
//        LOG4J_LOG.info("remove digit " + 3 + " from " + testValue
//                + ": " + removeDigit(testValue,
//                3));
//    }
//
//    //#1
//    static int sumOfEven(int originalNumber) {
//
//        int currentDigit;
//        int currentPosition = originalNumber;
//        int resultSum = 0;
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
//        while (currentPosition != 0) {
//            currentDigit = currentPosition % 10;
//            currentPosition /= 10;
//            if (currentDigit > 5) {
//                LOG4J_LOG.info("biggerThanFive " + currentDigit);
//            }
//        }
//    }
//
//    //#3
//    static int removeDigit(int originalNumber, int digitToRemove) {
//
//        int revolvedTempNumber = 0;
//
//        int currentPosition = originalNumber;
//
//        while (currentPosition != 0) {
//            int currentDigit = currentPosition % 10;
//            currentPosition = currentPosition / 10;
//
//            if (currentDigit == digitToRemove) {
//                continue;
//            } else {
//                revolvedTempNumber = (revolvedTempNumber * 10) + currentDigit;
//            }
//        }
//
//        int resultNumber = 0;
//
//        while (revolvedTempNumber != 0) {
//
//            resultNumber = (resultNumber * 10) + (revolvedTempNumber % 10);
//
//            revolvedTempNumber = revolvedTempNumber / 10;
//        }
//        int lastDigit = originalNumber % 10;
//
//        if (lastDigit == 0) {
//            resultNumber = resultNumber * 10;
//        }
//
//        return resultNumber;
//    }
//
//    //#4
//    static int biggestDigit(int originalNumber) {
//
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
//    static int biggestSumOfNeighbors(int num) {
//        int currentPosition = num;
//        int maxSum = 0;
//        int currentDigit;
//        int nextDigit;
//
//        while (currentPosition != 0) {
//            currentDigit = currentPosition % 10;
//            currentPosition /= 10;
//            nextDigit = currentPosition % 10;
//
//            int currentSum = currentDigit + nextDigit;
//
//            if (currentSum > maxSum) {
//                maxSum = currentSum;
//            }
//        }
//        return maxSum;
//    }
//
//    //#6
//    static void longestAscendingSubsequence(int originalNumber) {
//
//    }
//
//    //#7
//    static void findPrimeDigitsInNumber(int originalNumber) {
//
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
//                LOG4J_LOG.info(currentDigit + " is prime number");
//            } else {
//                for (int dividend = 2; dividend < currentDigit; dividend++) {
//                    if (currentDigit % dividend == 0) {
//                        isPrime = false;
//                        break;
//                    }
//                }
//                if (isPrime) {
//                    LOG4J_LOG.info(currentDigit + " is prime number");
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
//                LOG4J_LOG.info(candidate + " is prime number");
//            } else {
//                for (int dividend = 2; dividend < candidate; dividend++) {
//                    if (candidate % dividend == 0) {
//                        isPrime = false;
//                        break;
//                    }
//                }
//                if (isPrime) {
//                    LOG4J_LOG.info(candidate + " is prime number");
//                }
//            }
//        }
//    }
//}
