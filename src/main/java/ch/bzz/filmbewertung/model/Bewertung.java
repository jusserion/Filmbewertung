package ch.bzz.filmbewertung.model;

import ch.bzz.filmbewertung.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.*;
import javax.ws.rs.FormParam;

/**
 * Bewertung class which stores the evaluation of a film
 *
 * @author Erion Malaj
 */
public class Bewertung {

    @FormParam("bewertungUUID")
    @Pattern(regexp = "|[0-9a-fA-F]{8}-([0-9a-fA-F]{4}-){3}[0-9a-fA-F]{12}")
    private String bewertungUUID;

    @JsonIgnore
    private Film film;

    @FormParam("sterne")
    @Min(1)
    @Max(5)
    private Byte sterne;

    @FormParam("begruendung")
    @NotEmpty
    @Size(max = 100)
    private String begruendung;

    @FormParam("likes")
    @Min(0)
    private Integer likes;

    /**
     * Standard constructor
     */
    public Bewertung() {
    }

    /**
     * Bewertung constructor with data
     * @param film film of Bewertung
     * @param sterne number of starts
     * @param begruendung reason why it has so many stars
     * @param likes number of likes
     */
    public Bewertung(Film film, Byte sterne, String begruendung, Integer likes) {
        this.film = film;
        this.sterne = sterne;
        this.begruendung = begruendung;
        this.likes = likes;
    }

    /**
     * sets film by its uuid
     *
     * @param filmUUID the value to set
     */
    public void setFilm(String filmUUID) {
        setFilm(new Film());
        Film film = DataHandler.getInstance().readFilmByUUID(filmUUID);
        getFilm().setFilmUUID(filmUUID);
    }

    /**
     * gets bewertungUUID
     *
     * @return value of bewertungUUID
     */
    public String getBewertungUUID() {
        return bewertungUUID;
    }

    /**
     * sets bewertungUUID
     *
     * @param bewertungUUID the value to set
     */
    public void setBewertungUUID(String bewertungUUID) {
        this.bewertungUUID = bewertungUUID;
    }

    /**
     * gets film
     *
     * @return value of film
     */
    public Film getFilm() {
        return film;
    }

    /**
     * sets film
     *
     * @param film the value to set
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * gets sterne
     *
     * @return value of sterne
     */
    public Byte getSterne() {
        return sterne;
    }

    /**
     * sets sterne
     *
     * @param sterne the value to set
     */
    public void setSterne(Byte sterne) {
        this.sterne = sterne;
    }

    /**
     * gets begruendung
     *
     * @return value of begruendung
     */
    public String getBegruendung() {
        return begruendung;
    }

    /**
     * sets begruendung
     *
     * @param begruendung the value to set
     */
    public void setBegruendung(String begruendung) {
        this.begruendung = begruendung;
    }

    /**
     * gets likes
     *
     * @return value of likes
     */
    public Integer getLikes() {
        return likes;
    }

    /**
     * sets likes
     *
     * @param likes the value to set
     */
    public void setLikes(Integer likes) {
        this.likes = likes;
    }
}
