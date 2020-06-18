package controller;

import model.Contact;
import model.Record;

import java.io.PrintWriter;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getServerName()+" is called!!!");
        String action = request.getParameter("action");
        System.out.println(action);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF8");
        Record r = new Record();
        String json="{}";
        if(action.equals("read")){

            //List<Contact> contacts = r.getContacts();
            //System.out.println(contacts.size());

        }else if(action.equals("create")){
            String id=request.getParameter("id");
            String name=request.getParameter("name");
            String email=request.getParameter("email");
            String phone=request.getParameter("phone");
            Contact c=new Contact(id,name,email,phone);
            System.out.println(r.getContacts().size());
            r.create(c);
            System.out.println(r.getContacts().size());
            //json= buildJsonObject(c);
        }
        json = buildJsonObjects(r.getContacts());
        System.out.println(json);
        PrintWriter out = response.getWriter();
        out.print(json);
        out.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    private String buildJsonObject(Contact c){
        StringBuilder sb = new StringBuilder("");
        sb.append("{");
        sb.append("\"id\":\""+c.getId()+"\",");
        sb.append("\"name\":\""+c.getName()+"\",");
        sb.append("\"email\":\""+c.getEmail()+"\",");
        sb.append("\"phone\":\""+c.getPhone()+"\"");
        sb.append("}");
        //System.out.println(sb.toString());
        return sb.toString();
    }

    private String buildJsonObjects(List<Contact> contactList){
        StringBuilder sb= new StringBuilder("");
        sb.append("[");
        for (int i=0;i<contactList.size();i++) {
            Contact c = contactList.get(i);
            sb.append(buildJsonObject(c));
            if((i+1)!=contactList.size()){
                sb.append(",");
            }
        }
        sb.append("]");
        //System.out.println(sb.toString());
        return sb.toString();
    }
}
