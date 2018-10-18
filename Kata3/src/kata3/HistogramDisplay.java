package kata3;

import java.awt.Dimension;
import java.util.Random;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class HistogramDisplay extends ApplicationFrame {

	private static final long serialVersionUID = -7765227026124211524L;

	public HistogramDisplay() {
		super("Histograma");

	}

	private JPanel createPanel() {
		JPanel panel = new ChartPanel(createChart(createDataSet()));
		panel.setPreferredSize(new Dimension(500,400));
		return panel;
	}

	private JFreeChart createChart(DefaultCategoryDataset dataset) {
		return ChartFactory.createBarChart3D("Frecuencias",
				"Dominios email", "Nº de emails", dataset,
				PlotOrientation.VERTICAL, false, false, false);
	}

	private DefaultCategoryDataset createDataSet() {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(5, "", "github.io");
		dataset.addValue(2, "", "ulpgc.es");
		dataset.addValue(15, "", "gmail.com");
		dataset.addValue(9, "", "hotmail.com");
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
