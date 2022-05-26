package com.epam.rd.stock.exchange.model;

import com.epam.rd.stock.exchange.model.enums.BalanceUpdateType;
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
@Builder
@Table(name = "balance_update_history")
public class BalanceUpdateHistory {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "balance_update")
    private BigDecimal update;

    @Column(name = "card")
    private Long card;

    @Column(name = "update_type")
    @Enumerated(value = EnumType.STRING)
    private BalanceUpdateType type;

    @Column(name = "date_time")
    private LocalDateTime dateTime;
}
