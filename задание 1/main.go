package main

import (
	"fmt"
	"os"
)

func main() {
	var N, M int
	fmt.Print("Input length: ")
	_, err := fmt.Scan(&N)
	if err != nil {
		fmt.Println("Error:", err)
		os.Exit(1)
	}

	fmt.Print("Input width: ")
	_, err = fmt.Scan(&M)
	if err != nil {
		fmt.Println("Error:", err)
		os.Exit(1)
	}

	var commands string
	fmt.Print("Input all commands: ")
	_, err = fmt.Scan(&commands)
	if err != nil {
		fmt.Println("Error:", err)
		os.Exit(1)
	}

	x, y := 0, 0

	for _, command := range commands {
		switch command {
		case 'L':
			x -= 1
		case 'R':
			x += 1
		case 'D':
			y += 1
		case 'U':
			y -= 1
		default:
			fmt.Printf("Invalid command - %c\n", command)
			os.Exit(1)
		}

		if abs(y) >= N || abs(x) >= M {
			fmt.Println("No")
			os.Exit(0)
		}
	}

	fmt.Printf("(%d,%d)\n", M-abs(x), N-abs(y))
}

func abs(x int) int {
	if x < 0 {
		return -x
	}
	return x
}
