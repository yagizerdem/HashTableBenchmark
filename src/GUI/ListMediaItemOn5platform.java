package GUI;

import CODE.HashTableEntry;
import CODE.LoadData;
import CODE.SD;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public  class ListMediaItemOn5platform extends SwingWorker<Void, Void> {
    private JLabel appStatelabel;  // Instance variable for the JLabel
    private  JTextArea textArea;
    List<HashTableEntry> allEntries= new ArrayList<>();
    public ListMediaItemOn5platform(JLabel appStatelabel , JTextArea textArea) {
        this.appStatelabel = appStatelabel;
        this.textArea = textArea;
    }
    @Override
    protected Void doInBackground() throws Exception {
        // List to store all HashTableEntries

        // Step 1: Collect all entries from the hash table
        for (int i = 0; i < SD.selectedHashTable.store.length; i++) {
            HashTableEntry entry = SD.selectedHashTable.store[i];
            if (entry != null) {
                int size = entry.GetPlatforms().size();
                if(size ==5){
                    this.allEntries.add(entry);
                }
            }
        }

        return null;
    }

    @Override
    protected void done() {
        // Update the UI after the background task completes (runs on EDT)
        appStatelabel.setText("App state: complete");
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < this.allEntries.size();i++){
            builder.append(this.allEntries.get(i).Visualize());
        }
        this.textArea.setText(builder.toString());
        System.out.println("data size  :" + this.allEntries);
        System.out.println("done ..!!!");
    }
}