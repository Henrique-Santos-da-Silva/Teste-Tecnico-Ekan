package com.example.testetecnicoekan.services;

import com.example.testetecnicoekan.domain.model.Beneficiario;
import com.example.testetecnicoekan.domain.model.Documento;
import com.example.testetecnicoekan.repositories.BeneficiarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
public class BeneficiarioService {

    private BeneficiarioRepository repository;

    public List<Beneficiario> getAll() {
        return repository.findAll();
    }

    @Transactional
    public Beneficiario save(Beneficiario beneficiario) {
        Beneficiario novoBeneficiario = new Beneficiario();
        novoBeneficiario.setNome(beneficiario.getNome());
        novoBeneficiario.setTelefone(beneficiario.getTelefone());
        novoBeneficiario.setDataNascimento(beneficiario.getDataNascimento());

        for (Documento documento : beneficiario.getDocumentos()) {
            novoBeneficiario.addDocumento(documento);
        }

        return repository.save(novoBeneficiario);
    }

    @Transactional
    public Beneficiario update(Long id, Beneficiario beneficiario) {
        Beneficiario beneficiarioBuscado = repository.findById(id).orElseThrow(() -> new RuntimeException("Beneficiario não encontrado"));
        beneficiarioBuscado.setNome(beneficiario.getNome());
        beneficiarioBuscado.setTelefone(beneficiario.getTelefone());
        beneficiarioBuscado.setDataNascimento(beneficiario.getDataNascimento());

        beneficiarioBuscado.getDocumentos().clear();
        for (Documento documento : beneficiario.getDocumentos()) {
            Documento novoDocumento = new Documento();
            novoDocumento.setTipoDocumento(documento.getTipoDocumento());
            novoDocumento.setDescricao(documento.getDescricao());

            beneficiarioBuscado.addDocumento(novoDocumento);
        }

        return repository.save(beneficiarioBuscado);
    }

    @Transactional
    public boolean delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
