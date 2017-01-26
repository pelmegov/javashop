package ru.pelmegov.javashop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "user")
@EqualsAndHashCode(exclude = {"id", "roles", "cartGoods"})
@NoArgsConstructor
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_good",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "good_id"))
    private Set<Good> cartGoods = new HashSet<>();

    public void addCartGood(Good good) {
        this.cartGoods.add(good);
    }

}
