package ru.pelmegov.javashop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Data
@Table(name = "news")
@EqualsAndHashCode(exclude={"id"})
@NoArgsConstructor
public class News {
    @Id
    @Column(name = "id", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 32)
    @Column(name = "title")
    private String title;

    @Size(min = 3, max = 32)
    @Column(name = "description")
    private String description;

    @Column(name = "news_image_link")
    private String newsImageLink;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "date")
    private Date date;
}
