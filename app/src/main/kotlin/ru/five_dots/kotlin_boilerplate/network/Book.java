package ru.five_dots.kotlin_boilerplate.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by aleksejskrobot on 21.02.17.
 */

public class Book {


    @SerializedName("url")
    @Expose
    public String url;
    @SerializedName("name")
    @Expose
    public String name;
    @SerializedName("isbn")
    @Expose
    public String isbn;
    @SerializedName("authors")
    @Expose
    public List<String> authors = null;
    @SerializedName("numberOfPages")
    @Expose
    public int numberOfPages;
    @SerializedName("publisher")
    @Expose
    public String publisher;
    @SerializedName("country")
    @Expose
    public String country;
    @SerializedName("mediaType")
    @Expose
    public String mediaType;
    @SerializedName("released")
    @Expose
    public String released;
    @SerializedName("characters")
    @Expose
    public List<String> characters = null;
    @SerializedName("povCharacters")
    @Expose
    public List<String> povCharacters = null;

}
