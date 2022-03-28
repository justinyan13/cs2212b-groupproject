public abstract class Factory {
    public abstract Product createBroker(String name, String strategyName, Coin[] coinList);

    public abstract Product createTradeResult();






}
