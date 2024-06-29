package com.example.rest_api.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String authors;

    public Long getId(){
        return id;
    }

    public void setId( Long Id ){
        this.id = Id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle( String Title ){
        this.title = Title;
    }

    public String getAuthors(){
        return authors;
    }

    public void setAuthors( String Authors ){
        System.out.println("The name of the author is " + Authors);
        this.authors = Authors;
    }


}
