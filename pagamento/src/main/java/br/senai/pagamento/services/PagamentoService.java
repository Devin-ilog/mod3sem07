package br.senai.pagamento.services;

import br.senai.pagamento.dtos.PagamentoDto;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private static int idSequence = 0;

    public PagamentoDto cadastra(PagamentoDto pagamentoDto) {
        // TODO: converter o pagamentoDto em um obj Pagamento
        // TODO: salvar esse obj Pagamento no repository/DB

        // Message message = new Message(("Cadastrado novo pagamento com id: " + pagamentoDto.getId()).getBytes());

        pagamentoDto.setId(incrementaId());
        System.out.println("pagamento cadastrado com sucesso! id: " + pagamentoDto.getId());
        String routingKey = "pgto.nok";

        if ("SUCESSO".equals(pagamentoDto.getStatus())) {
            routingKey = "pgto.ok";
        }

        rabbitTemplate.convertAndSend("pagamentos.ex", routingKey, pagamentoDto);

        return pagamentoDto;
    }

    private static int incrementaId() {
        return ++idSequence;
    }
}
