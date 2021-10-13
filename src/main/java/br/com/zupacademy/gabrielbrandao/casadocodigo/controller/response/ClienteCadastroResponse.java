package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response;

import io.swagger.annotations.ApiModelProperty;

public class ClienteCadastroResponse {

    @ApiModelProperty(position = 1, example = "1")
    private Long id;

    public ClienteCadastroResponse(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
