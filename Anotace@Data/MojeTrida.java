import java.lang.reflect.Method;
import java.util.ArrayList;

public class MojeTrida {
    int rok;

    public MojeTrida(int rok) {
        this.rok = rok;
    }

    @Override
    public String toString() {
        return "MojeTrida{" +
                "rok=" + rok +
                '}';
    }
    public void aaa (){
        
    }

    public static void main(String[] args) {
        MojeTrida m = new MojeTrida(2024);
        String str = "aaa:";
//        System.out.println(m.getClass().getCanonicalName());
//        System.out.println(m.getClass().getSimpleName());
//        System.out.println(str.getClass().getName());
//        String a = "a.";
//        Class<?> cls = a.getClass();
//        Method[] methods = cls.getMethods();
//
//        // get the name of every method present in the list
//        for (Method method : methods) {
//
//            String MethodName = method.getName();
//            System.out.println("Name of the method: "
//                    + MethodName);
//        }
//

        Class<?> cls = m.getClass();

        Class<?> predek = cls.getSuperclass();
        System.out.println(cls.getName());
        System.out.println(predek.getName());
    }

}
