package CODE;

import java.io.File;
import java.util.ArrayList;

public class SD {

    public  static String filePath = "C:\\Users\\yagiz\\IdeaProjects\\HashTableHW\\src\\movies_dataset.csv"; // this ll be overrideden

    public static  String searchTextFilePath = "C:\\Users\\yagiz\\IdeaProjects\\HashTableHW\\src\\search.txt"; // ll be overriden
    static {
        // Get the current working directory (CWD)
        String cwd = System.getProperty("user.dir");
        SD.filePath = new File(cwd, "src\\movies_dataset.csv").toString();
        SD.searchTextFilePath = new File(cwd, "src\\search.txt").toString();
    }

    public static ArrayList<HashTableEntry> hashTableEntryList = new ArrayList<>();

    public static   BaseDictionary selectedHashTable = null;

    public static ArrayList<String> SearchTextImdbId = new ArrayList<>();
}
