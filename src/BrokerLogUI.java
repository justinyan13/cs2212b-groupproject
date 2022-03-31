import java.awt.*;


import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Benjamin Oliveria and Arpit Dang
 * 
 * This class will create and display a table in which the user can enter a Trading Broker's name, coin list and 
 * strategy in which they will use
 *
 */
public class BrokerLogUI extends JFrame implements ActionListener {

	/**
	 * This variable will help ensure only one instance of this BrokerLogUI class is created per execution of the program
	 */
	private static BrokerLogUI instance = null;
	
	/**
	 * This variable will represent the table in which the log of trading brokers and all of their information
	 * will be held
	 */
	JTable brokerLogTable;
	
	/**
	 * This variable will allow us to add or delete rows from the table itself as well as be the parameter
	 * when constructing the JTable brokerLogTable
	 */
	DefaultTableModel model;
	
	/**
	 * A title for the table
	 */
	JLabel titleLabel = new JLabel("Trading Client Actions");
	
	/**
	 * This button will add a new empty row to the table for the user to input data into
	 */
	JButton addRowButton = new JButton("Add Row");
	
	/**
	 * This button will remove the highlighted row when clicked
	 */
	JButton deleteRowButton = new JButton("Delete Row");
	
	/**
	 * This button when pressed will go through the current state of the brokerLogTable and then store all of the
	 * data into the allData variable
	 */
	JButton performTradeButton = new JButton("Perform Trade");
	
	/**
	 * These are simply the names of the strategy names
	 */
	String[] stratNames = {"Strategy A", "Strategy B", "Strategy C", "Strategy D"};
	
	/**
	 * This will generate a drop down menu listing all of the strategy names the user/broker may use
	 */
	JComboBox<String> dropDown = new JComboBox<>(stratNames);
	
	/**
	 * The table only has three columns, one for the broker's name, the list of coins they are interested in and 
	 * the strategy they will use when performing a trade
	 */
	String[] columnNames = {"Trading Broker", "Coin List", "Strategy Name"};
	
	/**
	 * This will store and keep track of all of the user's inputed data from the table
	 */
	Object[][] data = {{}};
	
	/**
	 * This variable will store all of the data in whatever state the table is in once the user has pressed the 
	 * "Perform Trade" button
	 */
	String[][] allData;


	/**
	 * The constructor for this method will simply set up the JFrame in which the table and buttons will be displayed on
	 */
	private BrokerLogUI() {
		
		this.setTitle("Trading Client Actions");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(740, 900));
		this.setLocation(600, 0);
		this.setVisible(true);
		
	}
	
	/**
	 * This method is responsible for adding the buttons to the JFrame as well as setting up the visual parameters
	 * for the brokerLogTable
	 */
	public void display() {
		
		addRowButton.setBounds(250, 550, 100, 25);
		addRowButton.addActionListener(this);
		
		deleteRowButton.setBounds(450, 550, 100, 25);
		deleteRowButton.addActionListener(this);
		
		performTradeButton.setBounds(305, 600, 200, 25);
		performTradeButton.addActionListener(this);
		
		model = new DefaultTableModel(data, columnNames);
		model.removeRow(0);							

		
		brokerLogTable = new JTable(model);
		brokerLogTable.setBounds(0, 0, 700, 500);
		brokerLogTable.setFillsViewportHeight(true);
		brokerLogTable.setGridColor(Color.black);
		brokerLogTable.setShowGrid(true);
		brokerLogTable.getColumn("Strategy Name").setCellEditor(new DefaultCellEditor(dropDown));
		
		this.add(addRowButton);
		this.add(deleteRowButton);
		this.add(performTradeButton);
		
		
		add(new JScrollPane(brokerLogTable));
		this.validate();
		
	}
	
	/**
	 *This method will contain all the code/instructions for what each button should do when they are pressed 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == addRowButton) {
			model.addRow(new Object[]{});
		}
		
		if (e.getSource() == deleteRowButton) {
			if (brokerLogTable.getSelectedRow() != -1) {
				model.removeRow(brokerLogTable.getSelectedRow());
			}							
		}
		
		if (e.getSource() == performTradeButton) {

			
			allData = new String[model.getRowCount()][3];
			
			for (int i = 0; i < model.getRowCount(); i++) {
				for (int j = 0; j < 3; j++) {
					allData[i][j] = (String) model.getValueAt(i, j);
				}
			}

			TradingSystem tradingSystem = TradingSystem.getInstance();
			for (int i = 0; i < model.getRowCount(); i++) {
				String name = allData[i][0];
				String coins = allData[i][1];
				coins = coins.replaceAll(" ", "");
				String[] coinList = coins.split(",");
				String stratName = allData[i][2];
				tradingSystem.createTradingBroker(name,  stratName, coinList);
			}

//			ArrayList<TradingBroker> test = tradingSystem.getListOfBrokers();
//			for (TradingBroker brokerIterator: test) {
//				System.out.print(brokerIterator.getName() + " ");
//				System.out.print(brokerIterator.getStrategyName() + " ");
//				for(Coin iterator: brokerIterator.getCoinList()){
//					System.out.print(iterator.getCoinName() + " ");
//				}
//				System.out.println();
//			}




			
			TradeLogUI tradeLog = TradeLogUI.getInstance();
			tradeLog.display();
			
			//TODO: Send allData to wherever it needs to go 
		
		}
		
	}
	
	/**
	 * @return All the data (Broker's name, list of coins, and strategy they are using) in the current state of the
	 * brokerLogTable
	 */
	public String[][] getLogData() {
		return this.allData;
	}
	
	/**
	 * This method will create an instance of a BrokerLogUI object which can then be stored to any varibale that 
	 * invokes this method 
	 * @return An object of type BrokerLogUI 
	 */
	public static BrokerLogUI getInstance() {
		
		if (instance == null) {
			instance = new BrokerLogUI();
		}
		return instance;
		
	}
	
}
