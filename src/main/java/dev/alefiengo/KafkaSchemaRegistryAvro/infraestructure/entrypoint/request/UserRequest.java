package dev.alefiengo.KafkaSchemaRegistryAvro.infraestructure.entrypoint.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserRequest {

  private String id;
  private String firstName;
  private String lastName;
}
