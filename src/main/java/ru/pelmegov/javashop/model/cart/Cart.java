package ru.pelmegov.javashop.model.cart;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.pelmegov.javashop.model.user.User;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "cart")
@EqualsAndHashCode(exclude = {"id", "items", "user"})
@ToString(exclude = {"user"})
@NoArgsConstructor
public class Cart {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> items;

    @Column(name = "sum")
    private Double sum = 0d;

    public void addItem(Item item) {
        items.add(item);
    }

}
