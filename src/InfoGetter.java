import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class InfoGetter {
    private static InfoGetter instance = null;

    private InfoGetter() {
    }

    public static InfoGetter getInstance() {
        if(instance == null){
            // If no instance exists, create new one
            instance = new InfoGetter();
        }

        return instance;
    }

    public double getCoinPrice(String coinName){
        String fullCoinName;
        try {

            File coinAbbreviationDatabase = new File("coinAbbreviation.txt");
            Scanner coinReader = new Scanner(coinAbbreviationDatabase);

            while (coinReader.hasNextLine()) {

                String currentLine = coinReader.nextLine();
                String[] coinAbbArray = currentLine.split(" ");

                if (coinName.equals(coinAbbArray[0])) {
                    fullCoinName = coinAbbArray[1];
                }
            }
        } catch (FileNotFoundException e) {

            System.out.println("File not found.");
        }





        //return CoinGecko.getpriceof(fullName)
    }

}
