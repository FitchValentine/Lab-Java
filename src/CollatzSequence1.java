import java.util.Scanner;

public class CollatzSequence1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод числа n
        System.out.print("Введите натуральное число n: ");
        int n = scanner.nextInt();

        // Переменная для хранения количества шагов
        int steps = 0;

        // Пока n не станет равным 1
        while (n != 1) {
            // Если число чётное
            if (n % 2 == 0) {
                n = n / 2;
            } else {  // Если число нечётное
                n = 3 * n + 1;
            }
            steps++;
        }

        // Вывод количества шагов
        System.out.println("Количество шагов: " + steps);
    }
}