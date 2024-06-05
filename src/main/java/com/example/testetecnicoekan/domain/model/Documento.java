package com.example.testetecnicoekan.domain.model;

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
    private TipoDocumento tipoDocumento;
    private String descricao;
    //    @CreatedDate
    private Date dataInclusao;
    //    @LastModifiedDate
    private Date dataAtualizacao;

    @ManyToOne
    private Beneficiario beneficiario;
}
