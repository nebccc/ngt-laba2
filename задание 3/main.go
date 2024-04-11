package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

func initList() []int {
	reader := bufio.NewReader(os.Stdin)
	for {
		fmt.Print("Enter the numbers separated by a space: ")
		input, _ := reader.ReadString('\n')
		input = strings.TrimSpace(input)
		strNums := strings.Fields(input)
		nums := make([]int, 0, len(strNums))
		validInput := true
		for _, strNum := range strNums {
			num, err := strconv.Atoi(strNum)
			if err != nil {
				fmt.Println("Error: An invalid value has been entered! Try again:")
				validInput = false
				break
			}
			nums = append(nums, num)
		}
		if validInput {
			return nums
		}
	}
}

func isPrime(num int) bool {
	if num <= 1 {
		return false
	}
	for i := 2; i*i <= num; i++ {
		if num%i == 0 {
			return false
		}
	}
	return true
}

func main() {
	numbers := initList()

	primeCount := 0
	for _, num := range numbers {
		if isPrime(num) {
			primeCount++
		}
	}

	fmt.Println("Number of prime numbers:", primeCount)
}
