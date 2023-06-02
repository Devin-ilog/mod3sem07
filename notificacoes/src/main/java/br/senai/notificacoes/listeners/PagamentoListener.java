package br.senai.notificacoes.listeners;

import br.senai.notificacoes.dtos.PagamentoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamentos.notificacoes")
    public void processaMensagem(PagamentoDto mensagem) {
        System.out.printf("Mensagem recebida. Pagamento:%nId: %d, Status: %s, Nome do Cliente: %s.%n",
                mensagem.getId(), mensagem.getStatus(), mensagem.getNomeCliente());

        if (!"SUCESSO".equals(mensagem.getStatus()) && !"FALHA".equals(mensagem.getStatus())) {
            throw new IllegalArgumentException();
        }
    }
}
