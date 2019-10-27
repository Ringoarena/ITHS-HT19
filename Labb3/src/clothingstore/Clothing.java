package clothingstore;

import discount.DiscountStrategy;
import enumcollections.Season;

public abstract class Clothing {

    private String name;
    private Season season;
    private double basePrice;
    private double finalPrice;
    private boolean status=false;

    public Clothing(String name, Season season, Double basePrice) {
        this.setName(name);
        this.setSeason(season);
        this.setBasePrice(basePrice);
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        finalPrice = discountStrategy.priceByDiscount(this);
        this.status = true;
    }

    public double getPrice() {
        if (status) {
            return finalPrice;
        } else {
            return basePrice;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Season getSeason() {
        return season;
    }

    public void setSeason(Season season) {
        this.season = season;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
