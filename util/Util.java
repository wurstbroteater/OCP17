package util;
public class Util {
  
  public static void print() {
    System.out.println();
  }
  
  public static void print(final Object o) {
    System.out.println(o.toString());
  }

  public static void print(final String id, final Object o) {
    String formatted = id.trim();
    formatted = (formatted.endsWith(":") ? formatted : formatted + ":") + " ";
    System.out.println(formatted + o.toString());
  }
}
