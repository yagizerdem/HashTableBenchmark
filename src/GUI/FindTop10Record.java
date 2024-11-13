package GUI;

import CODE.HashTableEntry;
import CODE.LoadData;
import CODE.SD;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public  class FindTop10Record extends SwingWorker<Void, Void> {
    private JLabel appStatelabel;  // Instance variable for the JLabel
    private  JTextArea textArea;
    List<HashTableEntry> top10= new ArrayList<>();
    public FindTop10Record(JLabel appStatelabel , JTextArea textArea) {
        this.appStatelabel = appStatelabel;
        this.textArea = textArea;
    }
    @Override
    protected Void doInBackground() throws Exception {
        // List to store all HashTableEntries
        List<HashTableEntry> allEntries = new ArrayList<>();

        // Step 1: Collect all entries from the hash table
        for (int i = 0; i < SD.selectedHashTable.store.length; i++) {
            HashTableEntry entry = SD.selectedHashTable.store[i];
            if (entry != null && entry.getImdbNumVotes() != null) {
                allEntries.add(entry);
            }
        }

        // Step 2: Sort entries based on imdbNumVotes in descending order
        allEntries.sort((entry1, entry2) -> {
            // Parse the imdbNumVotes and compare them as integers
            int votes1 = Integer.valueOf(entry1.getImdbNumVotes());
            int votes2 = Integer.valueOf(entry2.getImdbNumVotes());
            return Integer.compare(votes2, votes1); // Sort in descending order
        });

        // Step 3: Print top 10 entries (or fewer if less than 10)
        int limit = Math.min(10, allEntries.size());
        System.out.println("Top 10 IMDb entries based on votes:");
        for (int i = 0; i < limit; i++) {
            HashTableEntry entry = allEntries.get(i);
            System.out.println((i + 1) + ". " + entry.getTitle() + " - IMDb Votes: " + entry.getImdbNumVotes());
            top10.add(allEntries.get(i));
        }

        return null;
    }

    @Override
    protected void done() {
        // Update the UI after the background task completes (runs on EDT)
        appStatelabel.setText("App state: complete");
        StringBuilder builder = new StringBuilder();
        for(int i = 0;i < this.top10.size();i++){
            builder.append(this.top10.get(i).Visualize());
        }
        this.textArea.setText(builder.toString());
        System.out.println("done ..!!!");
    }
}