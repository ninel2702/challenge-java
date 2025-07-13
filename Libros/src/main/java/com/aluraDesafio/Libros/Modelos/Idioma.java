package com.aluraDesafio.Libros.Modelos;

public enum Idioma {
    EN("en","EN"),
    ES("es","ES"),
    FR("fr","FR"),
    IT("it","IT"),
    JA("ja","JA"),
    DE("de","DE");

    private String idiomaAPI;
    private String idiomaMayus;

    Idioma(String idiomaAPI, String idiomaMayus) {
        this.idiomaAPI = idiomaAPI;
        this.idiomaMayus = idiomaMayus;
    }

    public static Idioma fromString(String text){
        for (Idioma idioma : Idioma.values()){
            if (idioma.idiomaAPI.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningun idioma encontrado: " + text);
    }

    public static Idioma fromMayuscula(String text){
        for (Idioma idioma : Idioma.values()){
            if (idioma.idiomaMayus.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningun idioma encontrado: " + text);
    }
}
