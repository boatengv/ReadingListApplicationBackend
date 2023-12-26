package com.example.ReadingListApp.Service;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Map;
import java.util.Optional;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import com.example.ReadingListApp.Model.BookRecord;
import com.example.ReadingListApp.Model.OpenLibraryResponse;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

@Service
public class BookRetrievalService {

    HttpRequest request;
    Gson gson = new Gson();
    ObjectMapper objectMapper = new ObjectMapper();


    public BookRecord retrieveBookData(String isbn) throws JsonProcessingException{ 
      
      String requestUrl = String.format("http://openlibrary.org/api/volumes/brief/isbn/%s.json",isbn);

      request = HttpRequest.newBuilder()
          .uri(URI.create(requestUrl))
          .method("GET", HttpRequest.BodyPublishers.noBody())
          .build();
      
      HttpResponse<String> response = null;
      
      try {
        response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

      OpenLibraryResponse jsonObjectResponse = gson.fromJson(response.body(), OpenLibraryResponse.class);    
      Map<String, BookRecord> bookRecords = jsonObjectResponse.getRecords();
      Optional<String> book_key = bookRecords.keySet().stream().findFirst();
      BookRecord record = bookRecords.get(book_key.get());
      return record; 
    }   
}
