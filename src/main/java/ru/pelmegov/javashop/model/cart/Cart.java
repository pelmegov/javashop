package ru.pelmegov.javashop.model.cart;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.pelmegov.javashop.model.good.Good;
import ru.pelmegov.javashop.model.user.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "cart")
@EqualsAndHashCode(exclude = {"id", "items", "user"})
@ToString(exclude = {"items", "user"})
@NoArgsConstructor
public class Cart {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items = new HashSet<>();

    @Column(name = "sum")
    private Double sum = 0d;

    public void addGood(Good good) {
        for (Item cartItem : items) {
            if (cartItem.getGood().equals(good)) {
                cartItem.setCount(cartItem.getCount() + 1);
                sum += good.getPrice();
                break;
            }
            cartItem.setGood(good);
            cartItem.setCount(1);
        }
    }
}
