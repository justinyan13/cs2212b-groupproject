public class Coin {
    private String name;
    private double price;

    public Coin(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getCoinName(){
        return name;
    }

    public double getCoinPrice() {
        return price;
    }

    public void editCoinPrice(double price) {
        this.price = price;
    }
}
