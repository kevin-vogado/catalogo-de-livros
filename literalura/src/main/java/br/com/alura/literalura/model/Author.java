package br.com.alura.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String author;
    private Integer anoNascimento;
    private Integer anoFalecimento;

    @OneToMany(mappedBy = "authors", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(AuthorData authorData) {
        this.author = authorData.nomeAuthor();
        this.anoNascimento = authorData.anoNascimento();
        this.anoFalecimento = authorData.anoFalecimento();
    }

    public Author convertBookToAuthor(BookData bookData) {
        AuthorData authorData = bookData.author().get(0);
        return new Author(authorData);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoFalecimento() {
        return anoFalecimento;
    }

    public void setAnoFalecimento(Integer anoFalecimento) {
        this.anoFalecimento = anoFalecimento;
    }

    public List<Book> getBooks() {
        return books;
    }

//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    public void setBook(List<Book> book) {
        book.forEach(b -> b.setAuthors(this));
        this.books = book;
    }

    @Override
    public String toString() {
        return "\n\t**** info autor ****" +
                "\n\tNome: " + author +
                "\n\tNascimento: " + anoNascimento +
                "\n\tFalecimento: " + anoFalecimento +
                "\n\t********************";
    }
}
