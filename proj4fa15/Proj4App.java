package proj4fa15;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * <p>Title: Proj4App.java</p> 
 * <p>Description: Creates a SymbolTable object and a Portfolio Object.
 * 					Reads transaction data from the stockdata file, one
 * 					transaction at a time and process the transaction using
 * 					the processTransaction method in the Portfolio class.
 * 					Displays the portfolio before and after transaction.
 * 					Displays appropriate error message if an error occurs.</p>
 *
 * @author Saad Ahmad
 */

public class Proj4App
{
	public static void main(String[] args) throws FileNotFoundException
	{
		File symbolDataFile = new File("symboldata.txt");
		File stockDataFile = new File("stockdata.txt");
		SymbolTable symbolData = new SymbolTable(symbolDataFile);

		Portfolio myPortfolio = new Portfolio(symbolData);
		Scanner stockScan = new Scanner(stockDataFile);
		String[] splitLine;

		DecimalFormat df = new DecimalFormat("$#,###,##0.00");

		while (stockScan.hasNextLine())
		{
			System.out.println("*************New Transaction************\n\n"
					+ "Pre-Transaction Portfolio:\n\n" + myPortfolio.toString());

			splitLine = stockScan.nextLine().split(" ", 4);

			char action = splitLine[0].charAt(0);
			int quantity = Integer.parseInt(splitLine[1]);
			double price = Double.parseDouble(splitLine[2]);
			String ticker = splitLine[3];

			if (action == 'b')
			{
				System.out.println("\n+--------------BUY----------------+\n"
						+ symbolData.findCompany(ticker) + "\nPer share price: "
						+ df.format(price) + "\nShares to be bought: " + quantity + "\n"
						+ "+---------------------------------+\n");
			} 
			else
			{
				System.out.println("\n+-------------SELL----------------+\n"
						+ symbolData.findCompany(ticker) + "\nPer share price: "
						+ df.format(price) + "\nShares to be sold: " + quantity + "\n"
						+ "+---------------------------------+\n");
			}

			try
			{
				myPortfolio.processTransaction(action, quantity, price, ticker);
			} 
			catch (InvalidSaleException ex)
			{
				System.out.println(ex.getMessage());
			}

			System.out.println("\nPost-Transaction Portfolio:\n\n" + myPortfolio.toString()
					+ "\n|-|-|-|-|-|-|-Transaction Complete|-|-|-|-|-|-|-|\n");
		}
		stockScan.close();
	}
}
