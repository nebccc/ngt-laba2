func calculateDrinks(n: Int, m: Int) -> (Int, Int, [String]) {
    var totalDrinks = n
    var iterations = 0
    var emptyBottles = n
    var steps = [String]()

    while emptyBottles > 1 {
        let newFull = emptyBottles / m
        if newFull == 0 {
            break
        }
        totalDrinks += newFull
        iterations += 1
        emptyBottles = emptyBottles % m + newFull
        steps.append("Step \(iterations) - Drank \(newFull) of cans left \(emptyBottles) empty cans")
    }

    return (totalDrinks, iterations, steps)
}

let n = 15
let m = 4

let result = calculateDrinks(n: n, m: m)
let totalDrinks = result.0
let iterations = result.1
let steps = result.2

print("Maximum number of cans drunk: \(totalDrinks)")
print("Number of iterations: \(iterations)")
for step in steps {
    print(step)
}
