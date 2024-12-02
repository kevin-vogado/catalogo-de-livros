package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record BookData(@JsonAlias(value = "title") String titulo,
                       @JsonAlias(value = "authors") List<AuthorData> author,
                       @JsonAlias(value = "languages") List<String> idioma,
                       @JsonAlias(value = "download_count") Integer numDownloads) {
}
