import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * Created by borisgrunwald on 03/09/2016.
 */
public class LinkedIntListClient {

    public static void main(String[] args) {

        LinkedIntList list = new LinkedIntList();
        LinkedIntList list2 = new LinkedIntList();


        list.add(3);
        list.add(2);
        list.add(2);

        list2.add(3);
        list2.add(2);
        list2.add(2);





        System.out.println(list.notEquals(list2));


    }

}
