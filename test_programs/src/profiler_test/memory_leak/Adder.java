package profiler_test.memory_leak;

//autoboxing
public class Adder {
 public long addIncremental(long l)
 {
     Long sum = 0L;
     sum =sum + l;
     return sum;
 }
 public static void main(String[] args) {
     Adder adder = new Adder();
     for(long i = 0;i < 10000; i++ )
     {
         adder.addIncremental(i);
     }
 }
}
