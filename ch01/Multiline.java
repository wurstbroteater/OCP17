package ch01;
public class Multiline {
  public static void main(String[] args) {
    String mul1 = """
      where is  this now?
            and this
      ?""";
    System.out.println(mul1);

    String mul2 = """
      where is  this now?
     \s     and this
      ?""";
    print(mul2);

    String mul3 = """

      where is  this now?
            and this
      ?""";
    print(mul3);

    String mul4 = """
      where is  this now?
            and this
      ?
      """;
    print(mul4);

    print(5);

    String mul5 = """
      where is  this now?
            and this
      ?\
      """;

    print(mul5);

    String mul6 = """
      where is  this now? \
            and this
      ?""";

    print(mul6);

    String mul7 = """
      where is  this now?\"""
            and this\"\"\"
      ?""";
    print(mul7);
  }





  public static void print(Object o) {
    System.out.println(o.toString());
  }
}
