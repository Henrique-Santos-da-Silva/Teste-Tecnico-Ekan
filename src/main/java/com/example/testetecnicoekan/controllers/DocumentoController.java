package com.example.testetecnicoekan.controllers;

import com.example.testetecnicoekan.domain.model.Documento;
import com.example.testetecnicoekan.services.DocumentoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class DocumentoController {

    private DocumentoService documentoService;

    @GetMapping("/documentos/{beneficiarioId}")
    public ResponseEntity<List<Documento>> getDocumentsBy(@PathVariable Long beneficiarioId) {
        Optional<List<Documento>> documentos = documentoService.getDocumentoBy(beneficiarioId);
        if (documentos.get().isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(documentos.get());
    }

}
