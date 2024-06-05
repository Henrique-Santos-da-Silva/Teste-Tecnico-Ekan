package com.example.testetecnicoekan.domain.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Beneficiario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String dataNascimento;
    //    @CreatedDate
    private Date dataInclusao;
    //    @LastModifiedDate
    private Date dataAtualizacao;

    @OneToMany
    private List<Documento> documentos;

}
