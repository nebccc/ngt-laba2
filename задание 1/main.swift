import Foundation

print("Input length: ", terminator: "")
let N = Int(readLine()!)!

print("Input width: ", terminator: "")
let M = Int(readLine()!)!

print("Input all commands: ", terminator: "")
let commands = readLine()!

var x = 0
var y = 0

for command in commands {
    switch command {
    case "L":
        x -= 1
    case "R":
        x += 1
    case "D":
        y += 1
    case "U":
        y -= 1
    default:
        fatalError("Invalid command - \(command)")
    }

    if abs(y) >= N || abs(x) >= M {
        print("No")
        exit(1)
    }
}

print("(\(M - abs(x)), \(N - abs(y)))")
