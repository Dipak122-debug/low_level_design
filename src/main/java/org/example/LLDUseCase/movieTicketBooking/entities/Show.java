package org.example.LLDUseCase.movieTicketBooking.entities;



public class Show {
    private String id;
    private Movie movie;
    private Theatre theatre;
    private String showTime;

    public Show(String id, Movie movie, Theatre theatre, String showTime) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.showTime = showTime;
    }
    //getters and setters
    public String getId() {
        return id;
}

    public void setId(String id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public String getShowTime() {
        return showTime;
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
}
