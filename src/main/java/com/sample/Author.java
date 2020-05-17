package com.sample;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToMany;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@Table(name = "author")
//@NamedQueries({
//        @NamedQuery(name = "com.sample.Author.findAll",
//                query = "select * from Author")
//})
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;
    private String name;
    @ManyToMany(mappedBy = "authors" )
    private List<Books> books = new ArrayList<Books>();

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(String name, List<Books> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}

