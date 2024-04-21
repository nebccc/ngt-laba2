#include <iostream>
#include <string>
#include <limits>
using namespace std;

int main() {
    int N, M;
    cout << "Input length: ";
    do {
        if (cin.fail()) {
            cin.clear(); // Reset the input stream
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Discard invalid input
        }
        cout << "Please enter a valid length: ";
        cin >> N;
    } while (cin.fail());

    cout << "Input width: ";
    do {
        if (cin.fail()) {
            cin.clear(); // Reset the input stream
            cin.ignore(numeric_limits<streamsize>::max(), '\n'); // Discard invalid input
        }
        cout << "Please enter a valid width: ";
        cin >> M;
    } while (cin.fail());

    string commands;
    cout << "Input all commands: ";
    cin >> commands;

    int x = 0, y = 0;

    for (char command : commands) {
        if (command == 'L') {
            x -= 1;
        }
        else if (command == 'R') {
            x += 1;
        }
        else if (command == 'D') {
            y += 1;
        }
        else if (command == 'U') {
            y -= 1;
        }
        else {
            throw invalid_argument("Invalid command - " + command);
        }

        if (abs(y) >= N || abs(x) >= M) {
            cout << "No" << endl;
            return 1;
        }
    }

    cout << "(" << M - abs(x) << "," << N - abs(y) << ")" << endl;
    return 0;
}
