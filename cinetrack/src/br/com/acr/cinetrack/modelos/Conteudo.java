package br.com.mediahub.engine.content;

public class MediaContent {

    // Class attributes
    private String title;
    private int releaseYear, totalDuration, ratingCount;
    private double ratingSum, score, averageRating;
    private boolean isAvailable;

    // Displays main information about content
    public void displayDetails() {
        System.out.println("Nome: " + title);
        System.out.println("Ano de estreia: " + releaseYear);
        System.out.println("Duração em minutos: " + totalDuration);
    }

    // Records a new rating
    public void recordRating(double score) {
        ratingSum += score;
        ratingCount++;
    }

    // Calculates and returns average rating
    public double calculateAverageRating() {
        return ratingSum / ratingCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        // Year cinema was invented: 1888
        if (releaseYear > 1888) {
            this.releaseYear = releaseYear;
        } else {
            System.out.println("Ano de estreia inválido!");
        }
    }

    public int getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(int totalDuration) {
        // Minimum duration of content: 1 minute
        if (totalDuration > 0) {
            this.totalDuration = totalDuration;
        } else {
            System.out.println("Duração inválida!");
        }
    }

    public int getRatingCount() {
        return ratingCount;
    }

    public void setRatingCount(int ratingCount) {
        this.ratingCount = ratingCount;
    }

    public double getRatingSum() {
        return ratingSum;
    }

    public void setRatingSum(double ratingSum) {
        this.ratingSum = ratingSum;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public int getDurationInMinutes() {
        return totalDuration;
    }
}
