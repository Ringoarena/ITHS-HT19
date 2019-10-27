package discount;

import clothingstore.Clothing;
import enumcollections.Season;

public class SummerDiscountStrategy implements DiscountStrategy {
    @Override

    public double priceByDiscount(Clothing clothing) {

        if (clothing.getSeason().equals(Season.SUMMER)) {
            return clothing.getBasePrice() * 0.5;
        }

        if (clothing.getSeason().equals(Season.WINTER)) {
            return clothing.getBasePrice() * 0.7;
        }

        if (clothing.getSeason().equals(Season.SPRING)) {
            return clothing.getBasePrice() * 0.6;
        }

        return clothing.getBasePrice();
    }
}
