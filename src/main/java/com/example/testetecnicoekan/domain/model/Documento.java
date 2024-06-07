package com.example.testetecnicoekan.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@EntityListeners(AuditingEntityListener.class)
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private String descricao;
    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @Column(updatable = false)
    private Date dataInclusao;
    @LastModifiedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataAtualizacao;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
}
