using System;
using System.Collections.Generic;

class Program
{
    static void InitList(List<int> list)
    {
        Console.Write("Enter the numbers separated by a space: ");
        
        do
        {
            string line = Console.ReadLine();
            string[] parts = line.Split(' ');
            bool validInput = true;
            
            foreach (string part in parts)
            {
                if (int.TryParse(part, out int num))
                {
                    list.Add(num);
                }
                else
                {
                    Console.Error.WriteLine("Error: An invalid value has been entered! Try again:");
                    list.Clear();
                    validInput = false;
                    break;
                }
            }
            
            if (validInput)
            {
                break;
            }
        } while (true);
    }

    static bool IsPrime(int num)
    {
        if (num <= 1)
        {
            return false;
        }
        for (int i = 2; i * i <= num; ++i)
        {
            if (num % i == 0)
            {
                return false;
            }
        }
        return true;
    }

    static void Main(string[] args)
    {
        List<int> numbers = new List<int>();
        InitList(numbers);

        int primeCount = 0;
        foreach (int num in numbers)
        {
            if (IsPrime(num))
            {
                ++primeCount;
            }
        }

        Console.WriteLine("Number of prime numbers: " + primeCount);
    }
}