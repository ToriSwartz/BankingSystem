/*************************************************************************
Author: Victoria Swartz, Prof: Tao, Date: 11/16/2015. Project #4
Student account is the child of ExpressAccount. It has a rewardLevel
and a rewardAmount variable in addition to the other ones.
*************************************************************************/
public class StudentExpressAccount extends ExpressAccount{
	private double rewardLevel;
	private double rewardAmount;

	public StudentExpressAccount(int acctNum){
		super(acctNum);
		rewardLevel=200.0;
		rewardAmount=2.0;
		this.setAccountTypeName("Student Express account");
		this.setPricePerMeal(10.00);
	}
	public double getRewardLevel(){
		return rewardLevel;
	}
	public double getRewardAmount(){
		return rewardAmount;
	}
	@Override
	public void deposit(double amount){
		if(amount==0){
			accountBalance=accountBalance;
		}
		if(amount>0){
			amount=formatNum(amount);
			int lvl = (int)(amount/rewardLevel);
			accountBalance= accountBalance+amount+(lvl*rewardAmount);
		}
	}
	@Override
	public String toString(){
		return "Account Type:"+ accountTypeName+ "\nAccount Number:"+accountNumber+"\nBalance:"+accountBalance+"\nMeals Left:"+numberOfMeals+
		"\nAmount For Bonus:"+baseAmtForBonus+"\nSet Price Per Meal:"+pricePerMeal+"\nReward Amount: "+rewardAmount+"\nReward Level: "+rewardLevel;
	}


}