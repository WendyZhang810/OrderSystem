import com.wendy.mapper.FoodMapper;
import com.wendy.mapper.OrderMapper;
import com.wendy.mapper.UserMapper;
import com.wendy.pojo.Food;
import com.wendy.pojo.Orders;
import com.wendy.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest {

    @Test
    public void test9() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        mapper.delUserById(5);

        sqlSession.close();
    }

    @Test
    public void test8() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = mapper.findUsers();
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void test7() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        FoodMapper mapper = sqlSession.getMapper(FoodMapper.class);
        /*Food food = new Food();
        food.setFood_id(13);
        food.setFood_price(14.00);
        food.setFood_name("test....");
        food.setCatalog_id(2);*/

        //mapper.addNewFood(food);
        //mapper.alterFood(food);
        mapper.deleteFoodById(13);


        sqlSession.close();
    }

    @Test
    public void test6() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("admin");
        user.setPassword("12345655");

        User user1 = mapper.findUser(user);
        System.out.println(user1);
        System.out.println(user1==null);

        sqlSession.close();
    }

    @Test
    public void test5() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        Orders orders = new Orders();

        orders.setTable_id(1);
        orders.setOrder_status(1);
        orders.setFood_id(1);
        orders.setOrder_status(1);
        orders.setQuantity(1);
        orders.setOrder_id("1");

        mapper.addNewOrder(orders);
        sqlSession.close();
    }

    @Test
    public void test4() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
        String orderId = mapper.getGenerateOrderId();
        System.out.println(orderId);
        sqlSession.close();
    }

    @Test
    public void test3() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        FoodMapper mapper = sqlSession.getMapper(FoodMapper.class);
        Food food = mapper.getFoodByFoodId(3);
        System.out.println(food);

        sqlSession.close();
    }

    @Test
    public void test2() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        FoodMapper mapper = sqlSession.getMapper(FoodMapper.class);
        List<Food> foodList = mapper.getFoodByCatalogId(1);
        for (Food food : foodList) {
            System.out.println(food);
        }

        sqlSession.close();
    }




    @Test
    public void test1() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        FoodMapper mapper = sqlSession.getMapper(FoodMapper.class);
        List<Food> foodList = mapper.getAll();
        for (Food food : foodList) {
            System.out.println(food);
        }

        sqlSession.close();
    }


}
