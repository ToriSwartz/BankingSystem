/*************************************************************************
Author: Victoria Swartz, Prof: Tao, Date: 11/16/2015. Project #4
This the parent to all Express Accounts.
*************************************************************************/
import java.text.DecimalFormat;
public class ExpressAccount{
	protected int accountNumber;
	protected int numberOfMeals;
	protected double accountBalance;
	protected double baseAmtForBonus;
	protected double pricePerMeal;
	protected String accountTypeName;
	//constructor non-default
	public ExpressAccount(int acctNum){
		accountNumber=acctNum;
		numberOfMeals=0;
		accountBalance=0;
		baseAmtForBonus=0;
		pricePerMeal=0;
		accountTypeName="Express Account";	
	}
	//get methods
	public int getAccountNumber(){
		return accountNumber;
	}
	public int getNumberOfMeals(){
		return numberOfMeals;
	}
	public double getAccountBalance(){
		return accountBalance;
	}
	public double getBaseAmtForBonus(){
		return baseAmtForBonus;
	}
	public double getPricePerMeal(){
		return pricePerMeal;
	}
	public String getAccountTypeName(){
		return accountTypeName;
	}
	//set methods
	public void setAccountNumber(int num){
		if(num>=0){
			accountNumber=num;
		}
	}
	public void setNumberOfMeals(int num){
		if(num>=0){
			numberOfMeals=num;
		}
	}
	public void setBaseAmtForBonus(double num){
		if(num>=0){
			baseAmtForBonus= formatNum(num);
		}
	}
	public void setAccountBalance(double num){
		if(num>=0){
			accountBalance= formatNum(num);
		}
	}
	public void setPricePerMeal(double num){
		
		if(num>=0){
			pricePerMeal=formatNum(num);
		}
	}
	public void setAccountTypeName(String name){
		accountTypeName=name;
	}
	//deposit method. Need to ask about amtForBonus because it is not included currently.
	public void deposit(double amount){
		if(amount>=0){
			accountBalance= accountBalance+ formatNum(amount);
		}
	}
	//Buy a meal method. Subtracts one meal from numberOfMeals var every time it is used.
	// It also reduces the total balance of the account when a meal is purchased. 
	public void buyMeal(){
		if(accountBalance-pricePerMeal>0){
			numberOfMeals= numberOfMeals+1;
			accountBalance=accountBalance-pricePerMeal;
		}
	}
	//override toStringMethod
	public String toString(){
		return "Account Type:"+ accountTypeName+ "\nAccount Number:"+accountNumber+"\nBalance:"+accountBalance+"\nMeals Left:"+numberOfMeals+
		"\nAmount For Bonus:"+baseAmtForBonus+"\nSet Price Per Meal:"+pricePerMeal;
	}
	public double formatNum(double num){
		DecimalFormat fmt = new DecimalFormat("0.##");
		return Double.parseDouble(fmt.format(num));
	}
	
}