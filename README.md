# Exemplo de Produtor e Consumidor

Produtor de mensagens RabbitMQ: app "Pagamento"

Consumidor de mensagens RabbitMQ: app "Pedido"

## Tecnologias utilizadas
Java 17

SpringBoot 3.1.0

RabbitMQ 3.11

Docker

## Setup

Subir um container docker de RabbitMQ localmente: docker run --rm -p 15672:15672 -p 5672:5672 --name rabbit-devin -e RABBITMQ_DEFAULT_USER=guest -e RABBITMQ_DEFAULT_PASS=guest rabbitmq:3-management

Executar a aplicação "pagamento", que funciona como uma API e publisher de mensagens. Ela também cria a fila no broker.

Executar a aplicação "pedido", que funciona como consumer de mensagens.

## Operação

Enviar requests para POST localhost:8080/pagamentos (exemplo em DiH_ilog.postman_collection.json) e verificar o recebimento no consumer.