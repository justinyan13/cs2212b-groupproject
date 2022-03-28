import java.util.ArrayList;

public class TradingStrategy {
    private String[] strategyName;
    private Coin[] coins;

    private static TradingStrategy instance = null;


    private TradingStrategy(TradingBroker broker) {
        this.strategyName = null;
        this.coins = broker.getCoinList();
    }

    public static TradingStrategy getInstance() {
        if(instance == null){
            // If no instance exists, create new one
            instance = new TradingStrategy();
        }

        return instance;
    }



    public TradeResult strategyA(){

        //Create new coin object for both Shiba & Ripple
        // If Shiba > 0.0020 &  XRP Ripple < 0.89
            //Buy 12 ETH

        return TradeResult(




    }

    public TradeResult strategyB(){

    }

    public TradeResult strategyC(){

    }

    public TradeResult strategyD(){

    }

}
