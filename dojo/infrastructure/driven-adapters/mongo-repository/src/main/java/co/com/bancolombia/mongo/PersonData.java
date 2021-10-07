package co.com.bancolombia.mongo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "person")
@NoArgsConstructor
public class PersonData {
    @Id
    private String id;
    private String name;
    private Float balance;
}
