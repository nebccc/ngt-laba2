use std::io;

fn calculate_drinks(n: i32, m: i32) -> (i32, i32, Vec<String>) {
    let mut total_drinks = n;
    let mut iterations = 0;
    let mut empty_bottles = n;
    let mut steps = Vec::new();

    while empty_bottles > 1 {
        let new_full = empty_bottles / m;
        if new_full == 0 {
            break;
        }
        total_drinks += new_full;
        iterations += 1;
        empty_bottles = empty_bottles % m + new_full;
        steps.push(format!("Step {} - Drank {} of cans left {} empty cans", iterations, new_full, empty_bottles));
    }

    (total_drinks, iterations, steps)
}

fn main() {
    println!("Enter the number of full cans:");
    let mut input = String::new();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let n: i32 = input.trim().parse().expect("Please enter a valid number");

    println!("Enter the number of empty cans needed for exchange:");
    input.clear();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let m: i32 = input.trim().parse().expect("Please enter a valid number");

    let (total_drinks, iterations, steps) = calculate_drinks(n, m);
    println!("Maximum number of cans drunk: {}", total_drinks);
    println!("Number of iterations: {}", iterations);
    for step in steps {
        println!("{}", step);
    }
}
