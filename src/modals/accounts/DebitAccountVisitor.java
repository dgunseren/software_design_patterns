package modals.accounts;

import interfaces.Visitor;

import java.io.*;
import java.util.Scanner;

public class DebitAccountVisitor implements Visitor {
    int cashAccount_balance;
    int savingAccount_balance;
    int carLoan_balance;
    int houseLoan_balance;


    public void visit(DebitAccount debitAccount) {
        debitAccount.accept(this);

    }
    public  int CashAccountBalance() {

        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\cash_Account_d.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toLowerCase();
                cashAccount_balance =   Integer.valueOf(data);
                System.out.println(cashAccount_balance);


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    return cashAccount_balance;
    }
    public int SavingAccountBalance() {
        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\saving_Account_d.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toLowerCase();
                savingAccount_balance =   Integer.valueOf(data);
                System.out.println(savingAccount_balance);


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return savingAccount_balance;

    }
    public int CarLoanAccountBalance() {
        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\carloan_Account_d.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toLowerCase();
                carLoan_balance =   Integer.valueOf(data);
                System.out.println(carLoan_balance);


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return carLoan_balance;

    }
    public int HouseLoanAccountBalance() {
        try {
            File myObj = new File("C:\\Users\\Deniz Günseren\\Desktop\\sdp\\houseloan_Account_d.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine().toLowerCase();
                houseLoan_balance =   Integer.valueOf(data);
                System.out.println(houseLoan_balance);


            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return houseLoan_balance;

    }


    public void visit(CreditAccount creditAccount) {
        //No action
    }


}
