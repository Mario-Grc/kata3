import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Barchart {
    private final Map<Object, Integer> count;
    private final String title;
    private final String xAxis;
    private final String yAxis;

    public Barchart(String yAxis, String xAxis, String title) {
        this.yAxis = yAxis;
        this.xAxis = xAxis;
        this.title = title;
        this.count = new TreeMap<>();
    }

    public String getyAxis() {
        return yAxis;
    }

    public String getxAxis() {
        return xAxis;
    }

    public String getTitle() {
        return title;
    }

    public int get(Object category){
        return count.get(category);
    }

    public void put(Object category, int value) {
        count.put(category, value);
    }

    public Set<Object> keySet() {
        return count.keySet();
    }
}