package discount;

import clothingstore.Clothing;
import clothingstore.Jacket;
import clothingstore.Socks;

public class BlackFridayDiscountStrategy implements DiscountStrategy{

    @Override
    public double priceByDiscount(Clothing clothing) {
        if (clothing instanceof Jacket) {
            return clothing.getBasePrice() * 0.9;
        }
        if (clothing instanceof Socks) {
            return clothing.getBasePrice() * 0.8;
        } else {
            return clothing.getBasePrice() * 0.75;
        }
    }
}
