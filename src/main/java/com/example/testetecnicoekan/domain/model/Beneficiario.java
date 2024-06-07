package com.example.testetecnicoekan.domain.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String dataNascimento;
    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(updatable = false)
    private Date dataInclusao;
    @LastModifiedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataAtualizacao;

    @JsonManagedReference
    @OneToMany(mappedBy = "beneficiario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Documento> documentos = new ArrayList<>();

    public void addDocumento(Documento documento) {
        documentos.add(documento);
        documento.setBeneficiario(this);
    }

    public void removeDocumento(Documento documento) {
        documentos.remove(documento);
        documento.setBeneficiario(null);
    }
}
