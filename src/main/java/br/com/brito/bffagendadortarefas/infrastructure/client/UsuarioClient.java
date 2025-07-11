package br.com.brito.bffagendadortarefas.infrastructure.client;

import br.com.brito.bffagendadortarefas.business.dto.in.EnderecoDTOResquest;
import br.com.brito.bffagendadortarefas.business.dto.in.LoginRequestDTO;
import br.com.brito.bffagendadortarefas.business.dto.in.TelefoneDTORequest;
import br.com.brito.bffagendadortarefas.business.dto.in.UsuarioDTORequest;
import br.com.brito.bffagendadortarefas.business.dto.out.EnderecoDTOResponse;
import br.com.brito.bffagendadortarefas.business.dto.out.TelefoneDTOResponse;
import br.com.brito.bffagendadortarefas.business.dto.out.UsuarioDTOResponse;
import br.com.brito.bffagendadortarefas.business.dto.out.ViaCepDTOResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @GetMapping
    UsuarioDTOResponse buscaUsuarioPorEmail(@RequestParam("email") String email,
                                            @RequestHeader(value = "Authorization", required=false) String token );

    @PostMapping
    UsuarioDTOResponse salvaUsuario(@RequestBody UsuarioDTORequest usuarioDTO);


    @PostMapping("/login")
    String login(@RequestBody LoginRequestDTO usuarioDTO);


    @DeleteMapping("/{email}")
    void deletaUsuarioPorEmail(@PathVariable String email,
                               @RequestHeader(value = "Authorization", required=false) String token );

    @PutMapping
    UsuarioDTOResponse atualizDadoUsuario(@RequestBody UsuarioDTORequest dto,
                                          @RequestHeader(value = "Authorization", required=false) String token );


    @PutMapping("/endereco")
    EnderecoDTOResponse atualizaEndereco(@RequestBody EnderecoDTOResquest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false) String token);


    @PutMapping("/telefone")
    TelefoneDTOResponse atualizaTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestParam("id") Long id,
                                         @RequestHeader(value = "Authorization", required=false) String token );


    @PostMapping("/endereco")
    EnderecoDTOResponse cadastaEndereco(@RequestBody EnderecoDTOResquest dto,
                                        @RequestHeader(value = "Authorization", required=false) String token );


    @PostMapping("/telefone")
    TelefoneDTOResponse cadastraTelefone(@RequestBody TelefoneDTORequest dto,
                                         @RequestHeader(value = "Authorization", required=false) String token);

    @GetMapping("/endereco/{cep}")
    ViaCepDTOResponse buscarDadosCep(@PathVariable("cep") String cep);
    }

