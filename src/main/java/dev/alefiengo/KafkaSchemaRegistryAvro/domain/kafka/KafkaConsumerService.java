package dev.alefiengo.KafkaSchemaRegistryAvro.domain.kafka;


import dev.alefiengo.KafkaSchemaRegistryAvro.avro.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaConsumerService {

  @KafkaListener(topics = "${app.config.topic-name}", groupId = "${app.config.group-id}")
  public void listen(ConsumerRecord<String, User> message) {

    log.info("---RESPONSE---");
    log.info("Offset: {}", message.offset());
    log.info("Key: {}", message.key());
    User user = message.value();

    log.info("Value: {}", user);
    log.info("ID: {}", user.getId());
    log.info("FirstName: {}", user.getFirstName());
    log.info("LastName: {}", user.getLastName());
    log.info("Headers: {}", message.headers());
    log.info("Partition: {}", message.partition());
    log.info("Topic: {}", message.topic());
    log.info("Timestamp: {}", message.timestamp());
    log.info("TimestampType: {}", message.timestampType());
  }
}
