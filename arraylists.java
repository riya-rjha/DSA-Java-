import java.util.ArrayList;
import java.util.Scanner;

public class arraylists {
    public static void main(String[] args) {
        ArrayList<Integer>list = new ArrayList<>();
        list.add(1);
        for (int i=2; i<=8; i++){
            list.add(i*1);
        }
        System.out.println(list);
        int n = list.size();
        System.out.println("Size of ArrayList : " + n);
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Enter index you want to get element of : ");
            int idx = sc.nextInt();
            int element = list.get(idx);
            System.out.print(element);
            System.out.println("Enter index at which you want to remove : ");
            list.remove(4);
            System.out.println(list);
            System.out.println("Setting element at index : ");
            System.out.println("Enter index : ");
            int index = sc.nextInt();
            System.out.println("Enter element : ");
            int element2 = sc.nextInt();
            list.set(index, element2);
            System.out.println(list);
            System.out.println("Check for an element in ArrayList : ");
            System.out.println("Enter element 1 you want to check for : ");
            int check = sc.nextInt();
            System.out.println(list.contains(check));
            System.out.println("Enter element 2 you want to check for : ");
            int check2 = sc.nextInt();
            System.out.println(list.contains(check2));
            System.out.println("Enter element you want to add at a given index : ");
            System.out.println("Enter element : ");
            int elem = sc.nextInt();
            System.out.println("Enter index : ");
            int index2 = sc.nextInt();
            list.add(index2, elem);
        }
        System.out.println(list);
    }
}

