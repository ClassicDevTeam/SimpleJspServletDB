package com.daniel.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daniel.dao.PetDao;
import com.daniel.dao.UserDao;
import com.daniel.model.Owner;
import com.daniel.model.Pet;

public class PetController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/pet.jsp";
    private static String LIST_PET = "/listPet.jsp";
    private PetDao dao;

    public PetController() {
        super();
        dao = new PetDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("delete")){
            String petName = request.getParameter("petName");
            dao.deletePet(petName);
            forward = LIST_PET;
            request.setAttribute("users", dao.getAllPets());    
//        } else if (action.equalsIgnoreCase("edit")){
//            forward = INSERT_OR_EDIT;
//            int userId = Integer.parseInt(request.getParameter("userId"));
//            Owner user = dao.getUserById(userId);
//            request.setAttribute("user", user);
        } else if (action.equalsIgnoreCase("listPet")){
            forward = LIST_PET;
            request.setAttribute("pets", dao.getAllPets());
        } else {
            forward = INSERT_OR_EDIT;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//    	Enumeration<String> paramNames =request.getParameterNames();
        Pet pet = new Pet();
        pet.setPetName(request.getParameter("Name"));
        pet.setAge(Integer.parseInt(request.getParameter("Age")));
        pet.setOwner(request.getParameter("Owner"));
        String[] FoodList=request.getParameter("favoritFoodList").split(" ");
        for(String food:FoodList)
        {
        	pet.addFavoriteFood(food);
        }
        dao.addPet(pet);
        
        RequestDispatcher view = request.getRequestDispatcher(LIST_PET);
        request.setAttribute("pets", dao.getAllPets());
        view.forward(request, response);
    }
}