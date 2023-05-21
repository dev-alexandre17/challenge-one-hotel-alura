package br.com.hotel.alura.api.controllers;

import br.com.hotel.alura.api.entities.Developer;
import br.com.hotel.alura.api.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/desenvolvedores")
public class DeveloperController {

    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    public DeveloperController(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Developer developer) {
        Developer findDeveloper = developerRepository.findByNameAndPassword(developer.getName(),
                developer.getPassword());
        if (findDeveloper != null) {
            return ResponseEntity.ok("Login bem-sucedido");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciais inválidas");
        }
    }
}
