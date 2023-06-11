import java.util.*;

public class arrLISTS {
    
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(6);
        list.add(5);
        list.add(8);
        System.out.print(check(list));
        isLonely(list);
    }

    public static void isLonely(ArrayList<Integer>list) {
        ArrayList<Integer>list2 = new ArrayList<>();
        int count=0;
        for (int i=0; i<list.size(); i++){
            for (int j=i+1; j<list.size(); j++){
                if(list.get(i)==list.get(j)){
                    count=1;
                }if(count!=1){
                    if(list.contains(list.get(j)+1) && list.contains(list.get(j)-1)){
                        list2.add(list.get(j));
                    }
                }
            }
        }
        System.out.println(list2);
    }

    public static boolean check(ArrayList<Integer> list) {
        boolean inc = true;
        boolean dec = true;
        for (int i=0; i<list.size()-1; i++){
            if(list.get(i)>list.get(i+1)){
                inc = false;
            }
            if(list.get(i)<list.get(i+1)){
                dec = false;
            }
        }
        return inc || dec;
    }
}