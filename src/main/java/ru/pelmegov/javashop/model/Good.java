package ru.pelmegov.javashop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;

@Entity
@Table(name = "good", schema = "public")
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

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "icon")
    private Byte[] icon;

    @NotNull
    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "price")
    private Float price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
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

    public Byte[] getIcon() {
        return icon;
    }

    public void setIcon(Byte[] icon) {
        this.icon = icon;
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
        if (!(o instanceof Good)) return false;

        Good good = (Good) o;

        if (!getId().equals(good.getId())) return false;
        if (!getTitle().equals(good.getTitle())) return false;
        if (getDescription() != null ? !getDescription().equals(good.getDescription()) : good.getDescription() != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(getIcon(), good.getIcon())) return false;
        if (!getQuantity().equals(good.getQuantity())) return false;
        if (getPrice() != null ? !getPrice().equals(good.getPrice()) : good.getPrice() != null) return false;
        return getCategory().equals(good.getCategory());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        result = 31 * result + Arrays.hashCode(getIcon());
        result = 31 * result + getQuantity().hashCode();
        result = 31 * result + (getPrice() != null ? getPrice().hashCode() : 0);
        result = 31 * result + getCategory().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", icon=" + Arrays.toString(icon) +
                ", quantity=" + quantity +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
