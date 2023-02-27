package org.example;

import org.example.intializers.JdaInitializers;

import javax.security.auth.login.LoginException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws LoginException, InterruptedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        JdaInitializers initializers = new JdaInitializers();
        initializers.bot();
        initializers.initializeCommands();
        initializers.intializeListener();

    }
}