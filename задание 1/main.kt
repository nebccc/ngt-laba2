import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    print("Input length: ")
    val N = scanner.nextInt()

    print("Input width: ")
    val M = scanner.nextInt()

    print("Input all commands: ")
    val commands = scanner.next()

    var x = 0
    var y = 0

    for (command in commands) {
        when (command) {
            'L' -> x -= 1
            'R' -> x += 1
            'D' -> y += 1
            'U' -> y -= 1
            else -> {
                println("Invalid command - $command")
                return
            }
        }

        if (Math.abs(y) >= N || Math.abs(x) >= M) {
            println("No")
            return
        }
    }

    println("(${M - Math.abs(x)}, ${N - Math.abs(y)})")
}
