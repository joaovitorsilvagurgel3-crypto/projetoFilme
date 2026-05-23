package br.com.mediahub.engine.content;

public class Movie extends MediaContent {

    private String director;

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getDurationInMinutes() {
        return getTotalDuration();
    }
}
