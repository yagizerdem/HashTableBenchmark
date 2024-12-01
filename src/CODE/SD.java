package CODE;

import java.io.File;
import java.util.ArrayList;

public class SD {

    public  static String filePath = "";

    public static  String searchTextFilePath = "";
    static {

        SD.filePath = new File("movies_dataset.csv").toString();
        SD.searchTextFilePath = new File("search.txt").toString();
    }

    public static ArrayList<HashTableEntry> hashTableEntryList = new ArrayList<>();

    public static   BaseDictionary selectedHashTable = null;

    public static ArrayList<String> SearchTextImdbId = new ArrayList<>();
}
