import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TextReader {
    private Path path;
    private TreeMap<String, Integer> mappedContent = new TreeMap<>();

    public TextReader()
    {
        path = Paths.get("bee_movie_script.txt");
    }

    public TextReader(String path) 
    {
        this.path = Paths.get(path);
    }

    public HashMap<String, Integer> ReadFile() 
    {
        String content;
        try 
        {
            content = Files.readString(path);
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            System.out.print("The path is incorrect.");
            return null;
        }
        String[] dummy = content.toLowerCase().replaceAll("[,.:;?!\\-\t-\"-\n]", " ").trim().replaceAll(" +", " ").split(" ");
        for(String n : dummy)
        {
            if(mappedContent.containsKey(n)) mappedContent.put(n, mappedContent.get(n) + 1);
            else mappedContent.put(n, 1);
        }
        return null;
    }

    public Map<String, Integer> GetMapSorted()
    {
        return sortByValues(mappedContent);
    }
    
    public static <K, V extends Comparable<V>> Map<K, V> sortByValues(final Map<K, V> map) 
    {
        Comparator<K> valueComparator = new Comparator<K>() 
        {
            public int compare(K k1, K k2) 
            {
                int compare = map.get(k1).compareTo(map.get(k2));
                if (compare == 0) return 1;
                else return compare;
            }
        };
    
        Map<K, V> sortedByValues = new TreeMap<K, V>(valueComparator.reversed());
        sortedByValues.putAll(map);
        return sortedByValues;
    }
}