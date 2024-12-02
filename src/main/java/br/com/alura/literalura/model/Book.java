package br.com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String author;
    @Enumerated(EnumType.STRING)
    private Languages idioma;
    private Integer numDownloads;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "authors_id")
    private Author authors;

    public Book() {
    }

    public Book(BookData bookData) {
        this.titulo = bookData.titulo();
        this.author = String.valueOf(bookData.author()
                .stream()
                .map(a -> a.nomeAuthor())
                .toList().get(0));
        this.idioma = Languages.fromString(bookData.idioma().get(0));
        this.numDownloads = bookData.numDownloads();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAuthor() {
        return author;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }

    public Languages getIdioma() {
        return idioma;
    }

    public void setIdioma(Languages idioma) {
        this.idioma = idioma;
    }

    public Integer getNumDownloads() {
        return numDownloads;
    }

    public void setNumDownloads(Integer numDownloads) {
        this.numDownloads = numDownloads;
    }

    public Author getAuthors() {
        return authors;
    }

    public void setAuthors(Author authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "\n\t**** info livro ****" +
                "\n\tTitulo: " + titulo +
                "\n\tAutor: " + author +
                "\n\tIdiomas: " + idioma +
                "\n\tDownloads: " + numDownloads +
                "\n\t*******************";
    }
}
