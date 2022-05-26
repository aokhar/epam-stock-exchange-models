package com.epam.rd.stock.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "card")
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Card {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "user_id", columnDefinition = "CHAR(36)")
    private String userId;

    @Column(name = "card_holder")
    private String cardHolder;

    @Column(name = "expired_month")
    private Integer expMonth;

    @Column(name = "expired_year")
    private Integer expYear;

    @Column(name = "card")
    private Long card;

    @Column(name = "cvc")
    private Integer cvc;
}
