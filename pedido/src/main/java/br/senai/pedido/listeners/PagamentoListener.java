package br.senai.pedido.listeners;

import br.senai.pedido.dtos.PagamentoDto;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class PagamentoListener {

    @RabbitListener(queues = "pagamentos.pedido")
    public void recebe(PagamentoDto message) {

        System.out.printf("Mensagem recebida. Pagamento:%nId: %d, Status: %s, Nome do Cliente: %s.%n",
                message.getId(), message.getStatus(), message.getNomeCliente());
    }
}
