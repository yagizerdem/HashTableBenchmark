package GUI;

import CODE.HashTableEntry;
import CODE.LoadData;
import CODE.SD;

import javax.swing.*;

public  class LoadDataWorker extends SwingWorker<Void, Void> {
    private JLabel appStatelabel;  // Instance variable for the JLabel
    private  long elapsedTime;
    private JTextArea textArea;
    private  int collisionCount = 0;
    public LoadDataWorker(JLabel appStatelabel , JTextArea textArea) {
        this.appStatelabel = appStatelabel;
        this.textArea =textArea;
    }
    @Override
    protected Void doInBackground() throws Exception {
        // Simulate loading data (this runs on a background thread)

        SD.selectedHashTable.clear(); // clear old values
        LoadData.Load(); // load initial data to memory from driver
        // load data from driver
        long startTime = System.nanoTime();
        for(int i = 0 ; i < SD.hashTableEntryList.size() ; i++){
            HashTableEntry entry = SD.hashTableEntryList.get(i);
            SD.selectedHashTable.add(entry.getImdbId() , entry);
        }
        long endTime = System.nanoTime();
        // Calculate the elapsed time in milliseconds
        long elapsedTime = endTime - startTime;
        System.out.println("Elapsed time for 1000 searches: " + elapsedTime + " ns");
        this.elapsedTime = elapsedTime;
        this.collisionCount = SD.selectedHashTable.collisionCount;
        return null;
    }

    @Override
    protected void done() {
        // Update the UI after the background task completes (runs on EDT)
        appStatelabel.setText("App state: complete");
        textArea.setText("indexing time : " + this.elapsedTime  + " ms " + "  collicion count : " + this.collisionCount);
        System.out.println("done ..!!!");
    }
}