package software.ulpgc.kata3.model;

public class Title {
    private final String name;
    private final int year;
    private final int duration;
    private final TitleType titleType;

    public Title(String name, int year, int duration, TitleType titleType) {
        this.name = name;
        this.year = year;
        this.duration = duration;
        this.titleType = titleType;
    }

    public TitleType getTitleType() {
        return titleType;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Title{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                '}';
    }

    public enum TitleType {
        SHORT,
        MOVIE,
        TVSHORT,
        TVMOVIE,
        TVEPISODE,
        TVSERIES,
        TVMINISERIES,
        TVSPECIAL,
        TVPILOT,
        VIDEO,
        VIDEOGAME
    }
}