import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoviesBarchartLoader implements BarchartLoader{
    private static List<Title> titles = null;
    @Override
    public Barchart load(int id) throws IOException {
        ensureTitlesLoaded();

        return switch (id){
            case 0 -> barchart0(titles);
            case 1 -> barchart1(titles);
            default -> null;
        };
    }

    private Barchart barchart0(List<Title> titles) {
        Barchart barchart = new Barchart("Titles per decade", "Decade", "Number of titles");
        Map<Integer, Integer> count = new HashMap<>();
        for (Title title : titles) {
            int year = title.getYear();
            int decade = (year/10)*10;
            count.put(decade, count.getOrDefault(decade, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            barchart.put(entry.getKey(), entry.getValue());
        }
        return barchart;
    }

    private Barchart barchart1(List<Title> titles) {
        Barchart barchart = new Barchart("Type count", "Title Type", "Number of titles");
        Map<Title.TitleType, Integer> typecounts = new HashMap<>();
        for (Title title : titles) {
            Title.TitleType type = title.getTitleType();
            typecounts.put(type, typecounts.getOrDefault(type, 0) + 1);
        }

        for(Map.Entry<Title.TitleType, Integer> entry : typecounts.entrySet()){
            barchart.put(entry.getKey(), entry.getValue());
        }
        return barchart;
    }

    private void ensureTitlesLoaded() throws IOException {
        if(titles == null) {
            File file = new File("G://Otros ordenadores/Mi portátil/Año_3/1ºSemestre/IS2/Práctica/title.basics.tsv/title.basics.tsv");
            FileTitleLoader loader = new FileTitleLoader(file, new TsvTitleDeserializer());
            titles = loader.load();
        }
    }
}
