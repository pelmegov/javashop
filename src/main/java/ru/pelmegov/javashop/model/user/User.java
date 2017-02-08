package ru.pelmegov.javashop.model.user;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.pelmegov.javashop.model.cart.Cart;
import ru.pelmegov.javashop.model.order.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
@EqualsAndHashCode(exclude = {"id", "roles", "cart", "orders"})
@ToString(exclude = "orders")
public class User {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login", unique = true)
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "active", columnDefinition = "boolean default true")
    private Boolean active = true;

    @ManyToMany(targetEntity = Role.class)
    @JoinTable(name = "user_role", joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    @Fetch(FetchMode.JOIN)
    private Set<Role> roles;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Order> orders;

    public void addOrder(Order order) {
        orders.add(order);
    }
}
