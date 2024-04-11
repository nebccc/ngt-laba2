use std::io::{self, BufRead};

fn init_vec() -> Vec<i32> {
    loop {
        println!("Enter the numbers separated by a space:");
        let mut input = String::new();
        io::stdin().lock().read_line(&mut input).unwrap();

        let mut vec_num = Vec::new();
        let mut valid_input = true;

        for s in input.trim().split_whitespace() {
            match s.parse::<i32>() {
                Ok(num) => vec_num.push(num),
                Err(_) => {
                    eprintln!("Error: An invalid value has been entered! Try again:");
                    vec_num.clear();
                    valid_input = false;
                    break;
                }
            }
        }

        if valid_input {
            return vec_num;
        }
    }
}

fn is_prime(num: i32) -> bool {
    if num <= 1 {
        return false;
    }
    for i in 2..=(num as f64).sqrt() as i32 {
        if num % i == 0 {
            return false;
        }
    }
    true
}

fn main() {
    let numbers = init_vec();

    let prime_count = numbers.iter().filter(|&&num| is_prime(num)).count();

    println!("Number of prime numbers: {}", prime_count);
}