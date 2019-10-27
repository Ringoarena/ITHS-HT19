package clothingstore;

import discount.BlackFridayDiscountStrategy;
import discount.WinterDiscountStrategy;
import enumcollections.Season;

public class Launcher {
    public static void main(String[] args) {

        Clothing legSlotItem = new Pants("nudie", Season.FALL, 100);
        System.out.println("Nudie price: " + legSlotItem.getPrice());

        legSlotItem.setDiscountStrategy(new WinterDiscountStrategy());
        System.out.println("Nudie price: " + legSlotItem.getPrice());

        legSlotItem.setDiscountStrategy(new BlackFridayDiscountStrategy());
        System.out.println("Nudie price: " + legSlotItem.getPrice());

        Clothing chestSlotItem = new Jacket("Barbour", Season.FALL, 100);
        chestSlotItem.setDiscountStrategy(new WinterDiscountStrategy());
        System.out.println("Barbour fall jacket: " + chestSlotItem.getPrice());

    }
}
