package dev.alefiengo.KafkaSchemaRegistryAvro.infraestructure.entrypoint.rest;

import dev.alefiengo.KafkaSchemaRegistryAvro.domain.kafka.KafKaProducerService;
import dev.alefiengo.KafkaSchemaRegistryAvro.infraestructure.entrypoint.request.UserRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/avro")
public class KafkaDemoController {

  private final KafKaProducerService kafKaProducerService;

  @PostMapping("/send")
  @ResponseStatus(code = HttpStatus.OK)
  public void sendUser(@RequestBody UserRequest userRequest) {
    kafKaProducerService.sendUserTemplate(userRequest);
  }
}
