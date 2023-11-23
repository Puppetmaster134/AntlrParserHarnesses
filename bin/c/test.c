#include <stdio.h>

// Function to add two numbers
int add(int a, int b) {
    return a + b;
}

// Function to multiply two numbers
int multiply(int a, int b) {
    return a * b;
}

int main() {
    // Example usage of the functions
    int num1 = 5, num2 = 3;

    // Call the add function
    int sum = add(num1, num2);
    printf("Sum: %d\n", sum);

    // Call the multiply function
    int product = multiply(num1, num2);
    printf("Product: %d\n", product);

    return 0;
}
