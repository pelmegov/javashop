package ru.pelmegov.javashop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "good")
@EqualsAndHashCode(exclude={"category"})
@NoArgsConstructor
public class Good {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Size(min = 3, max = 64)
    @Column(name = "title")
    private String title;

    @Size(min = 6)
    @Column(name = "description")
    private String description;

    @Column(name = "small_image_link")
    private String smallImageLink;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

}
