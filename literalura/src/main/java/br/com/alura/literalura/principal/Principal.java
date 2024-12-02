package br.com.alura.literalura.principal;

import br.com.alura.literalura.model.*;
import br.com.alura.literalura.repository.AuthorRepository;
import br.com.alura.literalura.repository.BookRepository;
import br.com.alura.literalura.service.ConsumeAPI;
import br.com.alura.literalura.service.ConvertData;

import java.util.*;

public class Principal {
    private Scanner read = new Scanner(System.in);
    private ConsumeAPI toConsume = new ConsumeAPI();
    private ConvertData toConvert = new ConvertData();
    private final String ADDRESS_API = "https://gutendex.com/books/?search=";
    private final String PREFIXO_API = "%20";

//    private List<ResponseAPI> dataBooks = new ArrayList<>();
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private BookRepository bookRepositorio;
    private AuthorRepository authorRepositorio;

    public Principal(BookRepository bookRepositorio, AuthorRepository authorRepositorio) {
        this.bookRepositorio = bookRepositorio;
        this.authorRepositorio = authorRepositorio;
    }

    public void showMenu() {
        var option = -1;
        while (option != 0) {
            var menu = """
                    ----------------------------------------------------
                    Escolha o número de sua opção:
                    1 - Buscar livro pelo título
                    2 - Listar livros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos em um determinado ano
                    5 - Listar livros em um determinado idioma  
                    0 - Sair  
                    ----------------------------------------------------                               
                    """;

            System.out.println(menu);
            option = read.nextInt();
            read.nextLine();

            switch (option) {
                case 1:
                    findBooksByTitle();
                    break;
                case 2:
                    showBooksFound();
                    break;
                case 3:
                    showAuthorsFound();
                    break;
                case 4:
                    showLivingAuthorsByYear();
                    break;
                case 5:
                    showBooksByLanguage();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    private ResponseAPI getBooksByTitle() {
        System.out.println("Insira o nome do autor que você deseja procurar");
        var authorbook = read.nextLine();
        System.out.println("Insira o nome do livro que você deseja procurar");
        var nameBook = read.nextLine();
//        var json = toConsume.consumeData(ADDRESS_API + nameBook.replace(" ", "+"));
        var json = toConsume.consumeData(ADDRESS_API + authorbook.replace(" ", "+") + PREFIXO_API + nameBook.replace(" ", "+"));
        ResponseAPI dataOfBookAndAuthor = toConvert.convertData(json, ResponseAPI.class);
        return dataOfBookAndAuthor;
    }

    private void findBooksByTitle() {
        ResponseAPI api = getBooksByTitle();
        BookData bookAPI = api.bookdata().get(0);
        Book book = new Book(bookAPI);
        Author author = new Author().convertBookToAuthor(bookAPI);
        book.setAuthors(author);
        author.setBook(books);
        bookRepositorio.save(book);
        System.out.println(book);
        System.out.println(author);
    }

    private void showBooksFound() {
        System.out.println("lista de livros no banco de dados\n------------");
        books = bookRepositorio.findAll();
        books.stream()
                .sorted(Comparator.comparing(Book::getTitulo))
                .forEach(System.out::println);
    }

    private void showAuthorsFound() {
        System.out.println("lista de autores no banco de dados\n------------");
        authors = authorRepositorio.findAll();
        authors.stream()
                .sorted(Comparator.comparing(Author::getAuthor))
                .forEach(System.out::println);
    }

    private void showLivingAuthorsByYear() {
        System.out.println("liste os autores vivos em um determinado ano... por favor, insira o ano");
        Integer year = Integer.valueOf(read.nextLine());
        authors = authorRepositorio
                .findByAnoNascimentoLessThanEqualAndAnoFalecimentoGreaterThanEqual(year, year);
        if (authors.isEmpty()) {
            System.out.println("autores vivos não encontrados");
        } else {
            authors.stream()
                    .sorted(Comparator.comparing(Author::getAuthor))
                    .forEach(System.out::println);
        }
    }

    private void showBooksByLanguage() {
        System.out.println("lista de livros por idioma\n------------");
        System.out.println("""
                \n\t---- escolha o idioma ----
                \ten - inglês
                \tes - espanhol
                \tfr - francês
                \tpt - português
                """);
        var idioma = Languages.fromString(read.nextLine());
        books = bookRepositorio.findByIdioma(idioma);
        if (books.isEmpty()) {
            System.out.println("livros pelo idioma escolhido não encontrado");
        } else {
            books.stream()
                    .sorted(Comparator.comparing(Book::getTitulo))
                    .forEach(System.out::println);
        }
    }
}
