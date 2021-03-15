package optional;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Solutie {
    public void algoritm(Map studenti, Map scoli, List stud, TreeSet scol)
    {
        for (int i = 0; i < studenti.size(); i++) {
            int gasit=0;
            for (int j = 0; j < scoli.size()&&gasit==0; j++){
                boolean check= scoli.containsValue(studenti.get(i));
                if(check==true){
                    //   System.out.println(stud.get(i)+" la scoala "+scol.containsAll(j));
                    gasit=1;
                }
            }
        }
    }

}
