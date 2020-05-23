/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.jbasics.basics;

/**
 *  Object's fields declaration demonstration
 *
 * @author v.yanchenko
 */
public class Declaration {

   int y = 1;
   int z;
   int a = z;   // Why compiler doesn't show any error here? z is not assigned !

   public Declaration() {
      int x;
      int w = z;   // Why compiler doesn't show any error here? z is not assigned !
      // Local variable hides a class's field with the same name
      int y = 2;
      System.out.println("y = " + y);   // 2
      lbl: {
//         int x = 0;   One cannot have a variable in "subscope" with the same 
//          name.
//         System.out.println("x = " + x);
      }
      // Error - variable w might not have been initalized.
//       System.out.println(x);

      // Comment cannot divide a method name.
//      (new Object()).hash/*comment*/Code();
      // Comment can split methods invocation:
      (new Object())./*comment*/hashCode();
      // Comment can replace a spaces
      int/*comment*/z=1;
   }
}
