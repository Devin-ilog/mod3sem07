package br.senai.pagamento.controllers;

import br.senai.pagamento.dtos.PagamentoDto;
import br.senai.pagamento.services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping
    public ResponseEntity<PagamentoDto> cadastra(@RequestBody @Valid PagamentoDto pagamentoDto,
                                                 UriComponentsBuilder uriBuilder) {
        PagamentoDto novoPagamentoDto = service.cadastra(pagamentoDto);

        URI endereco = uriBuilder.path("/pagamentos/{id}").buildAndExpand(novoPagamentoDto.getId()).toUri();

        return ResponseEntity.created(endereco).body(novoPagamentoDto);
    }
}
