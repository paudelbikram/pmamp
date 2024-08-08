package com.mortage;

import java.util.Scanner;

public class MortgageCalculator {


    public static double calculateMonthlyPayment(double loanAmount, double interestRate, int numberOfPayments) {
        double rate = interestRate / 1200.0;
        return (loanAmount * rate * Math.pow(1 + rate, numberOfPayments))/
                (Math.pow(1 + rate, numberOfPayments) - 1);
    }

    public static void printPointsBuyDown(double loanAmount, double interestRate, int numberOfPayments, double pointsBuyDown) {
        double interestRateReductionPerPoint = 0.25;
        System.out.println("Calculating...");
        System.out.println("Points To Buy-down : " + pointsBuyDown);
        System.out.println("Points Buy-down Cost : " +  (loanAmount * pointsBuyDown) / 100.0);
        double finalInterestRate = interestRate - (pointsBuyDown * interestRateReductionPerPoint);
        System.out.println("Final Interest Rate : " + finalInterestRate);
        double monthlyPayment = calculateMonthlyPayment(loanAmount, finalInterestRate, numberOfPayments);
        double totalPayment = monthlyPayment * numberOfPayments;
        System.out.println("The monthly payment is : " + monthlyPayment);
        System.out.println("Monthly Principal Amount : " + (loanAmount / numberOfPayments));
        System.out.println("Monthly Interest Amount : " + ((totalPayment - loanAmount) / numberOfPayments));
        System.out.println("Total Payment : " + totalPayment);
        System.out.println("==============================================================");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Simple Mortgage Calculator");
        System.out.println("===================================");
        System.out.println("Enter the loan amount : ");
        Scanner in = new Scanner(System.in);
        double loanAmount = in.nextDouble();
        System.out.println("Enter the interest rate : ");
        double interestRate = in.nextDouble();
        System.out.println("Enter the number of monthly payments : ");
        int numberOfPayments = in.nextInt();

        printPointsBuyDown(loanAmount, interestRate, numberOfPayments, 0.0);
        printPointsBuyDown(loanAmount, interestRate, numberOfPayments, 0.5);
        printPointsBuyDown(loanAmount, interestRate, numberOfPayments, 1.0);
        printPointsBuyDown(loanAmount, interestRate, numberOfPayments, 1.5);

        System.out.println("Thank you for using Simple mortgage calculator.");
        System.out.println("Please enter A to calculate again or any other key to exit.");
        String choice = in.next();
        if(choice.equalsIgnoreCase("A")){
            main(args);
        }
        else{
            System.exit(0);
        }
    }
}
