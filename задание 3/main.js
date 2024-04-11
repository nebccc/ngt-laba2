const readline = require('readline');

function initVec(vecNum) {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    console.log("Enter the numbers separated by a space: ");

    rl.on('line', (input) => {
        const nums = input.trim().split(' ').map(Number);
        if (nums.some(isNaN)) {
            console.error("Error: An invalid value has been entered! Try again: ");
            vecNum.length = 0;
        } else {
            vecNum.push(...nums);
            rl.close();
        }
    });
}

function isPrime(num) {
    if (num <= 1) {
        return false;
    }
    for (let i = 2; i * i <= num; ++i) {
        if (num % i === 0) {
            return false;
        }
    }
    return true;
}

function main() {
    const numbers = [];
    initVec(numbers);

    process.on('exit', () => {
        const primeCount = numbers.filter(isPrime).length;
        console.log("Number of prime numbers: " + primeCount);
    });
}

main();
