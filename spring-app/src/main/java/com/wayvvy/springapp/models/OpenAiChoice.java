package com.wayvvy.springapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Jacksonized
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class OpenAiChoice {

  @JsonProperty
  private Integer index;

  @JsonProperty
  private OpenAiMessage message;

  @JsonProperty
  private String finish_reason;
}
