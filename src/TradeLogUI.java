import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TradeLogUI extends JFrame {
	
	private static TradeLogUI instance = null;
	
	JTable tradeLogTable;
	DefaultTableModel model;
	
	String[] columnNames = {"Trader", "Strategy", "CryptoCoin", "Action", "Quantity", "Price", "Date"};
	Object[][] data = {{}};
	
	private TradeLogUI() {
		
		this.setTitle("Trader Actions");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(700, 400));
		this.setLocation(0, 0);
		this.setVisible(true);
		
	}
	
	public void display() {
		
		model = new DefaultTableModel(data, columnNames);
		tradeLogTable = new JTable(model);
		tradeLogTable.setBounds(0, 0, 700, 400);
		tradeLogTable.setFillsViewportHeight(true);
		tradeLogTable.setGridColor(Color.black);
		tradeLogTable.setShowGrid(true);
		
		add(new JScrollPane(tradeLogTable));
		this.validate();
	}
	
	public static TradeLogUI getInstance() {
		
		if (instance == null) {
			instance = new TradeLogUI();
		}
		return instance;
		
	}
	
}
