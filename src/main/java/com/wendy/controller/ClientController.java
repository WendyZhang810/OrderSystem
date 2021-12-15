package com.wendy.controller;

import com.wendy.pojo.Catalog;
import com.wendy.pojo.Food;
import com.wendy.pojo.Orders;
import com.wendy.service.CatalogService;
import com.wendy.service.FoodService;
import com.wendy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/client")
public class ClientController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CatalogService catalogService;
    @Autowired
    private OrderService orderService;

    @RequestMapping("/getCatalogs")
    public ModelAndView getAllFood(HttpServletRequest request,HttpServletResponse response) {
        /*get foodlist and cataloglist*/
        List<Food> foodList = foodService.getAll();
        List<Catalog> catalogList = catalogService.getAll();
        String table_id = request.getParameter("tableId");
        /*get table number*/
        Cookie cookie = new Cookie("table_id", table_id);
        cookie.setMaxAge(120);
        cookie.setPath("/");
        response.addCookie(cookie);

        String tableId = request.getParameter("tableId");

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("tableId",tableId);
        modelAndView.addObject("catalogs", catalogList);
        modelAndView.setViewName("client/foodMenu");

        return modelAndView;
    }
    @RequestMapping("/getFoodByCatalog")
    public ModelAndView getFoodByCatalog(String catalogId,String catalogName,String tableId){

        /*find good with catalog_id x */
        List<Food> foodList = foodService.getFoodByCatalogId(Integer.parseInt(catalogId));
        List<Catalog> catalogList = catalogService.getAll();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("catalogs", catalogList);
        modelAndView.addObject("tableId",tableId);
        modelAndView.addObject("foodsByCatalog",foodList);
        modelAndView.addObject("catalogName",catalogName);

        modelAndView.setViewName("client/foodByCatalog");

        return modelAndView;
    }
    @RequestMapping("addTrolley")
    public void addTrolley(String id, String note, HttpServletResponse response){
        /*store id and note in cookie ,replate space with '/' */
        Cookie cookie = new Cookie(id+"_order", note.replace(" ", "_"));
        cookie.setPath("/");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    @RequestMapping("/trolley")
    public ModelAndView trolley(HttpServletRequest request){
        List<String> names = new ArrayList<>();
        List<String> notes = new ArrayList<>();
        List<Double> prices = new ArrayList<>();
        List<String> ids = new ArrayList<>();
        Cookie[] cookies = request.getCookies();

        boolean isEmpty = true;

        for (Cookie cookie : cookies) {
            if(cookie.getName().contains("_order")){
                isEmpty=false;
                String id = cookie.getName().split("_")[0];
                Food food = foodService.getFoodByFoodId(Integer.parseInt(id));
                ids.add(id);
                names.add(food.getFood_name());
                prices.add(food.getFood_price());
                notes.add(cookie.getValue());
            }
        }
        ModelAndView modelAndView = new ModelAndView();
        if(isEmpty){
            modelAndView.addObject("msg","the trolley is empty");
        }else{
            modelAndView.addObject("ids",ids);
            modelAndView.addObject("notes",notes);
            modelAndView.addObject("names",names);
            modelAndView.addObject("prices",prices);
        }

        modelAndView.setViewName("/client/trolley");

        return modelAndView;
    }

    @RequestMapping("/delFromTrolley")
    public String delFromTrolley(String id,HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals(id+"_order")){
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                System.out.println("deleted...");
                break;
            }
        }
        return "redirect:trolley";
    }
    @RequestMapping("emptyTrolley")
    public String emptyTrolley(HttpServletRequest request,HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().contains("_order")){
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }

        return "redirect:trolley";
    }

    @RequestMapping("/confirm")
    public String confirm(HttpServletRequest request,HttpServletResponse response){
        /*create new orders*/
        Orders orders = new Orders();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("table_id")){
                int table_id = Integer.parseInt(cookie.getValue());
                orders.setTable_id(table_id);
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                break;
            }
        }
        orders.setQuantity(1);
        orders.setOrder_status(0);
        orders.setOrder_id(orderService.getGenerateOrderId());


        for (Cookie cookie : cookies) {
            if(cookie.getName().contains("_order")){

                orders.setFood_id(Integer.parseInt(cookie.getName().split("_")[0]));
                orders.setNote(cookie.getValue());
                orderService.addNewOrder(orders);
                cookie.setPath("/");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }
        }


        return "client/success";
    }




}

