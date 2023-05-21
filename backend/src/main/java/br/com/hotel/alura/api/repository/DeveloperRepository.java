package br.com.hotel.alura.api.repository;

import br.com.hotel.alura.api.entities.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeveloperRepository extends JpaRepository<Developer, Long> {
    Developer findByNameAndPassword(String name, String password);
}
