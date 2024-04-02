package me.approximations.springExample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    @JsonIgnore
    @Getter(AccessLevel.NONE)
    @OneToMany(mappedBy="id.product")
    private final Set<OrderItem> orderItems = new LinkedHashSet<>();

    @JsonIgnore
    public Set<Order> getOrders() {
        return orderItems.stream().map(OrderItem::getOrder).collect(Collectors.toSet());
    }
}
