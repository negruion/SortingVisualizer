package algorithms;

import components.BarPanel;
import java.awt.*;
import java.util.List;
import javax.swing.*;

/**
 * This class is responsible for sorting the bars using the bubble sort algorithm.
 */
public class BubbleSort {

    BarPanel barPanel;

    public BubbleSort(BarPanel barPanel) {
        this.barPanel = barPanel;
    }

    /**
     * Sorts the bars using the bubble sort algorithm.
     */
    public void sort(int speed) {
        List<Rectangle> bars = barPanel.getBars();
        boolean[] swapped = {false};

        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                Timer timer = new Timer(speed, null);

                int[] i = {0};
                int[] j = {0};

                timer.addActionListener(e -> {
                    swapped[0] = false;
                    Rectangle currentBar = bars.get(j[0]);
                    Rectangle nextBar = bars.get(j[0] + 1);

                    Timer swapTimer = new Timer(100, e2 -> {
                        if (i[0] < bars.size() - 1) {
                            barPanel.setGreenBar(j[0]);
                            barPanel.setRedBar(j[0] + 1);
                            barPanel.repaint();
                        }
                    });

                    swapTimer.setRepeats(false);
                    swapTimer.start();

                    if (currentBar.getHeight() > nextBar.getHeight()) {
                        swap(currentBar, nextBar);
                        bars.set(j[0], nextBar);
                        bars.set(j[0] + 1, currentBar);
                        swapped[0] = true;

                        barPanel.setGreenBar(j[0] + 1);
                        barPanel.setRedBar(j[0]);
                        barPanel.repaint();
                    }

                    if (++j[0] >= bars.size() - i[0] - 1) {
                        j[0] = 0;
                        if (!swapped[0]) {
                            i[0]++;
                        }
                    }

                    if (i[0] >= bars.size() - 1) {
                        timer.stop();
                        barPanel.barColourReset();
                    }
                });

                timer.start();
                return null;
            }
        };

        worker.execute();
    }

    private void swap(Rectangle r1, Rectangle r2) {
        int x_1 = r1.x, y_1 = r1.y, x_2 = r2.x, y_2 = r2.y;
        r1.setLocation(x_2, y_1);
        r2.setLocation(x_1, y_2);
    }
}
