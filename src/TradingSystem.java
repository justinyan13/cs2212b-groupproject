import java.util.ArrayList;

/**
 * @author Justin Yan & Owen Roseborough
 * Executes trade requests of all the brokers
 */




public class TradingSystem {
    private static TradingSystem instance = null;
    private ArrayList<TradingBroker> listOfBrokers = new ArrayList<TradingBroker>();
    private ArrayList<TradeResult> listOfResults = new ArrayList<TradeResult>();


    private TradingSystem() {
        this.listOfBrokers = null;
        this.listOfResults = null;
    }

    public static TradingSystem getInstance() {
        if(instance == null){
            // If no instance exists, create new one
            instance = new TradingSystem();
        }

        return instance;
    }

    /**
     * This method creates a trading broker object with the specificed paramaters
     * @param name
     * @param strategyName The name of the strategy
     * @param coinList
     */
    public void createTradingBroker(String name,  String strategyName, String[] coinList) {
        Coin[] secondList = new Coin[coinList.length];

        for (int i = 0; i < coinList.length; i++) {
            secondList[i] = new Coin(name, 5.45); // Create new coin object with given paramaters
            //TODO Change 5.45 default price coin value
        }
        listOfBrokers.add(new TradingBroker(name, strategyName, secondList));
    }

    /**
     * Removes specified broker from list
     * @param name the name of broker to delete
     */

    public void deleteTradingBroker(String name){
        int counter = 0;
        for(TradingBroker broker : listOfBrokers){
            if(broker.getName().equals(name)){
                listOfBrokers.remove(counter);
            }
            counter++;
        }
    }

    public void editTradingBroker(String name,  String strategyName, String[] coinList){

        Coin[] thirdList = new Coin[coinList.length];

        for (int i = 0; i < coinList.length; i++) {
            thirdList[i] = new Coin(name, 5.45); // Create new coin object with given paramaters
            //TODO Change 5.45 default price coin value
        }

        for(TradingBroker broker : listOfBrokers){
            if(broker.getName().equals(name)){
                broker.setStrategyName(strategyName);
                broker.setCoinList(thirdList);
            }
        }
    }


    public void generateTradeResults(){
        //Iterate each elem of broker list
        //Check if neccessary strategy coins are also known by broker
            //Indicate fail if unmet criteria
        //Use infogetter to acquire CoinGecko prices
        //Utilize prices to execute the strategy
            //Return the buy/sell/no trade path
            //Provide the details of the trade[quantity, coin name, etc]
                //Add TradeREsult object to list
    }

    public ArrayList<TradingBroker> getListOfBrokers() {
        return listOfBrokers;
    }

    public ArrayList<TradeResult>  getListOfResults() {
        return listOfResults;
    }





}
