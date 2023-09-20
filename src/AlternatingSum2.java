import java.util.Scanner;

public class AlternatingSum2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества чисел
        System.out.print("Введите количество чисел: ");
        int n = scanner.nextInt();

        int sum = 0;

        // Чтение чисел и вычисление знакочередующейся суммы
        for (int i = 1; i <= n; i++) {
            int number = scanner.nextInt();
            if (i % 2 == 1) {
                sum += number;  // Прибавляем число, если позиция нечётная
            } else {
                sum -= number;  // Вычитаем число, если позиция чётная
            }
        }

        // Вывод знакочередующейся суммы
        System.out.println("Знакочередующаяся сумма ряда: " + sum);
    }
}