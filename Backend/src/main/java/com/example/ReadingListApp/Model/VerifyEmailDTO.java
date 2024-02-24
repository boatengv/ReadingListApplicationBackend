package com.example.ReadingListApp.Model;
import java.util.UUID;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class VerifyEmailDTO {
    
    private UUID studentId; 
    private String password;
    private String salt;

    public VerifyEmailDTO(UUID studentId, String password, String salt){
        this.studentId=studentId;
        this.salt=salt;
        this.password=password;
    }
}
