import java.io.*;
import java.util.*;
import java.util.stream.*;


class Result {


    public static String biggerIsGreater(String w) {
    // Write your code here
    int i , j,comp,lastcomp,index=0;
    char status = 'n',f,s;
    StringBuilder copyw = new StringBuilder(w);
    for (i = w.length()-1; i > 0; i--) {
       f = w.charAt(i);
       s = w.charAt(i-1);
       comp = Character.compare(f, s);
       if (comp>0) {
           if (i==w.length()-1) 
           {
               copyw.setCharAt(i, s);
               copyw.setCharAt(i-1, f);
               w=copyw.toString();
               return w;
           }
            else 
           {   
               lastcomp=comp;
               for(j=i+1;j<w.length();j++)
               {
                   f=w.charAt(j);
                   comp=Character.compare(f, s);
                   if(comp>0 && lastcomp>comp)
                   {
                       lastcomp=comp;
                       status='m'; 
                       index = j;                 
                   }       
               }
               if (status=='n')
               {
                   f = w.charAt(i);
                   copyw.setCharAt(i, s);
                   copyw.setCharAt(i-1, f);
                   w=copyw.toString();
               }
               else
               {
                   f=w.charAt(index);
                   copyw.setCharAt(index, s);
                   copyw.setCharAt(i-1, f);
                   w=copyw.toString();                       
               }
               String s1 = w.substring(0,i);
               String s2 = w.substring(i);
               char tempArray[] = s2.toCharArray();
               Arrays.sort(tempArray);
               w =s1+new String(tempArray);
               return w;
           }
           
       }
    }
    return "no answer";
    }

}

public class Bigger_is_greater {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String w = bufferedReader.readLine();

                String result = Result.biggerIsGreater(w);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
