package com.wendy.controller;


import com.wendy.pojo.Catalog;
import com.wendy.pojo.Food;
import com.wendy.pojo.User;
import com.wendy.service.CatalogService;
import com.wendy.service.EmpManageService;
import com.wendy.service.FoodService;
import com.wendy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private FoodService foodService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private EmpManageService empService;

    @RequestMapping("/redirectToLoginPage")
    public String redirectToLoginPage(){
        return "admin/adminLogin";
    }


    @RequestMapping("/login")
    public ModelAndView adminLogin(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User login_user = new User();
        login_user.setUsername(username);
        login_user.setPassword(password);

        ModelAndView modelAndView = new ModelAndView();

        User user = userService.findUser(login_user);
        if(user!=null){
            Cookie cookie = new Cookie("admin_username", username);
            cookie.setPath("/");
            cookie.setMaxAge(600);
            response.addCookie(cookie);
            modelAndView.setViewName("admin/adminPage");

        }else{
            modelAndView.addObject("msg","wrong username or password!");
            modelAndView.setViewName("admin/adminLogin");
        }


        return modelAndView;
    }

    @RequestMapping("/logOut")
    public ModelAndView AdminLogOut(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie: cookies){
            if(cookie.getName().equals("admin_username")){
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg","Log Out Successful!");
        modelAndView.setViewName("admin/adminLogin");

        return modelAndView;
    }
    @RequestMapping("/food")
    public ModelAndView food(){
        List<Catalog> catalogs = catalogService.getAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("catalogs",catalogs);

        modelAndView.setViewName("admin/food");
        return modelAndView;
    }
    @RequestMapping("/foodByCatalog")
    public ModelAndView foodByCatalog(String id){
        List<Food> foods = foodService.getFoodByCatalogId(Integer.parseInt(id));
        List<Catalog> catalogs = catalogService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("foods",foods);
        modelAndView.addObject("catalogs",catalogs);
        modelAndView.setViewName("admin/foodManage");
        return modelAndView;
    }
    @RequestMapping("delFood")
    public String delFood(String id){
        foodService.deleteFoodById(Integer.parseInt(id));

        return "foodManage";
    }
    @RequestMapping("alterOrAddFood")
    public String alterOrAddFood(HttpServletRequest request){
        String food_id = request.getParameter("food_id");
        String food_name = request.getParameter("food_name");
        String food_price = request.getParameter("food_price");
        String catalog_id = request.getParameter("catalog_id");
        Food food = new Food();
        food.setFood_name(food_name);
        food.setFood_price(Double.parseDouble(food_price));
        if(foodService.getFoodByFoodId(Integer.parseInt(food_id))!=null){
            food.setFood_id(Integer.parseInt(food_id));
            foodService.alterFood(food);
        }else{
            foodService.addNewFood(food);
        }

        return "redirect:foodByCatalog?catalog_id="+catalog_id;
    }

    @RequestMapping("/employee")
    public ModelAndView getEmployees(){
        ModelAndView modelAndView = new ModelAndView();
        List<User> users = empService.getAllEmp();
        modelAndView.addObject("users",users);
        modelAndView.setViewName("admin/employee");
        return modelAndView;
    }
    @RequestMapping("/addOrAlterUser")
    public String addUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String isManager = request.getParameter("isManager");
        String userId=request.getParameter("userId");

        User user = new User();
        user.setUsername(username);
        user.setManager(Boolean.parseBoolean(isManager));

        if(userId.equals("")){//new user
            user.setPassword("123456");
            empService.addUser(user);

        }else{//alter
            user.setUserId(Integer.parseInt(userId));
            empService.alterUser(user);
        }

        return "redirect:employee";
    }
    @RequestMapping("/delUser")
    public String addUser(String id){
        empService.delUser(Integer.parseInt(id));
        return "redirect:employee";
    }
}
