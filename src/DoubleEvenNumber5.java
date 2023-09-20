import java.util.Scanner;

public class DoubleEvenNumber5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите трехзначное число: ");
        int number = scanner.nextInt();

        if (number >= 100 && number <= 999) {
            int sumOfDigits = calculateSumOfDigits(number);
            int productOfDigits = calculateProductOfDigits(number);

            if (sumOfDigits % 2 == 0 && productOfDigits % 2 == 0) {
                System.out.println("Число является дважды четным.");
            } else {
                System.out.println("Число не является дважды четным.");
            }
        } else {
            System.out.println("Введено некорректное трехзначное число.");
        }
    }

    // Метод для вычисления суммы цифр числа
    private static int calculateSumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    // Метод для вычисления произведения цифр числа
    private static int calculateProductOfDigits(int num) {
        int product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }
}