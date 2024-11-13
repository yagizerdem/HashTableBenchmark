package GUI;

import CODE.LoadData;
import CODE.SD;

import javax.swing.*;
import java.awt.*;

public  class BenchMark1000SearchWorker extends SwingWorker<Void, Void> {
    private JLabel appStatelabel;  // Instance variable for the JLabel
    private  long elapsedTime;
    private JTextArea textArea;
    public BenchMark1000SearchWorker(JLabel appStatelabel , JTextArea textArea) {
        this.appStatelabel = appStatelabel;
        this.textArea = textArea;
    }
    @Override
    protected Void doInBackground() throws Exception {
        // Simulate loading data (this runs on a background thread)

        long startTime = System.currentTimeMillis();
        for(int i = 0; i < SD.SearchTextImdbId.size() ; i++){
            String key = SD.SearchTextImdbId.get(i);
            SD.selectedHashTable.getValue(key);
        }
        long endTime = System.currentTimeMillis();
        // Calculate the elapsed time in milliseconds
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time for 1000 searches: " + elapsedTime + " milliseconds");
        this.elapsedTime = elapsedTime;
        return null;
    }

    @Override
    protected void done() {
        // Update the UI after the background task completes (runs on EDT)
        appStatelabel.setText("App state: complete");
        this.textArea.setText("elapsed time is : " + this.elapsedTime + " ms");
        System.out.println("done ..!!!");
    }
}