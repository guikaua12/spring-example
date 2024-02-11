package me.approximations.springExample.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(force=true)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@ToString
@Entity(name="se_products")
public class Product {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final Long id;
    private final String name;
    private final String description;
    private final Double price;
    private final String imageUrl;

    @ManyToMany
    @JoinTable(name="se_product_category", joinColumns=@JoinColumn(name="product_id"), inverseJoinColumns=@JoinColumn(name="category_id"))
    private final Set<Category> categories = new LinkedHashSet<>();
}
