package GUI;

import CODE.HashTableEntry;
import CODE.LoadData;
import CODE.Platform;
import CODE.SD;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public  class GetMediaViaCountry extends SwingWorker<Void, Void> {
    private JLabel appStatelabel;  // Instance variable for the JLabel
    private  JTextArea textArea;
    private  String CountryCode = null;
    private  List<HashTableEntry> SelectedCountries = new ArrayList<>();
    public GetMediaViaCountry(JLabel appStatelabel , JTextArea textArea ,  String CountryCode) {
        this.appStatelabel = appStatelabel;
        this.textArea = textArea;
        this.CountryCode = CountryCode;
    }
    @Override
    protected Void doInBackground() throws Exception {
        List<HashTableEntry> allEntries= new ArrayList<>();
        // Step 1: Collect all entries from the hash table
        for (int i = 0; i < SD.selectedHashTable.store.length; i++) {
            HashTableEntry entry = SD.selectedHashTable.store[i];
            if (entry != null) {
                allEntries.add(entry);
            }
        }

        outer : for(int i = 0 ; i < allEntries.size() ;i++){
            HashTableEntry entry = allEntries.get(i);
            if(entry == null)  continue ;
            List<Platform> platforms = entry.GetPlatforms();
            for(int j = 0;j < platforms.size() ; j++){
                Platform platform = platforms.get(j);
                String[] countryCodes = platform.availableCountries.split(",");
                for(String code : countryCodes){
                    if(code.trim().equals(this.CountryCode)){
                        this.SelectedCountries.add(entry);
                        continue  outer;
                    }
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
        for(int i = 0;i < this.SelectedCountries.size();i++){
            builder.append(this.SelectedCountries.get(i).Visualize());
        }
        System.out.println("size : " +this.SelectedCountries.size());
        this.textArea.setText(builder.toString());
        System.out.println("done ..!!!");
    }
}