package com.example.testetecnicoekan.dtos;

import com.example.testetecnicoekan.domain.model.TipoDocumento;

public record DocumentoDTO (TipoDocumento tipoDocumento, String descricao) { }