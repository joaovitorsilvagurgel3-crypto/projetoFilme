package br.com.mediahub.engine.content;

public class TVSeries extends MediaContent {

    private int totalSeasons;
    private int episodesPerSeason;
    private int episodeDuration;
    private boolean isAiring;

    public int getTotalSeasons() {
        return totalSeasons;
    }

    public void setTotalSeasons(int totalSeasons) {
        this.totalSeasons = totalSeasons;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getEpisodeDuration() {
        return episodeDuration;
    }

    public void setEpisodeDuration(int episodeDuration) {
        this.episodeDuration = episodeDuration;
    }

    public boolean isAiring() {
        return isAiring;
    }

    public void setAiring(boolean airing) {
        isAiring = airing;
    }

    // Total duration: seasons × episodes × minutes per episode
    @Override
    public int getDurationInMinutes() {
        return totalSeasons * episodesPerSeason * episodeDuration;
    }
}
