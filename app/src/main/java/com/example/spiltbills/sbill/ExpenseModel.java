package com.example.spiltbills.sbill;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Ayhan on 2018-02-09.
 */

public class ExpenseModel {
    Activity activity;

    public ExpenseModel(Activity activity){
        this.activity = activity;
    }

    public boolean addExpense(String billName,  HashMap<ActivityAccount,Double> payeeList) {
        Expense expense = new Expense(billName,payeeList);
        return activity.addExpenses(expense);
    }

    public double getCurrentTotal() {
        return activity.getCurrentTotal();
    }

    public int getNumOfPpl() {
        return activity.getNumOfPpl();
    }

    public double getCurrentAvg() {
        return getCurrentTotal()/getNumOfPpl();
    }


//    public boolean deletePpl(String name){
//        return activity.deletePeople(name);
//    }



}
