use std::io;

// Function to add two numbers
fn add(a: i32, b: i32) -> i32 {
    a + b
}

// Function to subtract two numbers
fn subtract(a: i32, b: i32) -> i32 {
    a - b
}

// Function to multiply two numbers
fn multiply(a: i32, b: i32) -> i32 {
    a * b
}

// Function to divide two numbers
fn divide(a: i32, b: i32) -> f64 {
    // Check for division by zero
    if b != 0 {
        f64::from(a) / f64::from(b)
    } else {
        eprintln!("Error: Division by zero.");
        0.0
    }
}

fn main() {
    // Example values
    let num1 = 10;
    let num2 = 5;

    // Invocations of the functions
    println!("Sum: {}", add(num1, num2));
    println!("Difference: {}", subtract(num1, num2));
    println!("Product: {}", multiply(num1, num2));
    println!("Quotient: {}", divide(num1, num2));

    // Read input from the user for demonstration
    let mut input = String::new();
    println!("Enter two numbers separated by space:");
    io::stdin().read_line(&mut input).expect("Failed to read line");
    
    let mut numbers = input.trim().split_whitespace();
    let num3: i32 = numbers.next().unwrap().parse().expect("Invalid input");
    let num4: i32 = numbers.next().unwrap().parse().expect("Invalid input");

    // Additional invocations with user input
    println!("Sum: {}", add(num3, num4));
    println!("Difference: {}", subtract(num3, num4));
    println!("Product: {}", multiply(num3, num4));
    println!("Quotient: {}", divide(num3, num4));
}
