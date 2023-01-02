package com.company;
import java.io.IOException;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("WELCOME TO THE RESTAURANT 'LABMYST'!");
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Kebab");
        menu.add("Stake");
        menu.add("Burger");
        menu.add("Salade");
        System.out.println("\nMenu has " + menu.size() + " dishes: " + menu);

        System.out.println("\nIs Kebab in the menu? " + menu.contains("Kebab"));
        System.out.println("The location of Burger in the menu? " + menu.indexOf("Burger"));
        System.out.println("Is the menu empty? " + menu.isEmpty());

        List<String> drinks = Arrays.asList("Juice", "Martini", "Limoncello", "Aperol", "Limonad");
        System.out.println("\nDrinks: " + drinks);
        Collections.reverse(drinks);
        Collection<String> drink1 = Arrays.asList("Martini", "Panache");
        Collection<String> drink2 = Arrays.asList("Martini", "Aperol");
        Collection<String> drink3 = Arrays.asList("Cola", "Water");
        System.out.println("Set of drinks №1 and №2 are completely divergent: " + Collections.disjoint(drink1, drink2) + ". \nSet of drinks №1 and №3 are completely divergent: " + Collections.disjoint(drink1, drink3));
        Collection<String> drinks0 = Arrays.asList("Martini", "Panache", "Martini");
        System.out.println("The bar has " + Collections.frequency(drinks0, "Martini") + " bottles of Martini");

        ArrayList<String> new_menu = new ArrayList<>();
        new_menu.add("French fries");
        new_menu.add("Shawarma");
        new_menu.add("Fahitos");
        new_menu.add("Sushi");
        new_menu.add("Pizza");
        new_menu.add("Bolognaise");
        try {
            Collections.copy(menu, new_menu);
            System.out.println("Drinks in the old order: " + drinks);
            Collections.swap(menu, 0, 4);
        }
        catch (IndexOutOfBoundsException index) {
            System.out.println("\nNew menu: " + new_menu);
            System.out.println("Drinks in the new order: " + drinks);
        }

        System.out.println("\nThe client can order FOOD: " + new_menu + "\nand DRINKS: " + drinks);
        LinkedList<Integer> rating = new LinkedList<>();
        rating.add(1);
        rating.add(2);
        rating.add(3);
        rating.add(4);
        rating.add(5);
        ListIterator<Integer> i = rating.listIterator();
        while(i.hasNext()) {
            int n = i.next();
        }
        System.out.println("\nYou can rate the service and dishes: " + rating);
        Scanner in = new Scanner(System.in);

        System.out.print("Input a list of orders: ");
        String list = in.nextLine();
        System.out.printf("Your list: %s \n", list);
        System.out.print("Input amount of dishes: ");
        int amount = in.nextInt();
        System.out.printf("Amount: %d \n", amount);

        System.out.print("Input a rating to dishes " + new_menu + ": ");
        int rate = in.nextInt();
        System.out.print("Input a rating to drinks " + drinks + ": ");
        int rate2 = in.nextInt();
        System.out.printf("Your rating to dishes: %d \n", rate);
        System.out.printf("Your rating to drinks: %d \n", rate2);
        in.close();

        ArrayList dishes_in_menu = new ArrayList(Arrays.asList(new String[] {
                "\nNumbers and prices of dishes in new menu:" + "\n1 - French fries:", "2 - Shawarma:", "3 - Fahitos:", "" + "\n4 - Sushi:", "5 - Pizza:", "6 - Bolognaise:"}));
        ArrayList prices_of_dishes = new ArrayList(Arrays.asList(new String[] {
                "24 hrn;", "73 hrn;", "56 hrn;", "104 hrn;", "80 hrn;", "61 hrn;"}));
        merge(dishes_in_menu, prices_of_dishes);
        dishes_in_menu.stream().map(eat -> eat + " ").forEach(System.out::print);

        int[] numbers = {1,2,4,2,6};
        int[] result = getMostFrequentNumbers(numbers);
        System.out.println("\nThe most popular dish has number: " + Arrays.toString(result));
    }
    public static void merge(List dishes_in_menu, List prices_of_dishes) {
        for (Iterator iter_prices_of_dishes = prices_of_dishes.iterator(); iter_prices_of_dishes.hasNext(); ) {
            for (ListIterator iter = dishes_in_menu.listIterator(); iter.hasNext(); ) {
                iter.next();
                iter.add(iter_prices_of_dishes.next());
            }
        }
    }
    public static int[] getMostFrequentNumbers(int[] numbers) {
        if(numbers.length > 0) {
            int[] uniqueNumbers = new int[] { numbers[0] };
            for(int i = 1; i < numbers.length; i++) {
                int number = numbers[i];
                if(indexOf(uniqueNumbers, number) == -1) {
                    uniqueNumbers = Arrays.copyOf(uniqueNumbers, uniqueNumbers.length + 1);
                    uniqueNumbers[uniqueNumbers.length - 1] = number;
                }
            }
            int[] counts = new int[uniqueNumbers.length];
            int max = 0;
            for(int number : numbers) {
                int index = indexOf(uniqueNumbers, number);
                counts[index]++;
                if(counts[index] > max) {
                    max = counts[index];
                }
            }
            int[] result = new int[0];
            for(int i = 0; i < counts.length; i++) {
                if(counts[i] == max) {
                    result = Arrays.copyOf(result, result.length + 1);
                    result[result.length - 1] = uniqueNumbers[i];
                }
            }
            return result;
        }
        return new int[0];
    }
    public static int indexOf(int[] array, int element) {
        for(int i = 0; i < array.length; i++) {
            if(array[i] == element) {
                return i;
            }
        }
        return -1;
    }
}
