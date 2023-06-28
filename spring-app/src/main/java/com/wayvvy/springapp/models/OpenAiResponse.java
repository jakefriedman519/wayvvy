package com.wayvvy.springapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@NoArgsConstructor
@AllArgsConstructor
@Jacksonized
@Builder
@Data
public class OpenAiResponse {
  @JsonProperty
  private String id;

  @JsonProperty
  private String object;

  @JsonProperty
  private Long created;

  @JsonProperty
  private String model;

  @JsonProperty
  private List<OpenAiChoice> choices;

  @JsonProperty
  private Map<String, Integer> usage;

}
