package com.example.ReadingListApp.Model;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class OpenLibraryResponse {
    private Map<String, BookRecord> records;

}
