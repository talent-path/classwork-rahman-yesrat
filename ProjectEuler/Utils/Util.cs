﻿using System;
using System.Collections.Generic;
using System.Numerics;
using System.Linq; 

namespace Utils
{
    public static class Util
    {
        public static bool IsPrime(BigInteger number)
        {

            bool prime = true;

            //Number is prime if
            //1 2 3 4 6 12
            //1 12
            //2 6
            //3 4

            BigInteger squareRoot = GetSquareRoot(number);

            //Handle 2 special case

            if (number % 2 == 0)
            {
                return number == 2;
            }

            for (BigInteger i = 3; i <= squareRoot; i += 2)
            {
                if (number % i == 0)
                {
                    prime = false;
                    break;
                }
            }
            return prime;

        }

        public static bool IsPrime(int number)
        {
            if (number < 2) return false;
            bool prime = true;
            int squareRoot = GetSquareRoot(number);
            if (number % 2 == 0)
            {
                return number == 2;
            }

            for (int i = 3; i <= squareRoot; i += 2)
            {
                if (number % i == 0)
                {
                    prime = false;
                    break;
                }
            }
            return prime;

        }

        public static bool IsPrime(long number)
        {
            if (number < 2) return false;
            bool prime = true;
            long squareRoot = GetSquareRoot(number);
            if (number % 2 == 0)
            {
                return number == 2;
            }

            for (long i = 3; i <= squareRoot; i += 2)
            {
                if (number % i == 0)
                {
                    prime = false;
                    break;
                }
            }
            return prime;

        }

        public static bool IsPrime(List<int> Primes, int number)
        {

            foreach (int prime in Primes)
            {
                if (GetSquareRoot(number) < prime)
                {
                    break;
                }
                if (number % prime == 0)
                {
                    return false;
                }
            }
            return true;

        }

        public static BigInteger GetSquareRoot(BigInteger num)
        {
            BigInteger squareRoot = 0;

            for (BigInteger i = 1; i < num; i++)
            {
                if ((i * i) > num)
                {
                    squareRoot = i - 1;
                    break;
                }
            }
            return squareRoot;
        }

        public static int GetSquareRoot(int num)
        {
            int squareRoot = 0;

            for (int i = 1; i < num; i++)
            {
                if ((i * i) > num)
                {
                    squareRoot = i - 1;
                    break;
                }
            }
            return squareRoot;
        }
        public static long GetSquareRoot(long num)
        {
            long squareRoot = 0;

            for (long i = 1; i < num; i++)
            {
                if ((i * i) > num)
                {
                    squareRoot = i - 1;
                    break;
                }
            }
            return squareRoot;
        }

        public static bool IsPalindrome(BigInteger num)
        {

            BigInteger temp = num;
            BigInteger sum = 0;
            while (num > 0)
            {
                BigInteger rem = num % 10;
                num = num / 10;
                sum = sum * 10 + rem;
            }

            if (sum == temp)
            {
                return true;
            }
            return false;
        }

        public static long AsciiSum(string plainText)
        {
            return plainText.Select(c => (int)c).Sum(); 
            
        }

        public static BigInteger ReverseNum(BigInteger i)
        {
            BigInteger reverse = 0;
            while (i > 0)
            {
                BigInteger remainder = i % 10;

                reverse = reverse * 10 + remainder;
                i /= 10;

            }
            return reverse;
        }

        public static int SumOfSquares(int maxNumber)
        {
            int sumOfSquares = 0;

            for (int i = 1; i <= maxNumber; i++)
            {
                sumOfSquares += (i * i);
            }

            return sumOfSquares;
        }


        public static int SquareOfSums(int maxNumber)
        {
            int squareOfSums = 0;

            for (int i = 1; i <= maxNumber; i++)
            {
                squareOfSums += i;
            }

            return squareOfSums * squareOfSums;
        }

        public static List<int> GetFactors(int number)
        {
            List<int> factors = new List<int>();

            for (int i = 1; i * i <= number; i += 1)
            {
                if (number % i == 0)
                {
                    factors.Add(i);
                    if (i * i != number)
                    {
                        factors.Add(number / i);
                    }
                }
            }
            return factors;
        }

        public static void GeneratePermutations(List<string> allPermutations, string currNum, List<string> availableNums)
        {
            //currNum = 0
            //currNum = 01
            //currNum = 012
            //currNum = 0123
            if (availableNums.Count == 0)
            {
                if(int.Parse(currNum) %2 != 0)
                {
                    allPermutations.Add(currNum);

                }
            }
            else
            {
                for (int i = 0; i < availableNums.Count; i++)
                {
                    string addString = availableNums[i];

                    availableNums.RemoveAt(i);

                    GeneratePermutations(allPermutations, currNum + addString, availableNums);

                    availableNums.Insert(i, addString);
                }
            }

        }




    }
} 


    
