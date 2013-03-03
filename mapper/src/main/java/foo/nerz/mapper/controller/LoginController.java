package foo.nerz.mapper.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;

import foo.nerz.mapper.dao.AuthoritiesDao;
import foo.nerz.mapper.dao.UserDao;
import foo.nerz.mapper.entity.Authorities;
import foo.nerz.mapper.entity.Users;
//import foo.nerz.mapper.model.NewUser;

@Controller
public class LoginController {
	@Autowired
	UserDao userDao;
	@Autowired
	AuthoritiesDao authDao;
	
	Gson gson = new Gson();
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> login(Locale locale, ModelMap model) {
		logger.info("Welcome login! The client locale is {}.", locale);
		
		
		return createJsonResponse("Authenticated");
	}
	
	@RequestMapping(value="/loginfailed", method = RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> loginerror(ModelMap model) {
 
		
		
		return createJsonResponse("Error Authentication");
 
	}
	
//	@RequestMapping(value = "request/newUser", method = RequestMethod.POST)
//	public @ResponseBody ResponseEntity<String> newUser(@RequestParam(value="username", required=true) String username,
//														@RequestParam(value="email", required=true) String email,
//														@RequestParam(value="password", required=true) String password,														
//														Model model) {
//		logger.info("Adding User Request");
//		
//		logger.info(username);
//		
//		Users u=new Users(username, password , true, email);
//		Authorities a=new Authorities(u, "ROLE_USER");
//		
//		userDao.addUser(u);
//		
//		authDao.addAuth(a);
// 		
//		return createJsonResponse( true );
//	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.POST)
	public @ResponseBody ResponseEntity<String> getUser(														
														Model model) {
		logger.info("Test");
		
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		

 		
		return createJsonResponse( user.getUsername() );
	}
	
	
	
	@RequestMapping(value = "/existUsername", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> existUsername(@RequestParam(value="username", required=true) String username,
    							
    							Model model) {
		logger.debug("Received request controll if exist "+username);
		
		return createJsonResponse( userDao.existUsername(username) );

	}
	
	@RequestMapping(value = "/existMail", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<String> existMail(@RequestParam(value="mail", required=true) String mail,
    							
    							Model model) {
		logger.debug("Received request controll if exist the mail "+mail);
		
		return createJsonResponse( userDao.existMail(mail) );

	}
	
	
    private ResponseEntity<String> createJsonResponse( Object o )
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String json = gson.toJson( o );
        return new ResponseEntity<String>( json, headers, HttpStatus.CREATED );
    }
	
	
  private Users getUsers(){
		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	    String name = user.getUsername(); //get logged in username
	    Users u=new Users(user.getUsername(),user.getPassword(),user.isEnabled(),null);
	    return u;
  }

}
