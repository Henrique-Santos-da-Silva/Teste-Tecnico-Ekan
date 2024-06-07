package com.example.testetecnicoekan.domain.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Documento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDocumento tipoDocumento;
    private String descricao;
    //    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataInclusao;
    //    @LastModifiedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date dataAtualizacao;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "beneficiario_id")
    private Beneficiario beneficiario;
}
