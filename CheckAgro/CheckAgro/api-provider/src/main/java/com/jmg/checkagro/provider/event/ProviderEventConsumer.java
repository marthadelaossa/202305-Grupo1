package com.jmg.checkagro.provider.event;



import com.jmg.checkagro.provider.config.RabbitMQConfig;
import lombok.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Size;

@Component
public class ProviderEventConsumer {


    private final RabbitTemplate rabbitTemplate;

    public ProviderEventConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = RabbitMQConfig.QUEUE_PROVIDER_CREADO)
    public void listen(ProviderEventConsumer.DocumentRequest DocumentRequest){
        System.out.print("NOMBRE DEL PROVEEDOR "+ DocumentRequest.documentValue);
        //procesamiento
    }

    public void publishCrearProveedorEvent(ProviderEventConsumer.DocumentRequest entity){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME,RabbitMQConfig.TOPIC_PROVIDER_CREADO,entity);
    }


    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    @Builder
    public static
    class DocumentRequest {
        @Size(min = 1, max = 10)
        private String documentType;
        @Size(min = 1, max = 20)
        private String documentValue;
    }
}
