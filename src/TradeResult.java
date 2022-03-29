/**
 * @author Justin and Owen
 * Reciept of trading action.
 * Indicates success or failure
 * Indicates the details of the action
 */


public class TradeResult {
    private TradingBroker broker;
    private String action;
    private Boolean success;
    private int quantityOfCoins;
    private double price;
    private String date;
    private String coin; // Coin name
    //private String name;
    private String strategyName;


    /**
     *Constructor method
     * @param person
     * @param success
     * @param action
     * @param quantity
     */
    public TradeResult(TradingBroker person, Boolean success, String action, int quantity,String date, String coin, String strategyName) {
        this.broker = person;
        this.success = success;
        this.action = action;
        this.quantityOfCoins = quantity;
        this.date = date;
        this.coin = coin;
        this.strategyName = strategyName;
    }

    /**
     *Getter method for  action string
     * @return Indicates if action taken was a buy, sell, or failure
     */

    public String getAction() {
        return this.action;
    }

    /**
     *Getter method for  success string
     * @return Indicates if trade was a success or failure
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     *Getter method for quantity of coins purchased or sold
     * @return  Total number of coins involved in the trade
     */
    public int getQuantityOfCoins() {
        return quantityOfCoins;
    }

    /**
     *Getter method for the coin traded
     * @return The coin involved the trade
     */
    public double getPrice() {
        return price;
    }

    /**
     *Getter method for the date
     * @return Date of trade execution
     */
    public String getDate() {
        return date;
    }

    /**
     *Getter method for the name of the coin traded
     * @return The name of the coin involved in trade
     */
    public String getCoin() {
        return coin;
    }

    /**
     *Getter method for the strategy
     * @return The strategy that the broker has chosen
     */
    public String getStrategyName() {
        return strategyName;
    }
}
