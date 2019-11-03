package com.example.moviefilem.DataBase;
public class Movie {

     private String movie;
     private int year;
     private Double reating ;
     private String duration ;
     private String dirocter ;
     private String tagline ;
     private String image ;
     private String story ;
     private String cast ;

     public Movie(){

    }

    public Movie(String movie,int year, Double reating, String duration ,String tagline,String image ,String story,String dirocter,String cast){
         this.movie=movie;
         this.year=year;
         this.reating=reating;
         this.duration=duration;
         this.tagline=tagline;
         this.image=image;
         this.story=story;
         this.dirocter=dirocter;
         this.cast=cast;

    }

    public String getCast() {
        return cast;
    }

    public void setCast(String cast) {
        this.cast = cast;
    }

    public String getDirocter() {
        return dirocter;
    }

    public void setDirocter(String dirocter) {
        this.dirocter = dirocter;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Double getReating() {
        return reating;
    }

    public void setReating(Double reating) {
        this.reating = reating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }

}
