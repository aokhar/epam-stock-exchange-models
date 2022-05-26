package com.epam.rd.stock.exchange.model.enums;

public enum Operator {
    GREATER, LOWER, GREATER_AND_EQUALS, LOWER_AND_EQUALS, EQUALS;

    public String toOperatorString() {
        return this.name().replace('_', ' ');
    }
}
