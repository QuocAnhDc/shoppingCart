package vn.demo.download;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import vn.demo.business.User;
import vn.demo.util.CookieUtil;

public class downloadServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String action = request.getParameter("action");
        if(action == null){
            action="viewAlbums";
        }
        String url ="/index.jsp";
        if(action.equals("viewAlbums")){
            url= "/index.jsp";
        }
        if(action.equals("logOut")){
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); //delete the cookie
                cookie.setPath("/"); //allow the download application to access it
                response.addCookie(cookie);
            }
            url="/index.jsp";
        }else if(action.equals("checkUser")){
            url=checkUser(request,response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        String action = request.getParameter("action");
        String url = "/index.jsp";
        if(action.equals("registerUser")){
            url= registerUser(request,response);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request,response);
    }
    private String checkUser(HttpServletRequest request, HttpServletResponse response){
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        session.setAttribute("productCode",productCode);
        User user = (User) session.getAttribute("user");
        String url;
        if(user== null){
            Cookie[] cookies =request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookies,"emailCookie");
            if(emailAddress == null || emailAddress.equals("")){
                url = "/register.jsp";
            }
            else {
                session.setAttribute("user",user);
                url= "/"+ productCode +"_download.jsp";
            }
        }
        else {
            url= "/"+ productCode +"_download.jsp";
        }
        return url;
    }
    private String registerUser(HttpServletRequest request, HttpServletResponse response){

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");

        User user = new User(firstName,lastName,email);
        HttpSession session = request.getSession();
        session.setAttribute("user",user);

        Cookie c = new Cookie("emailCookie",email);
        c.setMaxAge(60*60*24*365*2);
        c.setPath("/");
        response.addCookie(c);

        String productCode = (String) session.getAttribute("productCode");
        String url = "/" + productCode +"_download.jsp";
        return url;
    }
}
