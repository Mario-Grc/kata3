package software.ulpgc.kata3;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import software.ulpgc.kata3.model.Barchart;

public class JFreeBarchartAdapter {
    public static JFreeChart adapt(Barchart barchart) {
        return ChartFactory.createBarChart(
                barchart.getTitle(),
                barchart.getxAxis(),
                barchart.getyAxis(),
                datasetOf(barchart)
        );
    }

    private static CategoryDataset datasetOf(Barchart barchart) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(Object object : barchart.keySet()){
            String category = object.toString();
            Integer value = barchart.get(object);
            dataset.addValue(value, "", category);
        }
        return dataset;
    }
}