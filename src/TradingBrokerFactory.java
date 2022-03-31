public class TradingBrokerFactory extends Factory{
    private static TradingBrokerFactory instance = null;


    public static TradingBrokerFactory getInstance() {
        if(instance == null){
            // If no instance exists, create new one
            instance = new TradingBrokerFactory();
        }

        return instance;
    }

    public Product createBroker(String name, String strategyName, Coin[] coinList) {
        return new TradingBroker(name, strategyName, coinList);
    }
    @Override
    public Product createTradeResult() {
        return null;
    }


}
