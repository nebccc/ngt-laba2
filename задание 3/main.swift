import Foundation

func initList() -> [Int] {
    while true {
        do {
            guard let input = readLine() else {
                print("Error: No input found! Try again: ")
                continue
            }
            let nums = try input.split(separator: " ").map { str in
                guard let num = Int(str) else {
                    throw InputError.invalidValue
                }
                return num
            }
            return nums
        } catch InputError.invalidValue {
            print("Error: An invalid value has been entered! Try again: ")
        } catch {
            print("An unknown error occurred!")
        }
    }
}

enum InputError: Error {
    case invalidValue
}

func isPrime(_ num: Int) -> Bool {
    if num <= 1 {
        return false
    }
    for i in 2..<Int(Double(num).squareRoot()) + 1 {
        if num % i == 0 {
            return false
        }
    }
    return true
}

func main() {
    let numbers = initList()

    let primeCount = numbers.filter { isPrime($0) }.count

    print("Number of prime numbers: \(primeCount)")
}

main()