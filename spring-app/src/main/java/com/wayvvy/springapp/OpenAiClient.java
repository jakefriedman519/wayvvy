package com.wayvvy.springapp;

import com.wayvvy.springapp.models.OpenAiRequest;
import com.wayvvy.springapp.models.OpenAiResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import feign.Headers;

@FeignClient(name="chatGPTClient", url="${openAI.api-url}")
public interface OpenAiClient {

  @PostMapping(value = "/v1/chat/completions", consumes = "application/json")
  OpenAiResponse generateChatCompletion(@RequestBody OpenAiRequest requestBody,
                                @RequestHeader("Authorization") String authorizationHeader);

}
