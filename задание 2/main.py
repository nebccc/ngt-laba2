def calculate_drinks(n, m):
    total_drinks = n  # Общее количество выпитых банок
    iterations = 0  # Количество итераций
    empty_bottles = n  # Количество пустых банок

    # Пошаговый процесс
    steps = []

    while empty_bottles > 1:
        # Вычисляем, сколько полных банок можно получить в обмен на пустые
        new_full = empty_bottles // m
        if new_full == 0:  # Если банок недостаточно для обмена, прерываем цикл
            break
        # Увеличиваем общее количество выпитых банок
        total_drinks += new_full
        # Увеличиваем количество итераций
        iterations += 1
        # Вычисляем новое количество пустых банок
        empty_bottles = empty_bottles % m + new_full
        # Записываем шаг
        steps.append(f'Шаг {iterations} - Выпито {new_full} банок, осталось {empty_bottles} пустых банок')

    return total_drinks, iterations, steps

# Пример использования функции:
n = 15  # Количество полных банок
m = 4   # Количество пустых банок для обмена на одну полную

total_drinks, iterations, steps = calculate_drinks(n, m)
print(f'Максимальное количество выпитых банок: {total_drinks}')
print(f'Количество итераций: {iterations}')
for step in steps:
    print(step)
