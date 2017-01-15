package ru.pelmegov.javashop.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name = "good", schema = "public")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NotNull
    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Basic(fetch = FetchType.LAZY)
    @Lob
    @Column(name = "icon")
    private byte[] icon;

    @NotNull
    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private long price;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public Good() {
    }

    public Good(String title, int quantity) {
        this.title = title;
        this.quantity = quantity;
    }

    public Good(String title, int quantity, Category category) {
        this.title = title;
        this.quantity = quantity;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public byte[] getIcon() {
        return icon;
    }

    public void setIcon(byte[] icon) {
        this.icon = icon;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Good)) return false;

        Good good = (Good) o;

        if (getId() != good.getId()) return false;
        if (getQuantity() != good.getQuantity()) return false;
        if (getPrice() != good.getPrice()) return false;
        if (!getTitle().equals(good.getTitle())) return false;
        if (!getDescription().equals(good.getDescription())) return false;
        if (!Arrays.equals(getIcon(), good.getIcon())) return false;
        return category.equals(good.category);

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        result = 31 * result + Arrays.hashCode(getIcon());
        result = 31 * result + getQuantity();
        result = 31 * result + (int) (getPrice() ^ (getPrice() >>> 32));
        result = 31 * result + category.hashCode();
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
