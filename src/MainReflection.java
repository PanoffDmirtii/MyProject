import model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume resume = new Resume("TEST");
        Class myClass = resume.getClass();
        Method method = myClass.getMethod("toString", null);
        System.out.println(method.invoke(resume,null));
    }
}
