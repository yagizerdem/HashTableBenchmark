package CODE;
import lombok.Builder;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString(exclude = {"platform"})
public class HashTableEntry {
    // Instance variables corresponding to each field in the header
    private String url;
    private String title;
    private String type;
    private String genres;
    private String releaseYear;
    private String imdbId; // use id for key in hash table
    private String imdbAverageRating;
    private String imdbNumVotes;
    private  Platform platform; // wrapper class
    private EntityState entityState = null;

    private ArrayList<Platform>  platforms = new ArrayList<>();
    // Setter methods for each field


    public EntityState getEntityState() {
        return entityState;
    }

    public void setEntityState(EntityState entityState) {
        this.entityState = entityState;
    }

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

    public void setPlatform(Platform platform) {
        this.platform = platform;
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

    public Platform getPlatform() {
        return platform;
    }

    public  boolean IsIn(){
        return  this.entityState == EntityState.Active;
    }

    public List<Platform> GetPlatforms(){
        return this.platforms;
    }
    public  void AppendPlatforms(Platform platform){
        this.platforms.add(platform);
    }

    public String Visualize() {
        StringBuilder builder = new StringBuilder();

        builder.append("HashTableEntry {\n");
        builder.append("  imdbId: ").append(imdbId).append("\n");
        builder.append("  url: ").append(url).append("\n");
        builder.append("  title: ").append(title).append("\n");
        builder.append("  type: ").append(type).append("\n");
        builder.append("  genres: ").append(genres).append("\n");
        builder.append("  releaseYear: ").append(releaseYear).append("\n");
        builder.append("  imdbAverageRating: ").append(imdbAverageRating).append("\n");
        builder.append("  imdbNumVotes: ").append(imdbNumVotes).append("\n");
        builder.append("  entityState: ").append(entityState).append("\n");

        // Show platform details (if any)
        builder.append("  platform: ");
        if (platform != null) {
            builder.append(platform.toString()).append("\n");
        } else {
            builder.append("null\n");
        }

        // Show platforms list (if any)
        builder.append("  platforms: ");
        if (platforms != null && !platforms.isEmpty()) {
            builder.append("\n    ");
            for (Platform p : platforms) {
                builder.append(p.toString()).append(", ");
            }
            builder.delete(builder.length() - 2, builder.length()); // Remove trailing comma
            builder.append("\n");
        } else {
            builder.append("None\n");
        }

        builder.append("}\n");

        return builder.toString();
    }


}
