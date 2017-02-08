package ru.pelmegov.javashop.model.good;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import ru.pelmegov.javashop.model.cart.Item;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "good")
@EqualsAndHashCode(exclude = {"id", "category", "cartItems"})
@ToString(exclude = "cartItems")
@NoArgsConstructor
public class Good {

    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 1, max = 64)
    @Column(name = "title")
    private String title;

    @Column(name = "active", columnDefinition = "boolean default true")
    private Boolean active = true;

    @Size(min = 3)
    @Column(name = "description")
    private String description;

    @Column(name = "small_image_link")
    private String smallImageLink;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    @Digits(integer = 9, fraction = 2)
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    @OneToMany(mappedBy = "good", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Item> cartItems = new HashSet<>();

}
