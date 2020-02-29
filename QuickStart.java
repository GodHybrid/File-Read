import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class QuickStart {
    public static void main(String[] args) 
    {
        TextReader txt;
        Integer last = -1;
        String path = "";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter path: ");
        try 
        {
            path = br.readLine();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        if(path.isBlank()) txt = new TextReader();
        else txt = new TextReader(path);

        txt.ReadFile();
        Map<String, Integer> sortedmap = txt.GetMapSorted();
        Set<Entry<String, Integer>> stm = sortedmap.entrySet();
        Iterator<Entry<String, Integer>> i = stm.iterator();
        while(i.hasNext())
        {
            Map.Entry<String, Integer> me = (Map.Entry<String, Integer>)i.next();
            if(me.getValue() != last && last > 0) break;
            System.out.print(me.getKey() + " -- ");
            System.out.println(me.getValue());
            last = me.getValue();
        }
    }
}