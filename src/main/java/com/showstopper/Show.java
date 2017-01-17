package com.showstopper;

/**
 * Created by manoharprabhu on 1/17/2017.
 */
public class Show {
    private String name;
    private int seasonNumber;
    private int episodeNumber;
    private String extension;

    public Show(String name, int seasonNumber, int episodeNumber, String extension) {
        this.name = name;
        this.seasonNumber = seasonNumber;
        this.episodeNumber = episodeNumber;
        this.extension = extension;
    }

    public String getName() {
        return name;
    }

    public int getSeasonNumber() {
        return seasonNumber;
    }

    public int getEpisodeNumber() {
        return episodeNumber;
    }

    public String getExtension() {
        return extension;
    }

    @Override
    public String toString() {
        return this.getName() + " : " + this.getSeasonNumber() + " : " + this.getEpisodeNumber() + " : " + this.getExtension();
    }
}
