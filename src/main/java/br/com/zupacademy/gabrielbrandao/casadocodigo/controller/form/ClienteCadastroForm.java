package br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form;


import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Cliente;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Estado;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Pais;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.builder.ClienteBuilder;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.PaisRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.CampoUnico;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.CpfCnpj;
import br.com.zupacademy.gabrielbrandao.casadocodigo.validation.EstadoPais;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@EstadoPais
public class ClienteCadastroForm {

    @ApiModelProperty(position = 1, example = "max@email.com", required = true)
    @NotBlank
    @Email
    @CampoUnico(domainClass = Cliente.class, fieldName = "email")
    private String email;

    @ApiModelProperty(position = 2, example = "Max", required = true)
    @NotBlank
    private String nome;

    @ApiModelProperty(position = 3, example = "Straling", required = true)
    @NotBlank
    private String sobrenome;

    @ApiModelProperty(position = 4, example = "123.456.789-09", required = true)
    @NotBlank
    @CampoUnico(domainClass = Cliente.class, fieldName = "documento")
    @CpfCnpj
    private String documento;

    @ApiModelProperty(position = 5, example = "Rua das floridas, 134", required = true)
    @NotBlank
    private String endereco;

    @ApiModelProperty(position = 6, example = "Casa de esquina", required = true)
    @NotBlank
    private String complemento;

    @ApiModelProperty(position = 7, example = "Sao Paulo", required = true)
    @NotBlank
    private String cidade;

    @ApiModelProperty(position = 8, example = "1", required = true)
    @NotNull
    private Long paisId;

    @ApiModelProperty(position = 9, example = "+55 11 4002-8922", required = true)
    @NotBlank
    private String telefone;

    @ApiModelProperty(position = 10, example = "58700-123", required = true)
    @NotBlank
    private String cep;

    @ApiModelProperty(position = 11, example = "1")
    private Long estadoId;

    public ClienteCadastroForm(String email, String nome, String sobrenome, String documento, String endereco, String complemento,
                               String cidade, Long paisId, String telefone, String cep, Long estadoId) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.paisId = paisId;
        this.telefone = telefone;
        this.cep = cep;
        this.estadoId = estadoId;
    }

    public Cliente converter(PaisRepository paisRepository, EstadoRepository estadoRepository) {
        Optional<Pais> paisObj = paisRepository.findById(this.paisId);
        @NotNull Pais pais = paisObj.get();
        
        Cliente cliente = new ClienteBuilder()
                .comEmail(this.email)
                .comNome(this.nome)
                .comSobrenome(this.sobrenome)
                .comDocumento(this.documento)
                .comEndereco(this.endereco)
                .comComplemento(this.complemento)
                .comCidade(this.cidade)
                .comPais(pais)
                .comTelefone(this.telefone)
                .comCep(this.cep)
                .constroi();

        if(estadoId != null) {
            Optional<Estado> estadoObj = estadoRepository.findByIdAndPaisId(this.estadoId, this.paisId);
            estadoObj.ifPresent(cliente::setEstado);
        }

        return cliente;
    }

    /*
       Método utilizado para validação personalizada com bean validation
     */
    public Long getPaisId() {
        return paisId;
    }

    /*
      Método utilizado para validação personalizada com bean validation
    */
    public Long getEstadoId() {
        return estadoId;
    }
}
