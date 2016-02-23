package proj4fa15;

import java.text.DecimalFormat;

/**
 * <p>Title: Stock.java</p> 
 * <p>Description: Creates an ArrayUnorderedList
 * 					that can store address of SymbolPair objects. </p>
 *
 * @author Saad Ahmad
 */

public class Stock
{
	//instance variables
	private String tickerSym;
	private int sharesOwned;
	private double purchasePrice;

	/**
	 * Parameterized constructor -- 
	 * initializes the instance variables to the values received in argument
	 * 
	 * @param numShares
	 *            - stores the number of shares being bought
	 * @param price
	 * 			  - stores the price per share of the stock
	 * @param symbol
	 * 			  - stores the ticker symbol of the stock
	 */
	public Stock(int numShares, double price, String symbol)
	{
		sharesOwned = numShares;
		purchasePrice = price;
		tickerSym = symbol;
	}

	/**
	 * getTickerSymbol method --
	 * returns the tickerSymbol of the stock
	 * 
	 * @return the ticker symbol stored in tickerSym
	 */
	public String getTickerSymbol()
	{
		return tickerSym;
	}

	/**
	 * getSharesOwned method --
	 * returns the number of shares owned of the stock
	 * 
	 * @return the int stored in sharesOwned
	 */
	public int getSharesOwned()
	{
		return sharesOwned;
	}

	/**
	 * getPurchasePrice method --
	 * returns the purchase price per share of the stock
	 * 
	 * @return the double stored in purchasePrice
	 */
	public double getPurchasePrice()
	{
		return purchasePrice;
	}

	/**
	 * setSharesOwned method --
	 * stores the number of shares received in argument in instance variable
	 * 
	 * @param num - stores the number of shares
	 */
	public void setSharesOwned(int num)
	{
		sharesOwned = num;
	}

	/**
	 * toString method --
	 * returns a string containing the state of the stock
	 * 
	 * @return - a string containing state of the stock
	 */
	public String toString()
	{
		DecimalFormat df = new DecimalFormat("$#,###,##0.00");
		return "Ticker: " + tickerSym + "\t Shares Owned: " + sharesOwned + "\tPurchase Price: "
				+ (df.format(purchasePrice));
	}
}
