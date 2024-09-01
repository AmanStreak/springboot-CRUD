package com.example.springdi.demo.DTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    Integer id;
    String name;
    LocalDate dateOfJoining;
    @JsonProperty("isActive")
    boolean isActive;
}
