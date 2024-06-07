package com.example.testetecnicoekan.controllers;

import com.example.testetecnicoekan.domain.model.Beneficiario;
import com.example.testetecnicoekan.services.BeneficiarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beneficiario")
@AllArgsConstructor
public class BeneficiarioController {

    private BeneficiarioService beneficiarioService;

    @GetMapping
    public ResponseEntity<List<Beneficiario>> getAll() {
        List<Beneficiario> beneficiarios = beneficiarioService.getAll();
        return ResponseEntity.ok(beneficiarios);
    }

    @PostMapping
    public ResponseEntity<Beneficiario> create(@RequestBody Beneficiario beneficiario) {
        Beneficiario novoBeneficiario = beneficiarioService.save(beneficiario);
        return new ResponseEntity<>(novoBeneficiario, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Beneficiario> update(@PathVariable Long id, @RequestBody Beneficiario beneficiario) {
        Beneficiario beneficiarioAtualizado = beneficiarioService.update(id, beneficiario);
        return new ResponseEntity<>(beneficiarioAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean foiRemovido = beneficiarioService.delete(id);
        if (!foiRemovido) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
