package br.com.alura.literalura.model;

public enum Languages {
    INGLES("en"),
    PORTUGUES("pt"),
    FRANCES("fr"),
    ESPANHOL("es");

    private String languageAPI;

    Languages(String languageAPI) {
        this.languageAPI = languageAPI;
    }

    public static Languages fromString(String text) {
        for (Languages language : Languages.values()) {
            if (language.languageAPI.equalsIgnoreCase(text)) {
                return language;
            }
        }
        throw new IllegalArgumentException("Nenhum idioma encontrado para a string fornecida: " + text);
    }
}
