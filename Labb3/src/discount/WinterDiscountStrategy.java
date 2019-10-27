package discount;

import clothingstore.Clothing;
import clothingstore.Jacket;
import enumcollections.Season;

public class WinterDiscountStrategy implements DiscountStrategy {

    @Override
    public double priceByDiscount(Clothing clothing) {
        double discount = 1;

        if (clothing.getSeason().equals(Season.FALL)) {
            discount -= 0.4;
        } else if (clothing.getSeason().equals(Season.WINTER)) {
            discount -= 0.5;
        } else if (clothing.getSeason().equals(Season.SUMMER)) {
            discount -= 0.25;
        }

        if (clothing instanceof Jacket) {
            discount -= 0.1;
        }

        return clothing.getBasePrice() * discount;
    }

//    @Override
//    public double priceByDiscount(Clothing clothing) {
//        double newPrice = clothing.getBasePrice();
//
//        if (clothing.getSeason().equals(Season.FALL)) {
//            newPrice = newPrice * 0.6;
//        } else if (clothing.getSeason().equals(Season.WINTER)) {
//            newPrice = newPrice * 0.5;
//        } else if (clothing.getSeason().equals(Season.SUMMER)) {
//            newPrice = newPrice * 0.75;
//        }
//
//        if (clothing instanceof Jacket) {
//            newPrice = newPrice * 0.9;
//        }
//
//        return newPrice;
//    }
}
