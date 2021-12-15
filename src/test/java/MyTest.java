import com.wendy.pojo.Orders;
import org.junit.Test;

public class MyTest {
    @Test
    public void test1(){
        Orders o1 = new Orders();
        Orders o2 = new Orders();
        System.out.println(o1.hashCode());
        System.out.println(o2.hashCode());

    }

}
