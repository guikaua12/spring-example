package me.approximations.springExample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Getter
@NoArgsConstructor(force=true)
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@ToString
@Entity
@Table(name="se_order_item")
public class OrderItem implements Serializable {
    @EqualsAndHashCode.Include
    @Getter(value=AccessLevel.NONE)
    @EmbeddedId
    private final OrderItemId id = new OrderItemId();

    private final Integer quantity;
    private final Double price;

    public OrderItem(Order order, Product product, Integer quantity, Double price) {
        this.id.setOrder(order);
        this.id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        Objects.requireNonNull(this.id, "OrderItem id is null");

        return this.id.getOrder();
    }

    public Product getProduct() {
        Objects.requireNonNull(this.id, "OrderItem id is null");

        return this.id.getProduct();
    }
}
