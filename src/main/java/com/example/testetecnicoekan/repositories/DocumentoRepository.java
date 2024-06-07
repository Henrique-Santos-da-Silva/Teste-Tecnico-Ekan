package com.example.testetecnicoekan.repositories;

import com.example.testetecnicoekan.domain.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    @Query("SELECT d FROM Documento d WHERE d.beneficiario.id = :beneficiarioId")
    Optional<List<Documento>> findDocumentoByBeneficiarioId(@Param("beneficiarioId") long beneficiarioId);
}
