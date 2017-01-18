package ru.pelmegov.javashop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "good")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "small_image_link")
    private String smallImageLink;

    @NotNull
    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Good() {
    }

    public Good(String title, Integer quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public Good(String title, Integer quantity, Category category) {
        this.title = title;
        this.quantity = quantity;
        this.category = category;
    }

    public Good(String title, String description, String smallImageLink, Category category) {
        this.title = title;
        this.description = description;
        this.smallImageLink = smallImageLink;
        this.category = category;
    }

    public Good(String title, String description, String smallImageLink, Integer quantity, Float price, Category category) {
        this.title = title;
        this.description = description;
        this.smallImageLink = smallImageLink;
        this.quantity = quantity;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSmallImageLink() {
        return smallImageLink;
    }

    public void setSmallImageLink(String smallImageLink) {
        this.smallImageLink = smallImageLink;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (id != null ? !id.equals(good.id) : good.id != null) return false;
        if (title != null ? !title.equals(good.title) : good.title != null) return false;
        if (description != null ? !description.equals(good.description) : good.description != null) return false;
        if (smallImageLink != null ? !smallImageLink.equals(good.smallImageLink) : good.smallImageLink != null)
            return false;
        if (quantity != null ? !quantity.equals(good.quantity) : good.quantity != null) return false;
        if (price != null ? !price.equals(good.price) : good.price != null) return false;
        return category != null ? category.equals(good.category) : good.category == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (smallImageLink != null ? smallImageLink.hashCode() : 0);
        result = 31 * result + (quantity != null ? quantity.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
