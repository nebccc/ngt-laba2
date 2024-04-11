import kotlin.math.floor

fun calculateDrinks(n: Int, m: Int): Triple<Int, Int, List<String>> {
    var totalDrinks = n
    var iterations = 0
    var emptyBottles = n

    val steps = mutableListOf<String>()

    while (emptyBottles > 1) {
        val newFull = emptyBottles / m
        if (newFull == 0) {
            break
        }
        totalDrinks += newFull
        iterations++
        emptyBottles = emptyBottles % m + newFull
        steps.add("Step $iterations - Drank $newFull of cans left $emptyBottles empty cans")
    }

    return Triple(totalDrinks, iterations, steps)
}

fun main() {
    print("Enter the number of full cans: ")
    val n = readLine()!!.toInt()

    print("Enter the number of empty cans needed for exchange: ")
    val m = readLine()!!.toInt()

    val (totalDrinks, iterations, steps) = calculateDrinks(n, m)
    println("Maximum number of cans drunk: $totalDrinks")
    println("Number of iterations: $iterations")
    steps.forEach { step -> println(step) }
}