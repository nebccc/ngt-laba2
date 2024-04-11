import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers {
    public static void initList(List<Integer> list) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the numbers separated by a space: ");
        
        do {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            
            while (lineScanner.hasNext()) {
                if (lineScanner.hasNextInt()) {
                    list.add(lineScanner.nextInt());
                } else {
                    System.err.println("Error: An invalid value has been entered! Try again:");
                    list.clear();
                    break;
                }
            }
            
            if (!lineScanner.hasNext() && !lineScanner.hasNextInt()) {
                break;
            }
        } while (true);
    }

    public static boolean isPrime(int num) {
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

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        initList(numbers);

        int primeCount = 0;
        for (int num : numbers) {
            if (isPrime(num)) {
                ++primeCount;
            }
        }

        System.out.println("Number of prime numbers: " + primeCount);
    }
}
