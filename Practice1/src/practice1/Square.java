package practice1;

//Source code is decompiled from a .class file using FernFlower decompiler.
import java.util.Scanner;

class Square {
Square() {
}

public static void main(String[] args) {
   Scanner in = new Scanner(System.in);
   int side = in.nextInt();
   String str = String.format("Perimete: %d\n Area: %d, Diagonal: %2f", side, side*side, (double)side * Math.sqrt(2.0));
   System.out.println(str);
}
}