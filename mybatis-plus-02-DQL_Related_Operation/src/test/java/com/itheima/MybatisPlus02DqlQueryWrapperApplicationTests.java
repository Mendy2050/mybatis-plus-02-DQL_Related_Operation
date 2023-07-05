package com.itheima;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.itheima.dao.UserDao;
import com.itheima.domain.User;
import com.itheima.domain.query.UserQuery;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Wrapper;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlus02DqlQueryWrapperApplicationTests {

    @Autowired
    private UserDao userDao;

    @Test
    void testGetAll(){
        /* Format 1: normal format
        QueryWrapper qw = new QueryWrapper<>();
        qw.lt("age",18);
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);*/

        /* format 2: Method Chaining
        QueryWrapper qw = new QueryWrapper<>();
        qw.lt("age",65).ge("age",18;
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);*/


        /* format 3: lambda format
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().lt(User::getAge,10);
        List<User> userList = userDao.selectList(qw);
        System.out.println(userList);*/


        //how to deal with null value
        /*UserQuery uq = new UserQuery();
        uq.setAge(10);
        uq.setAge2(30);

        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.ge(null !=uq.getAge(), User::getAge,uq.getAge());
        lqw.lt(null !=uq.getAge2(), User::getAge, uq.getAge2());
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);*/


        // query projection
        // method 1:
        /*LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.select(User::getId, User::getName, User::getAge);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);
        */

        // method 2:
        /*QueryWrapper<User> lqw = new QueryWrapper<>();
        lqw.select("id","name","age","tel");
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);*/


        // aggregation query
        // QueryWrapper<User> qw = new QueryWrapper<>();
        //lqw.select("count(*) as count");
        // 代表SELECT count(*) as count FROM user

        //lqw.select("max(age) as maxAge");
        //代表SELECT max(age) as maxAge FROM user

        //lqw.select("min(age) as minAge");
        //代表SELECT min(age) as minAge FROM user

        //lqw.select("sum(age) as sumAge");
        //代表SELECT sum(age) as sumAge FROM user

//        qw.select("avg(age) as avgAge");
//        //代表SELECT avg(age) as avgAge FROM user
//
//        List<Map<String, Object>> userList = userDao.selectMaps(qw);
//        System.out.println(userList);


        // conditional query

        /*// 1.  equal to =
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.eq(User::getName,"Jerry").eq(User::getPassword,"jerry");
        User user = userDao.selectOne(lqw);
        System.out.println(user);*/


        // 2.  scope query: lt, gt, le, ge, eq, between
        /*LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.between(User::getAge,10, 30);
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);*/


        // 3.  wildcard query: like
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<>();
        lqw.like(User::getName,"J");
        List<User> userList = userDao.selectList(lqw);
        System.out.println(userList);




    }


}
