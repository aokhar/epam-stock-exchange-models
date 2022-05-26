package com.epam.rd.stock.exchange.model.util;

import com.epam.rd.stock.exchange.model.Subscription;
import com.epam.rd.stock.exchange.model.enums.ConditionType;

import java.math.BigDecimal;

public class ConditionVerifyUtil {

    public static boolean verify(Subscription subscription, BigDecimal price){
        boolean result;
        ConditionType condition = subscription.getConditionType();
        if(condition.equals(ConditionType.DEFAULT)){
            result = verifyDefault(subscription, price);
        }
        else if(condition.equals(ConditionType.LIMITS)){
            result = verifyLimit(subscription, price);
        }
        else{
            result = verifyStopLossTakeProfit(subscription, price);
        }
        return result;
    }

    private static boolean verifyDefault(Subscription subscription, BigDecimal price){
        switch (subscription.getOperator()){
            case LOWER:
                return subscription.getPrice().compareTo(price) < 0;
            case GREATER:
                return subscription.getPrice().compareTo(price) > 0;
            case EQUALS:
                return subscription.getPrice().compareTo(price) == 0;
            case LOWER_AND_EQUALS:
                return subscription.getPrice().compareTo(price) >= 0;
            case GREATER_AND_EQUALS:
                return subscription.getPrice().compareTo(price) <= 0;
            default:
                return false;
        }
    }

    private static boolean verifyLimit(Subscription subscription, BigDecimal price){
        return subscription.getLow().compareTo(price) <= 0 && subscription.getHigh().compareTo(price) >=0;
    }

    private static boolean verifyStopLossTakeProfit(Subscription subscription, BigDecimal price){
        return subscription.getLow().compareTo(price) >= 0 && subscription.getHigh().compareTo(price) <=0;
    }
}
