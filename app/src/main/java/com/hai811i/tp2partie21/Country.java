package com.hai811i.tp2partie21;
public class Country implements Comparable<Country> {
    private String name;
    private int flagResId;
    private String capital;
    private long population;
    private double latitude;
    private double longitude;
    private String description;

    public Country(String name, int flagResId, String capital, long population, double latitude, double longitude, String description) {
        this.name = name;
        this.flagResId = flagResId;
        this.capital = capital;
        this.population = population;
        this.latitude = latitude;
        this.longitude = longitude;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getFlagResId() {
        return flagResId;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int compareTo(Country other) {
        return this.name.compareToIgnoreCase(other.name);
    }
}