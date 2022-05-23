package com.epam.rd.stock.exchange.model;

import com.epam.rd.stock.exchange.model.enums.OrderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Builder
public class Order {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "valuable_id")
    private Valuable valuable;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "order_price")
    private BigDecimal orderPrice;

    @Column(name = "valuable_price")
    private BigDecimal valuablePrice;

    @Column(name = "type")
    private OrderType type;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
