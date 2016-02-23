package proj4fa15;

import java.text.DecimalFormat;

/**
 * <p>Title: Portfolio.java</p> 
 * <p>Description: Creates an ArrayUnorderedList that can store the address of Stock objects.
 * 					Contains a parameterized constructor that initializes the instance variables
 * 					and stores the reference of the list containing symbol data in one of the 
 * 					instance variables. processTransaction method receives info about the stock and 
 * 					whether to buy or sell stocks and processes transaction accordingly.</p>
 *
 * @author Saad Ahmad
 */

public class Portfolio
{
	//instance variables
	private  ArrayUnorderedList<Stock> stocks;
	private SymbolTable symbols;
	private double gainLoss;

	/**
	 * Parameterized constructor -- 
	 * Initializes the instance variables to defaults and 
	 * stores the reference to symbol data received
	 * in argument in symbols.
	 * 
	 * @param symTbl
	 *            - store the reference to a SymbolTable object
	 */
	public Portfolio(SymbolTable symTbl)
	{
		stocks = new ArrayUnorderedList<Stock> ();
		symbols = symTbl;
		gainLoss = 0;
	}

	/**
	 * processTransaction method -- 
	 * processes buying or selling of stocks based on the arguments received
	 * 
	 * @param action
	 * 			  - stores the character telling whether to buy or sell stocks
	 * @param quantity
	 * 			  - stores the number of shares to be bought or sold
	 * @param price
	 * 			  - stores the per share price
	 * @param ticker
	 * 			  - stores the ticker symbol of the stock
	 * @throws InvalidSaleException
	 * 			  - Portfolio empty - if there are no stocks in the portfolio and user wants to sell
	 * @throws InvalidSaleException
	 * 			  - Insufficient shares to sell - if shares to be sold are more than available shares
	 */
	public void processTransaction(char action, int quantity, double price, String ticker)
	{
		if (action == 'b')
		{
			stocks.addToRear(new Stock(quantity, price, ticker));
		}
		else 
		{
			if (stocks.size() == 0)
				throw new InvalidSaleException("Portfolio Empty");

			//counting number of shares owned of that company
			int totalShares = 0;
			for (int i = 0; i < stocks.size(); i++)
			{
				if (stocks.get(i).getTickerSymbol().equals(ticker))
					totalShares += stocks.get(i).getSharesOwned();
			}

			if (quantity > totalShares)
				throw new InvalidSaleException("Insufficient shares to sell");

			int tempQuantity = quantity;
			for (int i = 0; i < stocks.size() && tempQuantity != 0; i++)
			{
				Stock tempStock = stocks.get(i);
				if (tempStock.getTickerSymbol().equals(ticker))
					if(tempQuantity >= tempStock.getSharesOwned())
					{
						tempQuantity -= tempStock.getSharesOwned();
						gainLoss += (tempStock.getSharesOwned())*(price - tempStock.getPurchasePrice());
						stocks.remove(tempStock);
						i--;	//compensating for shifting of array due to removing
					}
					else if (tempQuantity < tempStock.getSharesOwned())
					{
						gainLoss += (tempQuantity)*(price - tempStock.getPurchasePrice());
						tempStock.setSharesOwned(tempStock.getSharesOwned() - tempQuantity);
						tempQuantity = 0;
					}
			}
		}
	}

	/**
	 * toString method --
	 * returns a string containing the state of the portfolio
	 * 
	 * @return a string containing the current state of the portfolio
	 */
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("$#,###,##0.00");
		String str = "";
		for (int i = 0; i < stocks.size(); i++)
		{
			String temp[] = stocks.get(i).toString().split(" ", 3);
			str += symbols.findCompany(stocks.get(i).getTickerSymbol()) + "\n" + temp[2] + "\n";
		}
		return str + "\nProfit: " + df.format(gainLoss);
	}
}
