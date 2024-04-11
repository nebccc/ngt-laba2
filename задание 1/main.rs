use std::io::{self, Write};

fn main() {
    let mut input = String::new();

    print!("Input length: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let N: i32 = input.trim().parse().expect("Please enter a valid integer for length");

    input.clear();
    print!("Input width: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let M: i32 = input.trim().parse().expect("Please enter a valid integer for width");

    input.clear();
    print!("Input all commands: ");
    io::stdout().flush().unwrap();
    io::stdin().read_line(&mut input).expect("Failed to read line");
    let commands = input.trim();

    let mut x: i32 = 0;
    let mut y: i32 = 0;

    for command in commands.chars() {
        match command {
            'L' => x -= 1,
            'R' => x += 1,
            'D' => y += 1,
            'U' => y -= 1,
            _ => {
                println!("Invalid command - {}", command);
                return;
            }
        }

        if y.abs() >= N || x.abs() >= M {
            println!("No");
            return;
        }
    }

    println!("({}, {})", M - x.abs(), N - y.abs());
}
