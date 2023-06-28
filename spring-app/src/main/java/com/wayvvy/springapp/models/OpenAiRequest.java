package com.wayvvy.springapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data
@Builder
@Jacksonized
@NoArgsConstructor
@AllArgsConstructor
public class OpenAiRequest {
  @JsonProperty
  private String model;

  @JsonProperty
  private List<OpenAiMessage> messages;
}
