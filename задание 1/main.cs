using System;

class Program
{
    static void Main()
    {
        int N, M;
        Console.Write("Input length: ");
        while (!int.TryParse(Console.ReadLine(), out N))
        {
            Console.WriteLine("Invalid input. Please enter a valid integer for length.");
            Console.Write("Input length: ");
        }

        Console.Write("Input width: ");
        while (!int.TryParse(Console.ReadLine(), out M))
        {
            Console.WriteLine("Invalid input. Please enter a valid integer for width.");
            Console.Write("Input width: ");
        }

        Console.Write("Input all commands: ");
        string commands = Console.ReadLine();

        int x = 0, y = 0;

        foreach (char command in commands)
        {
            switch (command)
            {
                case 'L':
                    x -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
                case 'D':
                    y += 1;
                    break;
                case 'U':
                    y -= 1;
                    break;
                default:
                    Console.WriteLine($"Invalid command - {command}");
                    return;
            }

            if (Math.Abs(y) >= N || Math.Abs(x) >= M)
            {
                Console.WriteLine("No");
                return;
            }
        }

        Console.WriteLine($"({M - Math.Abs(x)},{N - Math.Abs(y)})");
    }
}