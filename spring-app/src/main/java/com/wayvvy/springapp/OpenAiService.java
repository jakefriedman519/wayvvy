package com.wayvvy.springapp;

import org.springframework.stereotype.Service;

import io.github.cdimascio.dotenv.Dotenv;

@Service
public class OpenAiService {

  private final String apiKey = Dotenv.configure().load().get("OPENAI_API_KEY", "");
}
