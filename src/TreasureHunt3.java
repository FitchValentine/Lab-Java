import java.util.Scanner;

public class TreasureHunt3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод координат клада
        System.out.print("Введите координаты клада (x y): ");
        int treasureX = scanner.nextInt();
        int treasureY = scanner.nextInt();

        int steps = 0;

        while (true) {
            // Ввод направления и количества шагов
            System.out.print("Введите направление (север/юг/запад/восток) или 'стоп': ");
            String direction = scanner.next();

            if (direction.equals("стоп")) {
                break;
            }

            int numSteps = scanner.nextInt();

            // Двигаемся в указанном направлении
            if (direction.equals("север")) {
                treasureY += numSteps;
            } else if (direction.equals("юг")) {
                treasureY -= numSteps;
            } else if (direction.equals("запад")) {
                treasureX -= numSteps;
            } else if (direction.equals("восток")) {
                treasureX += numSteps;
            }

            steps++;
        }

        // Рассчитываем минимальное количество шагов
        int minSteps = Math.abs(treasureX) + Math.abs(treasureY);

        // Выводим результат
        System.out.println("Минимальное количество указаний карты: " + minSteps);
    }
}