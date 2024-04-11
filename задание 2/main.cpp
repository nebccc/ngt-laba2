#include <iostream>
#include <vector>
#include <string>

using namespace std;

tuple<int, int, vector<string>> calculate_drinks(int n, int m) {
    int total_drinks = n;  // Общее количество выпитых банок
    int iterations = 0;    // Количество итераций
    int empty_bottles = n; // Количество пустых банок

    // Пошаговый процесс
    vector<string> steps;

    while (empty_bottles > 1) {
        // Вычисляем, сколько полных банок можно получить в обмен на пустые
        int new_full = empty_bottles / m;
        if (new_full == 0) { // Если банок недостаточно для обмена, прерываем цикл
            break;
        }
        // Увеличиваем общее количество выпитых банок
        total_drinks += new_full;
        // Увеличиваем количество итераций
        iterations++;
        // Вычисляем новое количество пустых банок
        empty_bottles = empty_bottles % m + new_full;
        // Записываем шаг
        steps.push_back("Step  " + to_string(iterations) + " - Drank " + to_string(new_full) + " of cans left " + to_string(empty_bottles) + " empty cans");
    }

    return make_tuple(total_drinks, iterations, steps);
}

int main() {
    int n, m;
    cout << "Enter the number of full cans: ";
    cin >> n;
    cout << "Enter the number of empty cans needed for exchange: ";
    cin >> m;

    auto result = calculate_drinks(n, m);
    int total_drinks = get<0>(result);
    int iterations = get<1>(result);
    vector<string> steps = get<2>(result);

    cout << "Maximum number of cans drunk: " << total_drinks << endl;
    cout << "Number of iterations: " << iterations << endl;
    for (const auto& step : steps) {
        cout << step << endl;
    }

    return 0;
}
