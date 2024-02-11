package me.approximations.springExample.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor(force=true)
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded=true)
@Entity(name="se_categories")
public class Category {
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private final Long id;
    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy="categories")
    private final Set<Product> products = new LinkedHashSet<>();
}
