package com.cfprac.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode
@Data
@Entity
@Table(name="USER_PROFILE")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@Schema can be used for example value for the schema/request body in the api documentation on swagger ui
    //Will be shared by all APIs using this POJO
    @Schema(example = "Alex")
    private String name;

    @Schema(example = "YYYYMMDD")
    private LocalDate dob;

}
