package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Book;
import br.com.alura.literalura.model.Languages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
//    Optional<Book> findByTituloContains(String titulo);
    List<Book> findByIdioma(Languages idioma);
}
