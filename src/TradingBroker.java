public class TradingBroker extends Product {
    private String name;
    private String strategyName;
    private Coin[] coinList;

    public TradingBroker(String name, String strategyName, Coin[] coinList){
        this.name = name;
        this.strategyName = strategyName;
        this.coinList = coinList;
    }

    public String getName(){ // getter method
        return name;
    }

    public String getStrategyName() {// getter method
        return strategyName;
    }

    public Coin[] getCoinList() {// getter method
        return coinList;
    }

    public void setCoinList(Coin[] coinList) {// setter method
        this.coinList = coinList;
    }

    public void setStrategyName(String strategyName) {// setter method
        this.strategyName = strategyName;
    }
}
