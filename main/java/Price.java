public class Price {
    private double price;
    private double specialPrice;
    private int specialPriceNumber;

    public Price(double price, double specialPrice, int specialPriceNumber) throws Exception {
        if(price <= 0) {
            throw new Exception("Price must be > 0");
        }
        else if(specialPrice < 0) {
            throw new Exception("Special price must be >= 0");
        }
        else if(specialPrice > 0 && specialPriceNumber < 1) {
            throw new Exception("Special price number must be > 1");
        }
        else {
            this.price = price;
            this.specialPrice = specialPrice;
            this.specialPriceNumber = specialPriceNumber;
        }
    }

    public double getPrice() {
        return price;
    }

    public double getSpecialPrice() {
        return specialPrice;
    }

    public int getSpecialPriceNumber() {
        return specialPriceNumber;
    }
}
