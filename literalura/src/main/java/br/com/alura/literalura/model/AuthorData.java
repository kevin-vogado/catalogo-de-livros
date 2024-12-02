package br.com.alura.literalura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AuthorData(@JsonAlias(value = "name") String nomeAuthor,
                         @JsonAlias(value = "birth_year") Integer anoNascimento,
                         @JsonAlias(value = "death_year") Integer anoFalecimento) {
}
