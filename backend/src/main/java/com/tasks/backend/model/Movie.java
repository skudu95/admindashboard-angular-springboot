package com.tasks.backend.model;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name = "movies_table")
@Data
public class Movie {

    @Id
    private Integer id;
    private String author;
    private String title;
    private String category;
    private String date;

}
