package com.example.testetecnicoekan.services;

import com.example.testetecnicoekan.domain.model.Documento;
import com.example.testetecnicoekan.repositories.DocumentoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DocumentoService {

    private DocumentoRepository repository;

    public Optional<List<Documento>> getDocumentoBy(Long beneficiarioId) {
        return repository.findDocumentoByBeneficiarioId(beneficiarioId);
    }
}
