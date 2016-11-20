package springlearn.aop;

public class MessagePrinter {

  // printMessage 称为joinpoint
  public void printMessage() {
    System.out.print("World");
  }
}
