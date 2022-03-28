public class TradingBrokerFactory extends Factory{

    public Product createBroker(String name, String strategyName, Coin[] coinList) {
        return new TradingBroker(name, strategyName, coinList);
    }
    @Override
    public Product createTradeResult() {
        return null;
    }
}
