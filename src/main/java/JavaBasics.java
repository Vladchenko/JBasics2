/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import ru.jbasics.Swing;
import ru.jbasics.basics.Loops;
import ru.jbasics.java.util.Collections_;

// One may try this link - http://www.javapractices.com/home/HomeAction.do
public class JavaBasics {

    String string = "Dummy";

    public static void main(String[] args) throws InterruptedException {
        
        //<editor-fold defaultstate="collapsed" desc="Look and Feel">
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaBasics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="Setting up a logging">
        
        /**
         * File /src/logging.properties keeps settings for logging.
         * When some events appear that invoke a logger, there is a new file 
         * "application_log.txt.0" is created in a root folder of this project.
         */
        
//        try {
//            LogManager.getLogManager().readConfiguration(
//                    JavaBasics.class.getResourceAsStream("/logging.properties"));
//        } catch (IOException e) {
//            System.err.println("Could not setup logger configuration: " + e.toString());
//        }
        //</editor-fold>

         // Cannot do this way, because "dummy" is not static. One should make up an instance first, to refer to it.
//        System.out.println(dummy);
        // This will do
//        System.out.println(new JavaBasics().string);
        
//        new Algorithms();
//        new Annotations();
//        new ArgumentsProcessing(args);
//        BinarySearchRecursive.run();
//        new B();
//        new BufferDemo().runBufferedNoBufferedComparisonDemo();
//        new Classes().parentChildren();
//        new Classes().addressAssignCheck();
//        new Cloning();
//        new CodingBat();
        new Collections_();
//        new Collections_().testArrayTraverse();
//        new Collections_().dynamicArrayListOperating();
//        new TypesConversion();
//        new CuriousCode(new int[]{2, 2, 4, 4, 6, 6}, new int[]{2, 4});        
//        new Dates();
//        new Enum().printCommonInfo();
//        new Exceptions();
//        new Files();
//        new FindFile();
//        new Generics();
//        new Generics2();        
//        new Graphics_().showAllFonts();  
//        new Grep("Synergy");
//        new GrepRegEx("Synergy");
//        new ImplementComparable();
//        new Inheritance();        
//        new Interfaces();
//        new Invocation();
//        IO.Files_ file = (new IO()).new Files_();
//        new IO();
//        file.setOutToFile();
//        new Invocation().checkInvocation();
//        new Invocation();
//        try {
//            new JSONManager().printJSON("user/files/jsonTestFile.json");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Labels.doIt("qwertuiop");
//        new LuckyTickets();
//        new Loops().run();
//        new NoMainMethod();
//        new Nan_().checkFloatNan();
//        Null.run();
//        new Maps();
//        new Matrices();
//        new MultiplicativeInversion(11,19);
//        new OOP();
//        new OOP().run();
//        Overload.checkOverload();
//        new Obscuring();
//        new Overload().checkMethod();
//        new Overloading();
//        new Painting();
//        new Parent();
//        new Polymorphism();
//        new PrimitivesAndWrappers().checkFloatNan();
//          new PrimitivesAndWrappers().commonDemo();
//        new PrimitivesAndWrappers().integerWrapperClass();
//        new PrimitivesAndWrappers().characterWrapperClass();
//        new PrimitivesAndWrappers().integerWrapperClass();
//        new Props().run();
//        Printing.print("Yes");
//        new PriorityOperations().performPriority();
//        Recursion.numbers1ToN(10);
//        new Reflection().createInstance();
//        new RegularExpressions();
//        System.out.println(Recursion.factorial(10));
//        new ScannerImplementation().run();
//        new Serializating();
//        new Singleton().demoSingleton();
//        new SomeProgs();    // Tasks 1-8, 10-14
//        new SomeProgs(args);    // Task 9
//        new Sort();
//        new Static().checkD();
//        new Static().checkStaticAB();
//        new StringAndBuilder();
//        new StringAndBuilder().stringDemo();
//        new StringAndBuilder().stringBuilderDemo();
//        new Strings();
//        new SystemTasks();
//        new Swing().buttonAndFrame();
//        new Threads().demoMyThread();
//        new Threads().demoExecutor();
//        new Threads().commonDemo();
//        new Threads().classicDeadlock();
//        new Temp();
//        new Vk_Com_Java_Problems();

//      Running one sort alone
//        new SortsHandler().showAllSortData(new Cocktail());
        // Running all sorts together
//            new AllSorts();

//        Point solveQuadraticEquation = Algorithms.solveQuadraticEquation(2, 5, -3);
//        Algorithms.showQuadraticEquation(2, 5, -3, solveQuadraticEquation);

//        System.out.println(
//                new Recursion().reverseListRecursively(
//                        new ArrayList<String>(
//                                Arrays.asList("1", "2", "5", "7", "4")
//                        )
//                ));

//        for (final int i: new int[] {1,2,3}) {
//            System.out.println(i);
//        }

    }
    
}
