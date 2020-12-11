package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SubscriptionPlan plan = new SubscriptionPlan(71, "Plan C");
        FileUtility.writeToFile(plan);

        SubscriptionPlan subscriptionPlan = FileUtility.readFromFile();
        System.out.println(subscriptionPlan.toString());
    }
}
