package br.com.hotel.alura.api.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "Desenvolvedor")
@Table(name = "desenvolvedores")
@Getter
@Setter
public class Developer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

}
