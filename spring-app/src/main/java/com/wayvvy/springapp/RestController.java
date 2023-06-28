package com.wayvvy.springapp;

import com.wayvvy.springapp.models.OpenAiMessage;
import com.wayvvy.springapp.models.OpenAiRequest;
import com.wayvvy.springapp.models.OpenAiResponse;
import com.wayvvy.springapp.models.Response;

import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import io.github.cdimascio.dotenv.Dotenv;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  private OpenAiClient client;

  private final String apiKey = Dotenv.configure().load().get("OPENAI_API_KEY", "");

  @GetMapping(value = "/{value}", produces = "application/json")
  public OpenAiResponse helloWorld(@PathVariable("value") String value) {
    OpenAiMessage message = OpenAiMessage.builder().role("user")
            .content("Please make a 2 day, hour by hour itinerary for Tokyo including the following places: TeamLabs Planets museum, Tokyo skytree, Meiji Shrine and Temple and anything else that is good in Tokyo. I only want to go to each place once. Please include prices for everything and public transport i should use. Please include specific restauraunts as well. Please minimize the distance i need to travel. ").build();
    OpenAiRequest request = OpenAiRequest.builder().model("gpt-3.5-turbo").messages(List.of(message)).build();
    OpenAiResponse response = client.generateChatCompletion(request,
            "Bearer " + apiKey);

    System.out.println(response.getChoices().get(0).getMessage());

    return response;
  }
}
