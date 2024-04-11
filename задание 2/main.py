def calculate_drinks(n, m):
    total_drinks = n  
    iterations = 0  
    empty_bottles = n  

    steps = []

    while empty_bottles > 1:
        new_full = empty_bottles // m
        if new_full == 0:  
            break
        total_drinks += new_full
        iterations += 1
        empty_bottles = empty_bottles % m + new_full
        steps.append(f'Шаг {iterations} - Выпито {new_full} банок, осталось {empty_bottles} пустых банок')

    return total_drinks, iterations, steps

# Получаем данные от пользователя
n = int(input("Введите количество полных банок: "))
m = int(input("Введите количество пустых банок для обмена на одну полную: "))

total_drinks, iterations, steps = calculate_drinks(n, m)
print(f'Максимальное количество выпитых банок: {total_drinks}')
print(f'Количество итераций: {iterations}')
for step in steps:
    print(step)
