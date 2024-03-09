package ch02;
import static util.Util.print;
public class Main {

    public static void main(String[] args) {
        int v1 = 4;
        v1 += (long) 1;
        long v2 = 1;

        print(v1 + v2);

        float v3 = (byte) 1;
        v3 = 1L;

        print(v3);
        byte v4 = 127; // 8 Hobbits = 1 Hobyte -> 2^8 = 128 minus 1 weil signed also 127
        v4 = -128;
        short v5 = 32168;   // Max 32 XXX
        print(v4 + v5);

        short w = 14;
        float x = 13;
        double y = 30;
        print(w * x / y); // out is double

        //!!!! beware of float !!!
        // removing any f here, leads to compile error 
        //becasue any double can not be casted to float
        float v6 = 2.0f / 9.0f;
        //however, works with compound operator
        v6 /= 2.0;

        //number promotion works for values but not for variables for small types
        byte hat = 1;
        byte gloves = 7 * 10;
        short scarf = 5;
        short boots = 2 + 1;

        // do not compile beacuse values of the variables are interpreted as int. Saving an int in i small type like short causes possible loss, ie. compier error
        // scarf = scarf   + boots;
        // scarf = 5 (int) + boots; -java-> int + something = int
        //however, it works with compound operator!
        scarf += boots; //8
        print("scarf " + scarf);
        // 8 / 2 = 2,...
        scarf /= 3; 
        print(scarf + " " + boots + ": " + (scarf | boots));
        long z = 42;
        z -= 15.0;

        int hits = (short) 5, misses = 2;
        print((hits++ | ++hits) + " " + hits); 
        // hits = 7, misses = 2
        boolean c = misses > 1 & (misses < 9 || hits++ < 2),
        s = (misses > 2) && (misses++ > 1),
        t = 7  <= --hits;
        print(c + "-" + s + "-" + t + "-" + hits + "-" + misses); //true-false-false-6-2

        float €_$ = 0_3f;
        €_$ /= (€_$=0_2.0_0f);
        print(€_$=(int)(byte)(short)€_$);
        €_$= (float)1.5;
        print((byte)(double)(€_$ *= 5));
        short ss =  (short)2;
        double sss = ss;
    }
}
