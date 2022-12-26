package com.daniel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daniel.dao.FoodDao;
import com.daniel.dao.UserDao;
import com.daniel.model.Food;
import com.daniel.model.Owner;

public class FoodController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/food.jsp";
    private static String LIST_FOOD = "/listFood.jsp";
    private FoodDao dao;

    public FoodController() {
        super();
        dao = new FoodDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            String foodName = request.getParameter("foodName");
            dao.deleteFood(foodName);
            forward = LIST_FOOD;
            request.setAttribute("foods", dao.getAllFoods());    
//        } else if (action.equalsIgnoreCase("edit")){
//            forward = INSERT_OR_EDIT;
//            int userId = Integer.parseInt(request.getParameter("userId"));
//            Owner user = dao.getUserById(userId);
//            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listFood")){
            forward = LIST_FOOD;
            request.setAttribute("foods", dao.getAllFoods());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        Food food = new Food();
        food.setFoodName(request.getParameter("Name"));
        try {
            Date dop = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("dop"));
            food.setDoP(dop);
            Date doe = new SimpleDateFormat("MM/dd/yyyy").parse(request.getParameter("doe"));
            food.setDoE(doe);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        dao.addFood(food);
        RequestDispatcher view = request.getRequestDispatcher(LIST_FOOD);
        request.setAttribute("foods", dao.getAllFoods());
        view.forward(request, response);
    }
}