package com.eazybytes.eazyschool.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import org.springframework.data.repository.cdi.Eager;

import java.util.Set;

@Data
@Entity
public class Roles extends BaseEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private int roleId;

    private String roleName;

    @OneToMany(mappedBy = "roles" , fetch = FetchType.LAZY , cascade = CascadeType.PERSIST , targetEntity = Person.class)
    private Set<Person> persons;

}
