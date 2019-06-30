package com.telerikacademy.beertag.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.telerikacademy.beertag.models.constants.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Where(clause = "enabled=1")
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @NotNull
    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(name = "user_role")
    private UserRole userRole;

    @NotNull
    @Column(name = "enabled")
    private boolean enabled = true;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    private List<Beer> createdBeers = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "wish_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "beer_id")
    )
    @JsonIgnore
    private Set<Beer> wishList = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "drank_list",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "beer_id")
    )
    @JsonIgnore
    private Set<Beer> drankList = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Set<BeerRating> beerRatings;

    @Column(name = "wishlist_ids")
    public Set<Integer> getWishListIds() {
        return wishList.stream()
                .map(Beer::getId)
                .collect(Collectors.toSet());
    }

    @Column(name = "dranklist_ids")
    public Set<Integer> getDrankListIds() {
        return drankList.stream()
                .map(Beer::getId)
                .collect(Collectors.toSet());
    }
}
