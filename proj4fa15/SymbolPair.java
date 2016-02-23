package proj4fa15;

/**
 * <p>Title: SymbolPair.java</p> 
 * <p>Description: Stores the name of a company and its ticker symbol. 
 * 					Also contains accessor methods to return the ticker
 * 					symbol and company name stored in the instance variables.</p>
 *
 * @author Saad Ahmad
 */

public class SymbolPair
{
	// instance variables
	private String tickerSym;
	private String companyName;

	/**
	 * Parameterized constructor -- Initializes the instance variables with the
	 * value received as argument
	 * 
	 * @param symbol - stores the ticker symbol to be stored in the instance
	 *            variable
	 * @param cName - stores the company name to be stores in the instance
	 *            variable
	 */
	public SymbolPair(String symbol, String cName)
	{
		tickerSym = symbol;
		companyName = cName;
	}

	/**
	 * getTickerSymbol method -- Returns the ticker symbol stored in the
	 * instance variable tickerSym
	 * 
	 * @return value stored in tickerSym
	 */
	public String getTickerSymbol()
	{
		return tickerSym;
	}

	/**
	 * getCompanyName method -- Returns the company name stored in the instance
	 * variable companyName
	 * 
	 * @return value stored in tickerSym
	 */
	public String getCompanyName()
	{
		return companyName;
	}
}
