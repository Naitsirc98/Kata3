package kata3;

import java.awt.Dimension;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {

	private static final long serialVersionUID = -7765227026124211524L;

	private final Histogram<String> histogram;
	
	public HistogramDisplay(final Histogram<String> histogram) {
		super("Histograma");
		this.histogram = histogram;
	}
	
	private JPanel createPanel() {
		JPanel panel = new ChartPanel(createChart(createDataSet()));
		panel.setPreferredSize(new Dimension(500,400));
		return panel;
	}
	
	private JFreeChart createChart(DefaultCategoryDataset dataset) {
		return ChartFactory.createBarChart3D("Frecuencias",
				"Dominios email", "N� de emails", dataset,
				PlotOrientation.VERTICAL, false, false, false);
	}
	
	private DefaultCategoryDataset createDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		histogram.keySet().forEach(k -> {
			dataset.addValue(histogram.get(k), "", k);
		});
		return dataset;
	}

	public void execute() {
		
		JPanel root = createPanel();
		
		setContentPane(root);
		
		pack();
		
		setLocationRelativeTo(null);
		
		setVisible(true);

	}
	
}
