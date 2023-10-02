package com.Arjunagi.BuyAnything.models.payment;

import com.Arjunagi.BuyAnything.models.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Double amount;
    @ManyToOne
    private User user;
    @Enumerated(EnumType.STRING)
    private Status status;
}
