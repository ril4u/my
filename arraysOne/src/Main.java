import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String[] products = {"Греча", "Сосисы", "Кетчонез"};
        int[] prices = {80, 245, 117};
        int[] basket = {0,0,0};
        int sumProducts = 0;
        int countBasket = 0;

        System.out.println("Для покупки доступны:");
        for (int i = 0; i < products.length; i++) {
            System.out.println(i + 1 + ". " + products[i] + " по " + prices[i] + " руб. за шт.");
        }
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите товар и количество или введите `end`");
            String inputString = scanner.nextLine();
            if ("end".equals(inputString)) {
                System.out.println("В вашей корзине:");
                //вывод содержимого корзины
                for (int i = 0; i < basket.length; i++) {
                    if (basket[i] != 0) {
                        System.out.println(products[i] + " по " + prices[i]  + " руб. в кол-ве " + basket[i] + " шт. Стоимость: " + prices[i] * basket[i] + " руб.");
                        countBasket++;
                    }
                }
                System.out.println((countBasket != 0) ? ("Итого: " + sumProducts + " руб.") : "Пусто!");
                break;
            }
            int productNumber = 0;
            int productCount = 0;
            String[] inputSplit = inputString.split(" "); // "1 4"
            productNumber = Integer.parseInt(inputSplit[0]);
            productCount = Integer.parseInt(inputSplit[1]);
            basket[productNumber-1] += productCount;
            sumProducts += prices[productNumber-1] * productCount;
    }
}}