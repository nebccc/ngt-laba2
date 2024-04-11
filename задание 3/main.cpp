#include <iostream>
#include <limits>

using namespace std;

bool isPrime(int num) {
    if (num <= 1) {
        return false;
    }
    for (int i = 2; i * i <= num; ++i) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
}

int main() {
    int size = 0;
    int num = 0;

    int res = 0;

    while (!(cin >> size)) { // проверка на тип данных
        cout << "Invalid input. Please enter an integer: ";
        cin.clear(); // очистка флагов ошибок ввода
        cin.ignore(numeric_limits<streamsize>::max(), '\n'); // очистка буфера ввода
    }

    for (int i = 0; i < size; i++) {
        while (!(cin >> num)) { // проверка на тип данных
            cout << "Invalid input. Please enter an integer: ";
            cin.clear(); // очистка флагов ошибок ввода
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // очистка буфера ввода
        }

        if (isPrime(num)){
            res++;
        }
    }

    cout << res << endl;
    
    return 0;
}