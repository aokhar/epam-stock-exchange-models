package com.epam.rd.stock.exchange.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "valuable_history")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ValuableHistory {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "CHAR(36)")
    private String id;

    @Column(name = "valuable_id")
    private String valuableId;

    @Column(name = "previous_price")
    private BigDecimal previousPrice;

    @Column(name = "new_price")
    private BigDecimal newPrice;

    @Column(name = "trend")
    private BigDecimal trend;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

}
