import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TradingStrategy {
    private String[] strategyName;
    private Coin[] coins;
    private DateTimeFormatter dtf;
    private LocalDateTime now;

    private static TradingStrategy instance = null;


    private TradingStrategy() {
        this.strategyName = null;

        this.dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    }

    public static TradingStrategy getInstance() {
        if(instance == null){
            // If no instance exists, create new one
            instance = new TradingStrategy();
        }

        return instance;
    }



    public TradeResult strategyA(TradingBroker currentBroker){
        this.now = LocalDateTime.now();

        String currTime = dtf.format(now);

        for(Coin coin: currentBroker.getCoinList()){


            if(coin.getCoinName().equals("ETH")){
                //TODO Replace $5.45 with API Price Call
                Coin SHIB = new Coin("SHIB", 5.45);
                Coin XRP = new Coin("XRP", 5.45);

                if(SHIB.getCoinPrice() >  0.0020 && XRP.getCoinPrice() < 0.89);{


                    TradeResult newResult = new TradeResult(currentBroker, true, "Buy", 12, currTime, "ETH", "Strategy A"); //Buy 12 ETH if criteria are met
                    return newResult;
                }
            }
        }

        return new TradeResult(currentBroker, false, "Fail", 0, currTime, "ETH", "Strategy A");
    }

    public TradeResult strategyB(TradingBroker currentBroker){ //Revise name
        this.now = LocalDateTime.now();

        String currTime = dtf.format(now);

        for(Coin coin: currentBroker.getCoinList()){


            if(coin.getCoinName().equals("ADA")){//Revise name
                //TODO Replace $5.45 with API Price Call
                Coin USDC = new Coin("USDC", 5.45);//Revise name
                Coin LUNA = new Coin("LUNA", 5.45);//Revise name

                if(USDC.getCoinPrice() >  0.988 && LUNA.getCoinPrice() < 107.1);{//Revise name


                    TradeResult newResult = new TradeResult(currentBroker, true, "sell", 5, currTime, "ADA", "Strategy B"); //Revise name
                    return newResult;
                }
            }
        }

        return new TradeResult(currentBroker, false, "Fail", 0, currTime, "ADA", "Strategy B");//Revise name
    }

    public TradeResult strategyC(TradingBroker currentBroker){ //Revise name
        this.now = LocalDateTime.now();

        String currTime = dtf.format(now);

        for(Coin coin: currentBroker.getCoinList()){


            if(coin.getCoinName().equals("SOL")){//Revise name
                //TODO Replace $5.45 with API Price Call
                Coin AVAX = new Coin("AVAX", 5.45);//Revise name
                Coin DOT = new Coin("DOT", 5.45);//Revise name

                if(AVAX.getCoinPrice() >  92.96 && DOT.getCoinPrice() < 22.47);{//Revise name


                    TradeResult newResult = new TradeResult(currentBroker, true, "sell", 7, currTime, "SOL", "Strategy C"); //Revise name
                    return newResult;
                }
            }
        }

        return new TradeResult(currentBroker, false, "Fail", 0, currTime, "SOL", "Strategy C");//Revise name
    }

    public TradeResult strategyD(TradingBroker currentBroker){ //Revise name
        this.now = LocalDateTime.now();

        String currTime = dtf.format(now);

        for(Coin coin: currentBroker.getCoinList()){


            if(coin.getCoinName().equals("MATIC")){//Revise name
                //TODO Replace $5.45 with API Price Call
                Coin CRO = new Coin("CRO", 5.45);//Revise name
                Coin DAI = new Coin("DAI", 5.45);//Revise name

                if(CRO.getCoinPrice() >  .49 && DAI.getCoinPrice() < 0.97);{//Revise name


                    TradeResult newResult = new TradeResult(currentBroker, true, "sell", 1032, currTime, "MATIC", "Strategy D"); //Revise name
                    return newResult;
                }
            }
        }

        return new TradeResult(currentBroker, false, "Fail", 0, currTime, "MATIC", "Strategy D");//Revise name
    }
    }
