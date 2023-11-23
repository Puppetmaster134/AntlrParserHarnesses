using System;

class Program
{
    // Function to add two numbers
    static int Add(int a, int b)
    {
        return a + b;
    }

    // Function to subtract two numbers
    static int Subtract(int a, int b)
    {
        return a - b;
    }

    // Function to multiply two numbers
    static int Multiply(int a, int b)
    {
        return a * b;
    }

    // Function to divide two numbers
    static double Divide(int a, int b)
    {
        // Check for division by zero
        if (b != 0)
        {
            return (double)a / b;
        }
        else
        {
            Console.Error.WriteLine("Error: Division by zero.");
            return 0.0;
        }
    }

    static void Main()
    {
        // Example values
        int num1 = 10, num2 = 5;

        // Invocations of the functions
        Console.WriteLine($"Sum: {Add(num1, num2)}");
        Console.WriteLine($"Difference: {Subtract(num1, num2)}");
        Console.WriteLine($"Product: {Multiply(num1, num2)}");
        Console.WriteLine($"Quotient: {Divide(num1, num2)}");

        // Read input from the user for demonstration
        Console.WriteLine("Enter two numbers separated by space:");
        string input = Console.ReadLine();
        string[] numbers = input.Split();

        if (numbers.Length == 2 && int.TryParse(numbers[0], out int num3) && int.TryParse(numbers[1], out int num4))
        {
            // Additional invocations with user input
            Console.WriteLine($"Sum: {Add(num3, num4)}");
            Console.WriteLine($"Difference: {Subtract(num3, num4)}");
            Console.WriteLine($"Product: {Multiply(num3, num4)}");
            Console.WriteLine($"Quotient: {Divide(num3, num4)}");
        }
        else
        {
            Console.WriteLine("Invalid input. Please enter two integers separated by space.");
        }
    }
}
