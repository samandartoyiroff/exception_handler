package uz.pdp.exceptionhandling.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@SuperBuilder
@NoArgsConstructor
@Data
public class Book {

    private Integer id;
    private String title;
    private String author;


}
