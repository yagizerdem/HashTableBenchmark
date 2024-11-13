package CODE;

public class DTO {

    // Instance variables corresponding to each field in the header
    private String url;
    private String title;
    private String type;
    private String genres;
    private String releaseYear;
    private String imdbId;
    private String imdbAverageRating;
    private String imdbNumVotes;
    private String platform;
    private String availableCountries;

    // Setter methods for each field

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public void setReleaseYear(String releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public void setImdbAverageRating(String imdbAverageRating) {
        this.imdbAverageRating = imdbAverageRating;
    }

    public void setImdbNumVotes(String imdbNumVotes) {
        this.imdbNumVotes = imdbNumVotes;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setAvailableCountries(String availableCountries) {
        this.availableCountries = availableCountries;
    }

    // Optional: Getter methods if you need to retrieve the values later
    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getGenres() {
        return genres;
    }

    public String getReleaseYear() {
        return releaseYear;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getImdbAverageRating() {
        return imdbAverageRating;
    }

    public String getImdbNumVotes() {
        return imdbNumVotes;
    }

    public String getPlatform() {
        return platform;
    }

    public String getAvailableCountries() {
        return availableCountries;
    }
}
