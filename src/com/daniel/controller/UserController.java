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

import com.daniel.dao.UserDao;
import com.daniel.model.Owner;

public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/user.jsp";
    private static String LIST_USER = "/listUser.jsp";
    private UserDao dao;

    public UserController() {
        super();
        dao = new UserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            String userName = request.getParameter("Name");
            dao.deleteUser(userName);
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());    
//        } else if (action.equalsIgnoreCase("edit")){
//            forward = INSERT_OR_EDIT;
//            int userId = Integer.parseInt(request.getParameter("userId"));
//            Owner user = dao.getUserById(userId);
//            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("users", dao.getAllUsers());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Owner user = new Owner();
        user.setName(request.getParameter("Name"));
        user.setAge(Integer.parseInt(request.getParameter("Age")));
        String[] FoodList=request.getParameter("ShoppingCart").split(" ");
        for(String food:FoodList)
        {
        	user.addShoppingCart(food);
        }
        String[] PetList=request.getParameter("PetList").split(" ");
        for(String pet:PetList)
        {
        	user.addPet(pet);
        }
        dao.addUser(user);
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", dao.getAllUsers());
        view.forward(request, response);
    }
}