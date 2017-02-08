package ru.pelmegov.javashop.model.order;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;
import ru.pelmegov.javashop.model.cart.Cart;
import ru.pelmegov.javashop.model.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "order")
@EqualsAndHashCode(exclude = {"id", "user"})
@ToString(exclude = {"cart"})
@NoArgsConstructor
public class Order {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    @CreationTimestamp
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date")
    private Date date;

    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
