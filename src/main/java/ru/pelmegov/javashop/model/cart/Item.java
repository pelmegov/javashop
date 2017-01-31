package ru.pelmegov.javashop.model.cart;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.pelmegov.javashop.model.good.Good;

import javax.persistence.*;

@Entity
@Data
@Table(name = "cart_item")
@EqualsAndHashCode(exclude = {"id", "cart"})
@ToString(exclude = {"cart"})
@NoArgsConstructor
public class Item {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name = "good_id")
    private Good good;

    @Column(name = "count")
    private Integer count;

}
