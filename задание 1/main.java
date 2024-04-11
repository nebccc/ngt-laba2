import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input length: ");
        int N = 0;
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer for length.");
            System.out.print("Input length: ");
            scanner.next();
        }
        N = scanner.nextInt();

        System.out.print("Input width: ");
        int M = 0;
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a valid integer for width.");
            System.out.print("Input width: ");
            scanner.next();
        }
        M = scanner.nextInt();

        System.out.print("Input all commands: ");
        String commands = scanner.next();

        int x = 0, y = 0;

        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'L':
                    x -= 1;
                    break;
                case 'R':
                    x += 1;
                    break;
                case 'D':
                    y += 1;
                    break;
                case 'U':
                    y -= 1;
                    break;
                default:
                    System.out.println("Invalid command - " + command);
                    return;
            }

            if (Math.abs(y) >= N || Math.abs(x) >= M) {
                System.out.println("No");
                return;
            }
        }

        System.out.println("(" + (M - Math.abs(x)) + "," + (N - Math.abs(y)) + ")");
    }
}