<h1 align="center"> Catálogo de Livros </h1>

![Badge em Produção](http://img.shields.io/static/v1?label=STATUS&message=ONLINE&color=GREEN&style=for-the-badge)

# Descrição do Projeto 
O Catálogo de Livros é uma aplicação feita com Java usando o framework Spring Boot com Maven, a biblioteca Jackson para a desserialização do JSON da API e o banco de dados relacional PostgreSQL para o armazenamento dos dados. A principal função do Catálogo de Livros é consumir uma [API de livros do Projeto Gutenberg](https://gutendex.com/) para armazenar dados de livros e o seu autor em um banco de dados relacional e, deste modo, possibilitar extrair informações personalizadas dos dados armazenados.

# Funcionalidades do Projeto
- `Funcionalidade 1` enviar o nome de um autor
- `Funcionalidade 1.2` enviar o título de um livro
- `Funcionalidade 2` receber dados de um autor como nome, ano de nascimento e ano de falecimento
- `Funcionalidade 2.1` receber dados de um livro como título, nome do autor, idioma e número de downloads
- `Funcionalidade 3` exibir no terminal 1 (uma) possível escolha para enviar o nome de um autor e o título de um livro para procurar na API: Buscar livro pelo título
- `Funcionalidade 3.1` exibir no terminal 3 (três) possíveis escolhas para extrair informações personalizadas dos dados armazenados: Listar livros registrados, Listar autores registrados, Listar autores vivos em um determinado ano, Listar livros em um determinado idioma
- `Funcionalidade 3.2` exibir no terminal 1 (uma) possível escolha para parar a aplicação: Sair
- `Funcionalidade 4` fornecer classe Enum 'Languages' que possibilita transcrever o idioma do livro que esteja em 'en, pt, es, fr' para 'INGLES, PORTUGUES, ESPANHOL, FRANCES' no banco de dados PostgreSQL
- `Funcionalidade 5` fornecer armazenamento dos dados em um banco de dados relacional PostgreSQL
- `Funcionalidade 6` fornecer consulta personalizada na aplicação para manipulação dos dados armazenados em um banco de dados relacional PostgreSQL

# Acessar o Projeto

Para baixar o projeto em sua máquina, execute `git clone` com o link do repositório remoto `https://github.com/kevin-vogado/catalogo-de-livros.git`.

# Técnicas e Tecnologias Utilizadas

- `Java`
- `Orientação a Objetos`
- `Jackson`
- `Consumo de API`
- `Spring Boot com Maven`
- `PostgreSQL`
