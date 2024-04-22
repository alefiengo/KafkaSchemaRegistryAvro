package dev.alefiengo.KafkaSchemaRegistryAvro.domain.kafka;

import dev.alefiengo.KafkaSchemaRegistryAvro.avro.model.User;
import dev.alefiengo.KafkaSchemaRegistryAvro.infraestructure.entrypoint.request.UserRequest;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafKaProducerService {

  private final KafkaTemplate<String, User> kafkaTemplate;

  @Value("${app.config.topic-name}")
  private String topic;

  public void sendUserTemplate(UserRequest userRequest) {

    User user = User.newBuilder()
        .setId(userRequest.getId())
        .setFirstName(userRequest.getFirstName())
        .setLastName(userRequest.getLastName()).build();

    kafkaTemplate.send(topic, UUID.randomUUID().toString(), user);

    log.info("---REQUEST---");
    log.info("Value: {}", user);
  }
}
