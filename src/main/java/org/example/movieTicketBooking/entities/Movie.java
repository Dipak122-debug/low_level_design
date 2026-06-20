package org.example.movieTicketBooking.entities;



public class Movie {
    private String movieId;
    private String title;
    private int duration;

    //constructor
    public Movie(String movieId, String title, int duration) {
        this.movieId = movieId;
        this.title = title;
        this.duration = duration;
    }
    //getters and setters
    public String getMovieId() {
        return movieId;
}

    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
