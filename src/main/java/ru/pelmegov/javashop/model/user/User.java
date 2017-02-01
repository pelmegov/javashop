package ru.pelmegov.javashop.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import ru.pelmegov.javashop.model.cart.Cart;
import ru.pelmegov.javashop.model.cart.Item;
import ru.pelmegov.javashop.model.order.Order;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
@EqualsAndHashCode(exclude = {"id", "roles", "cart", "orders"})
@ToString(exclude="orders")
public class User {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 32)
    @Column(name = "login", unique = true)
    private String login;

    @Size(min = 6, max = 32)
    @Column(name = "password")
    private String password;

    @Column(name = "active")
    private Boolean active = true;

    @ManyToMany(fetch = FetchType.EAGER, targetEntity = Role.class)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="cart_id", referencedColumnName = "id")
    private Cart cart;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }

}
