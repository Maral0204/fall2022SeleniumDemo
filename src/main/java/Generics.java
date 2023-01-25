import java.util.ArrayList;
import java.util.List;

public class Generics {
    public static void main(String[] args) {

       List list = new ArrayList<>();
       list.add("Sam");
       list.add("John");
       list.add("Jack");

       String name = ((String)list.get(1));
       System.out.println(name);

//        То есть List у нас содержит Object. Выходит, там где нам нужен конкретный тип, а не Object,
//        нам придётся самим делать приведение типов (кастить)

//        List list2 = new ArrayList<>();
//        list2.add("Sam");
//        list2.add("John");
//        list2.add(145);
//        list2.add("Jack");
//
//        for (Object type: list2) {
//            System.out.println((String)type);
//        }
//
////        Ошибка не видна сразу и выявится только после запуска, потеря времени
//
        List <String> list1 = new ArrayList<>();
        list1.add("Sam");
        list1.add("John");
        list1.add("Jack");
        String name1 = list1.get(1);
        System.out.println(name1);

    }
}
