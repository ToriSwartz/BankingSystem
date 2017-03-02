/*************************************************************************
Author: Victoria Swartz, Prof: Tao, Date: 11/16/2015. Project #4
Falculty account is the child of Express Account. It has the additional
variable rewardPct.
*************************************************************************/
public class FacultyExpressAccount extends ExpressAccount{
	private double rewardPct;//percentage of deposit that will become the bonus 0 to 
	public FacultyExpressAccount(int acctNum){
		super(acctNum);
		rewardPct=.01;
		this.setAccountTypeName("Faculty Express account");
		this.setPricePerMeal(8.00);
	}
	public double getRewardPct(){
		return rewardPct;
	}
	public void setRewardPct(double num){
		if(num>=0 && num<=100){
			rewardPct= formatNum(num);
		}
	}
	@Override
	public void deposit(double amount){
		if(amount==0){
			accountBalance=accountBalance;
		}
		if(amount>0){
			amount=formatNum(amount);
			baseAmtForBonus = formatNum(amount/100);
			accountBalance= formatNum(accountBalance+amount+baseAmtForBonus);
		}
	}
	public String toString(){
		return "Account Type:"+ accountTypeName+ "\nAccount Number:"+accountNumber+"\nBalance:"+accountBalance+"\nMeals Left:"+numberOfMeals+
		"\nAmount For Bonus:"+baseAmtForBonus+"\nSet Price Per Meal:"+pricePerMeal+"\nReward Percentage: "+rewardPct;
	}
}