package main

import (
	"fmt"
	"strconv"
)

func calculateDrinks(n, m int) (int, int, []string) {
	totalDrinks := n  // Общее количество выпитых банок
	iterations := 0   // Количество итераций
	emptyBottles := n // Количество пустых банок
	steps := make([]string, 0)

	for emptyBottles > 1 {
		// Вычисляем, сколько полных банок можно получить в обмен на пустые
		newFull := emptyBottles / m
		if newFull == 0 { // Если банок недостаточно для обмена, прерываем цикл
			break
		}
		// Увеличиваем общее количество выпитых банок
		totalDrinks += newFull
		// Увеличиваем количество итераций
		iterations++
		// Вычисляем новое количество пустых банок
		emptyBottles = emptyBottles%m + newFull
		// Записываем шаг
		steps = append(steps, "Step "+strconv.Itoa(iterations)+" - Drank "+strconv.Itoa(newFull)+
			" of cans left "+strconv.Itoa(emptyBottles)+" empty cans")
	}

	return totalDrinks, iterations, steps
}

func main() {
	n := 15 // Количество полных банок
	m := 4  // Количество пустых банок для обмена на одну полную

	totalDrinks, iterations, steps := calculateDrinks(n, m)

	fmt.Println("Maximum number of cans drunk:", totalDrinks)
	fmt.Println("Number of iterations:", iterations)
	for _, step := range steps {
		fmt.Println(step)
	}
}
