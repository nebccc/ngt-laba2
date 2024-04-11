import java.util.*

fun initVec(vecNum: MutableList<Int>) {
    val scanner = Scanner(System.`in`)
    println("Enter the numbers separated by a space: ")

    var s: String?

    do {
        try {
            s = scanner.nextLine()
            if (s.isNullOrBlank()) {
                System.err.println("Error: Empty input! Try again: ")
                continue
            }
            val iss = Scanner(s)

            while (iss.hasNextInt()) {
                vecNum.add(iss.nextInt())
            }

            if (!iss.hasNext()) {
                break
            } else {
                System.err.println("Error: An invalid value has been entered! Try again: ")
                vecNum.clear()
            }
        } catch (e: InputMismatchException) {
            System.err.println("Error: Invalid input format! Try again: ")
            vecNum.clear()
        }

    } while (true)
}

fun isPrime(num: Int): Boolean {
    if (num <= 1) {
        return false
    }
    var i = 2
    while (i * i <= num) {
        if (num % i == 0) {
            return false
        }
        i++
    }
    return true
}

fun main() {
    val numbers = mutableListOf<Int>()
    initVec(numbers)

    var primeCount = 0
    for (num in numbers) {
        if (isPrime(num)) {
            primeCount++
        }
    }

    println("Number of prime numbers: $primeCount")
}