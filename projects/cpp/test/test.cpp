#include <iostream>

// Function to add two numbers
int add(int a, int b) {
    return a + b;
}

// Function to subtract two numbers
int subtract(int a, int b) {
    return a - b;
}

// Function to multiply two numbers
int multiply(int a, int b) {
    return a * b;
}

// Function to divide two numbers
double divide(int a, int b) {
    // Check for division by zero
    if (b != 0) {
        return static_cast<double>(a) / b;
    } else {
        std::cerr << "Error: Division by zero." << std::endl;
        return 0.0;
    }
}

int main() {
    // Example values
    int num1 = 10, num2 = 5;

    // Invocations of the functions
    std::cout << "Sum: " << add(num1, num2) << std::endl;
    std::cout << "Difference: " << subtract(num1, num2) << std::endl;
    std::cout << "Product: " << multiply(num1, num2) << std::endl;
    std::cout << "Quotient: " << divide(num1, num2) << std::endl;

    return 0;
}
