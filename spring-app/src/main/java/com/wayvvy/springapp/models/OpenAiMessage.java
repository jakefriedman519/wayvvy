package com.wayvvy.springapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Jacksonized
public class OpenAiMessage {
  @JsonProperty
  private String role;

  @JsonProperty
  private String content;
}
