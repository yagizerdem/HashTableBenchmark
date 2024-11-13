package CODE;


import org.modelmapper.ModelMapper;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import java.io.*;

public class LoadData {
    public static  void Load(){


        // Create a CsvBeanReader to read the CSV file
        try (ICsvBeanReader beanReader = new CsvBeanReader(new FileReader(SD.filePath), CsvPreference.STANDARD_PREFERENCE)) {

            String[] header = {"url","title","type","genres","releaseYear","imdbId","imdbAverageRating","imdbNumVotes","platform","availableCountries"};
            beanReader.read(DTO.class,header); // skip header

            // Define the bean class to which CSV data will be mapped
            DTO entry;
            ModelMapper modelMapper = new ModelMapper();
            // Read data row by row, mapping it to MyDataBean
            while ((entry = beanReader.read(DTO.class, header)) != null) {
                // Print each record
                HashTableEntry hashTableEntry = modelMapper.map(entry, HashTableEntry.class);
                Platform platform = new Platform();
                platform.name = entry.getPlatform();
                platform.availableCountries= entry.getAvailableCountries();
                hashTableEntry.setPlatform(platform);
                hashTableEntry.AppendPlatforms(hashTableEntry.getPlatform());
                SD.hashTableEntryList.add(hashTableEntry);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void LoadSearchTest(){

        // Create a BufferedReader to read the file
        try (BufferedReader br = new BufferedReader(new FileReader(SD.searchTextFilePath))) {

            String line;

            // Read file line by line
            while ((line = br.readLine()) != null) {
                SD.SearchTextImdbId.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
