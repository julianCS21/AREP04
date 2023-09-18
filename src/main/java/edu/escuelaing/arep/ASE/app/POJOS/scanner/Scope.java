package edu.escuelaing.arep.ASE.app.POJOS.scanner;

import edu.escuelaing.arep.ASE.app.POJOS.notation.RequestMapping;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scope {


    static Map<String,Method> methodsMapping = new HashMap<>();



    public  void getClasses() throws ClassNotFoundException {

        String classPath = System.getProperty("java.class.path");

        findControllerClasses(classPath);


    }

    public Method getMethod(String endpoint){
        return methodsMapping.get(endpoint);
    }

    private  void findControllerClasses(String basePath) throws ClassNotFoundException {
        File baseDirectory = new File(basePath);

        if (!baseDirectory.exists() || !baseDirectory.isDirectory()) {
            throw new IllegalArgumentException("Invalid base directory");
        }



        searchClasses(baseDirectory, baseDirectory.getName()+ ".");


    }

    private  void searchClasses(File directory, String packageName) throws ClassNotFoundException {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                String newPackage = null;
                if((packageName.contains("classes"))){
                    newPackage = file.getName() + ".";
                }
                else{
                    newPackage = packageName + file.getName() + ".";
                }
                searchClasses(file, newPackage);
            } else if (file.getName().endsWith(".class")) {
                String className = packageName + file.getName().replace(".class", "");
                Class<?> aClass = Class.forName(className);
                Method[] methods = aClass.getDeclaredMethods();
                for(Method method : methods){
                    if(method.isAnnotationPresent(RequestMapping.class)){
                        String value = method.getAnnotation(RequestMapping.class).path();
                        methodsMapping.put(value,method);

                    }
                }
                System.out.println(methodsMapping.toString());



            }
        }
    }


}
