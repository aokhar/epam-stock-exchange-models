package com.epam.rd.stock.exchange.model;

import com.epam.rd.stock.exchange.model.enums.ConditionType;
import com.epam.rd.stock.exchange.model.enums.Operator;
import com.epam.rd.stock.exchange.model.enums.SubscriptionType;
import com.epam.rd.stock.exchange.model.enums.ValuableType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "subscription")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subscription {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "valuable_id")
    private String valuableId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "condition_type")
    @Enumerated(value = EnumType.STRING)
    private ConditionType conditionType;

    @Column(name = "low")
    private BigDecimal low;

    @Column(name = "high")
    private BigDecimal high;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "operator")
    private Operator operator;

    @Column(name = "fail_safe")
    private boolean failSafe;

    @Column(name = "reserve")
    private boolean reserve;

    @Column(name = "continuos")
    private boolean continuos;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private SubscriptionType type;


    public String conditionToString(){
        if(conditionType.equals(ConditionType.DEFAULT)){
            return String.format("When price are %s than %s", operator, price);
        }
        else if(conditionType.equals(ConditionType.LIMITS)){
            return String.format("When price in limit from %s to %s", low, high);
        }
        else{
            return String.format("When price lower-equals to %s and bigger-equals to %s", low, high);
        }

    }

}
