package br.com.zupacademy.gabrielbrandao.casadocodigo.controller;

import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.exception.ErrorForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.form.ClienteCadastroForm;
import br.com.zupacademy.gabrielbrandao.casadocodigo.controller.response.ClienteCadastroResponse;
import br.com.zupacademy.gabrielbrandao.casadocodigo.model.Cliente;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.ClienteRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.EstadoRepository;
import br.com.zupacademy.gabrielbrandao.casadocodigo.repository.PaisRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/clientes")
@Api(tags = "Cliente Controller")
public class ClienteController {

    private ClienteRepository repository;
    private PaisRepository paisRepository;
    private EstadoRepository estadoRepository;

    public ClienteController(ClienteRepository repository, PaisRepository paisRepository, EstadoRepository estadoRepository) {
        this.repository = repository;
        this.paisRepository = paisRepository;
        this.estadoRepository = estadoRepository;
    }

    @ApiOperation(value = "Cadastra um autor na base de dados")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok", response = ClienteCadastroResponse.class),
            @ApiResponse(code = 400, message = "bad request", response = ErrorForm.class),
    })
    @PostMapping
    @Transactional
    public ResponseEntity<ClienteCadastroResponse> cadastrar(@RequestBody @Valid ClienteCadastroForm clienteCadastroForm) {
        Cliente cliente = clienteCadastroForm.converter(paisRepository, estadoRepository);
        repository.save(cliente);
        return ResponseEntity.ok().body(new ClienteCadastroResponse(cliente.getId()));
    }
}
