package discount;

import clothingstore.Clothing;

public interface DiscountStrategy {

    double priceByDiscount(Clothing clothing);

}