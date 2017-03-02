/*************************************************************************
Author: Victoria Swartz, Prof: Tao, Date: 11/16/2015. Project #4
Class is an application for the other three classes. Creates a banking
system in which multiple accounts can be managed.
*************************************************************************/
import java.util.*;
import java.text.DecimalFormat;
public class ExpAcct{
	private static int safeInputInt(){
		Scanner scan = new Scanner(System.in);
		int input=0;
		while(input<=0){
			try{
			input = scan.nextInt();	
			}
				catch(InputMismatchException error){
					System.out.println("Please enter a integer number");
					System.out.print("Please enter your selection: ");
					scan.nextLine();

			}
		}
		return input;
	}
		private static double safeInputDouble(){
		double input=0;
		Scanner scan = new Scanner(System.in);
		while(input<=0){
			try{
			input = scan.nextDouble();	
			}
				catch(InputMismatchException error){
					System.out.println("Please enter a double number");
					System.out.print("Enter a deposit amount: ");
					scan.nextLine();

			}
		}
		return input;
	}
	

	//prints main menu
	private static void printMainMenu(){
		System.out.println();
		System.out.println("MAIN MENU");
		System.out.println("1.) Create a new account");
		System.out.println("2.) Log into an existing account");
		System.out.println("3.) Exit the banking system");
		System.out.print("Please enter your selection: ");
	}
	//prints create new account meanu
	private static void printCreateAcctMenu(){
		System.out.println();
		System.out.println("CHOOSE THE TYPE FOR THE NEW ACCOUNT");
		System.out.println("1.) Faculty Express Account");
		System.out.println("2.) Student Express Account");
		System.out.print("Please enter your selection: ");
	}
	//prints the modify acccount menu
	private static void printModifyAccount(ExpressAccount x){
		System.out.println();
		acctInfo(x);
		System.out.println("1.) Make a deposit");
		System.out.println("2.) Purchase Meals");
		System.out.println("3.) Have meal");
		System.out.println("4.) Logout");
		System.out.print("Please enter your selection: ");
	}
	//prints account info at top of each modify account menu
	private static void acctInfo(ExpressAccount account){
		String name = account.getAccountTypeName();
		System.out.println(name.toUpperCase()+" #"+account.getAccountNumber()+", BALANCE: $"+account.getAccountBalance()+", NUMBER OF MEALS:"+account.getNumberOfMeals());
	}
	//prints info after a account is created
	private static void createAcctInfo(ExpressAccount account){
		System.out.println("Created new "+account.getAccountTypeName()+" #"+account.getAccountNumber()+", balance: $"+account.getAccountBalance()
			+", number of meals:"+account.getNumberOfMeals());
	}
	//prints info after you log back into an account
	private static void welcomeAcctInfo(ExpressAccount account){
		System.out.println("Welcome back "+account.getAccountTypeName()+" #"+account.getAccountNumber()+", balance: $"+account.getAccountBalance()
			+", number of meals:"+account.getNumberOfMeals());
	}
	//looks to see what next available account number is
	private static int nextAccount(ArrayList <ExpressAccount> array){
		if(array.isEmpty()==true){
			return 0;
		}
		return array.size();
	}
	//makes a deposit to a account
	private static void makeDeposit(ExpressAccount account,double num){
		DecimalFormat fmt = new DecimalFormat("0.##");
		account.deposit(num);
		double bonus =Double.parseDouble(fmt.format(account.getAccountBalance()-num));
		System.out.println("Received bonus of $"+ bonus);
		System.out.println("Deposit $"+num+" New balance $"+account.getAccountBalance());
	}
	//having a meal
	private static void haveMeal(ExpressAccount account){
		account.setNumberOfMeals(account.getNumberOfMeals()-1);
		System.out.println("Thanks!");
	}
	//calculates the max number of meals you can purchase with your balance
	private static int maxMeals(ExpressAccount account){
		double bal = account.getAccountBalance();
		double mealPrice= account.getPricePerMeal();
		return (int)(bal/mealPrice);
	}
	//buy a meal
	private static void buyMeal(ExpressAccount account, int max){
		for(int i=0; i<max;i++){
			account.buyMeal();
		}
		System.out.println("Purchased "+max+" meals with $"+account.getPricePerMeal()+" per meal"+". New balance $"+account.getAccountBalance());
	}
	public static void main (String [] args){
		int input=0;
		int acctNum=0;
		ArrayList <ExpressAccount> acct = new ArrayList <ExpressAccount>();
		//Scanner scan = new Scanner(System.in);
		while(input!=3){
			input=0;
			printMainMenu();
			//input= scan.nextInt();
			input = safeInputInt();

			while(input<1||input>3){
					System.out.println("Invalid input. Must input 1-3.");
					System.out.print("Please enter your selection: ");
					//input = scan.nextInt();
					input = safeInputInt();
			}
			if(input==1){
				printCreateAcctMenu();
				//int input1 = scan.nextInt();
				int input1 = safeInputInt();
				while(input1<1||input1>2){
					System.out.println("Invalid input. Must input 1 or 2.");
					System.out.print("Please enter your selection: ");
					//input1 = scan.nextInt();
					input1 = safeInputInt();
				}
				if(input1==1){
					acctNum=nextAccount(acct);
					FacultyExpressAccount a1= new FacultyExpressAccount(acctNum);
					acct.add(a1);
					createAcctInfo(a1);
					System.out.println();
				}
				if(input1==2){
					acctNum=nextAccount(acct);
					StudentExpressAccount a1= new StudentExpressAccount(acctNum);
					acct.add(a1);
					createAcctInfo(a1);
					System.out.println();
				}
			}
			if(input==2){
				System.out.println();
				System.out.print("Please enter account number: ");
				//acctNum=scan.nextInt();
				acctNum = safeInputInt();
				while(acctNum<0||acctNum>acct.size()-1){
					System.out.println();
					System.out.println("Invalid account number (must be between 0 and "+(acct.size()-1)+")");
					System.out.print("Please enter account number: ");
					//acctNum=scan.nextInt();
					acctNum = safeInputInt();
				}
				welcomeAcctInfo(acct.get(acctNum));
				
			}
			if(input==3){
				System.out.print("Exiting the system");
				break;
			}
			while(input!=4){
				printModifyAccount(acct.get(acctNum));
				//input=scan.nextInt();
				input = safeInputInt();
				while(input<1||input>4){
					System.out.println("Invalid input. Must input 1-4.");
					System.out.print("Please enter your selection: ");
					//input = scan.nextInt();
					input = safeInputInt();
				}
				if(input==1){
					System.out.print("Enter deposit amount: ");
					//double depositNum = scan.nextDouble();
					double depositNum = safeInputDouble();
					if(depositNum<=0){
						System.out.println();
						System.out.println("Deposit must be a postive amount.");
					}
					else{
						makeDeposit(acct.get(acctNum),depositNum);
					}
				}
				if(input==2){
					System.out.print("Enter the number of meals you want to purchase: ");
					//int numMeals= scan.nextInt();
					int numMeals = safeInputInt();
					while(numMeals<0){
						System.out.println("Meals must be postive amount");
						System.out.print("Enter the number of meals you want to purchase: ");
						//numMeals= scan.nextInt();
						numMeals = safeInputInt();
					}
					if(numMeals>maxMeals(acct.get(acctNum))){
						System.out.println("Not enough balance for "+numMeals+" meals");
						buyMeal(acct.get(acctNum),maxMeals(acct.get(acctNum)));
					}
					else{					
						buyMeal(acct.get(acctNum),numMeals);
					}	

				}
				if(input==3){
					if(acct.get(acctNum).getNumberOfMeals()>0){
						haveMeal(acct.get(acctNum));
					}
					else if(acct.get(acctNum).getNumberOfMeals()==0){
						System.out.println("No meals left on your account. Please purchase meals first.");
					}

				}
			}
			System.out.println("Goodbye!");

		}

	}
}