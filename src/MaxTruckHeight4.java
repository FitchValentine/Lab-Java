import java.util.Scanner;

class Road {
    int roadNumber;
    int maxHeight;

    Road(int roadNumber, int maxHeight) {
        this.roadNumber = roadNumber;
        this.maxHeight = maxHeight;
    }
}

public class MaxTruckHeight4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество дорог: ");
        int numRoads = scanner.nextInt();

        Road maxRoad = new Road(0, 0);

        for (int i = 0; i < numRoads; i++) {
            System.out.print("Введите количество туннелей для дороги " + (i + 1) + ": ");
            int tunnelCount = scanner.nextInt();

            int minTunnelHeight = Integer.MAX_VALUE;
            for (int j = 0; j < tunnelCount; j++) {
                System.out.print("Введите высоту туннеля " + (j + 1) + " для дороги " + (i + 1) + ": ");
                int tunnelHeight = scanner.nextInt();
                minTunnelHeight = Math.min(minTunnelHeight, tunnelHeight);
            }

            if (minTunnelHeight > maxRoad.maxHeight) {
                maxRoad.maxHeight = minTunnelHeight;
                maxRoad.roadNumber = i + 1;
            }
        }

        System.out.println("Максимальная высота грузовика: " + maxRoad.maxHeight);
        System.out.println("Номер дороги: " + maxRoad.roadNumber);
    }
}