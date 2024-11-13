package GUI;

import CODE.HashTableEntry;
import CODE.LoadData;
import CODE.SD;

import javax.swing.*;

public  class LoadDataWorker extends SwingWorker<Void, Void> {
    private JLabel appStatelabel;  // Instance variable for the JLabel

    public LoadDataWorker(JLabel appStatelabel) {
        this.appStatelabel = appStatelabel;
    }
    @Override
    protected Void doInBackground() throws Exception {
        // Simulate loading data (this runs on a background thread)

        SD.selectedHashTable.clear(); // clear old values
        LoadData.Load(); // load initial data to memory from driver
        // load data from driver
        for(int i = 0 ; i < SD.hashTableEntryList.size() ; i++){
            HashTableEntry entry = SD.hashTableEntryList.get(i);
            SD.selectedHashTable.add(entry.getImdbId() , entry);
        }

        return null;
    }

    @Override
    protected void done() {
        // Update the UI after the background task completes (runs on EDT)
        appStatelabel.setText("App state: complete");
        System.out.println("done ..!!!");
    }
}