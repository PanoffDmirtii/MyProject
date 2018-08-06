import model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume resume = new Resume("TEST","TEST");
        Class<?> myClass = resume.getClass();
        Method method = myClass.getMethod("toString");
        System.out.println(method.invoke(resume));
    }
}
