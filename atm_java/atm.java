import java.util.*;


class ATM{
    double Balance = 10000;
    int PINRange0 = 5000 , PINRange1 = 7000;
    HashMap<Double , String> hm = new HashMap<>();
    public void checkPin(){
        Scanner scn = new Scanner(System.in);
        System.out.println();
        System.out.println("                                      Welcome to Automated Teller Machine");
        System.out.println("Enter your User Id: ");
        String entereduser = scn.nextLine();
        System.out.println("Enter your PIN: ");
        int enteredPin = scn.nextInt();
        if(entereduser.length() == 10){
            if(enteredPin >= 1000 && enteredPin <= 7000){
                System.out.println("Account Authorized");
                menu();
            }
            else{
                System.out.println("Incorrect PIN");
                System.out.println("Enter a valid pin.");
                checkPin();
            }
        }
        else{
            System.out.println("Incorrect User Name");
            System.out.println("Enter a valid User Name");
            checkPin();
        }
    } 

    public void menu(){
        System.out.println();
        System.out.println("                             ~---MENU---~                     ");
        System.out.println("Select the operation");
        System.out.println("1. Check A/c Balance");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Deposit Money");
        System.out.println("4. Recent Transactions");
        System.out.println("5. Exit");
        System.out.println("Enter Your Choice: ");

        Scanner scn = new Scanner(System.in);
        int choice = scn.nextInt();

        if(choice == 1){
            checkBalance();
        }
        else if(choice == 2){
            withdrawMoney();
        }
        else if(choice == 3){
            depositMoney();
        }
        else if(choice == 4){
            recentTransactions();
        }
        else if(choice == 5){
            System.out.println("             Thankyou for visting!");
            return;
        }
        else{
            System.out.println("Enter a valid choid");
        }
    }
    public void checkBalance(){
        Scanner scn = new Scanner(System.in);
        System.out.println("A/c Balance: " + Balance);
        System.out.println();
        System.out.println("Do you want to return to MENU? (Y/N)");
        String ch = scn.nextLine();
        if(ch.charAt(0) == 'Y' || ch.charAt(0) == 'y'){
            menu();
        }
        else{
            System.out.println("                           Thankyou for visiting!!");
        }
    }

    public void withdrawMoney(){
        System.out.println("Enter Amount: ");
        Scanner scn = new Scanner(System.in);
        double amt = scn.nextDouble();
        if(amt <= Balance){
            System.out.println("Confirm? Y/N");
            String confirm = scn.next();
            if(confirm.equals("Y") || confirm.equals("y")){
                Balance -= amt;
                hm.put(amt , "Amount Withdrawn");
                System.out.println(amt + " Amount Withdrawn Succesfully");
                System.out.println("Please collect Cash & the Card");
            }
            else{
                System.out.println("Your transaction request has been Cancelled!");
                menu();
            }
        }
        else {
            System.out.println("Insufficient Funds!");
        }
        System.out.println("Do you want to return to MENU? (Y/N)");
        String ch = scn.next();
        if(ch.charAt(0) == 'Y' || ch.charAt(0) == 'y'){
            menu();
        }
        else{
            System.out.println("                           Thankyou for visiting!!");
        }
    }

    public void depositMoney(){
        System.out.println("Enter the Amount: ");
        Scanner scn = new Scanner(System.in);
        double amt = scn.nextDouble();
        System.out.println("Depositing Amount " + amt);
        System.out.println("Confirm? Y/N");
        String confirm = scn.next();
        if(confirm.equals("Y") || confirm.equals("y")){
            Balance += amt;
            hm.put(amt , "Amount Deposited");
            System.out.println(amt + " Amount has been Succesfully Deposited");
        }
        else{
            System.out.println("Your transaction request has been Cancelled!");
            menu();
        }
        System.out.println("Do you want to return to MENU? (Y/N)");
        String ch = scn.next();
        if(ch.charAt(0) == 'Y' || ch.charAt(0) == 'y'){
            menu();
        }
        else{
            System.out.println("                           Thankyou for visiting!!");
        }
    }

    public void recentTransactions(){
        Scanner scn = new Scanner(System.in);
        System.out.println();
        System.out.println("          Recent Transactions:");
        System.out.println("Amount       Transaction");
        for(HashMap.Entry<Double,String> m : hm.entrySet())
            System.out.println(m.getKey()+"       "+m.getValue());
            System.out.println();
            System.out.println("Do you want to return to MENU? (Y/N)");
        String ch = scn.next();
        if(ch.charAt(0) == 'Y' || ch.charAt(0) == 'y'){
            menu();
        }
        else{
            System.out.println("                           Thankyou for visiting!!");
        }
    }
}
