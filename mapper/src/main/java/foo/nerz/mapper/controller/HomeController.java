package foo.nerz.mapper.controller;

import java.io.File;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.google.gson.Gson;



import foo.nerz.mapper.repository.CityRepo;
import foo.nerz.mapper.repository.CountryRepo;



/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	Gson gson = new Gson();
	
	@Autowired CityRepo repository;
	
	@Autowired CountryRepo repoCountry;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		
//		String formattedDate = dateFormat.format(date);
//		
//		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@RequestMapping(value = "country", method = RequestMethod.GET)
	public ResponseEntity<String> country(Locale locale, Model model) {
		logger.info("Welcome home! the clientry request country");

		
		 
		
		return createJsonResponse(repoCountry.findAll());
	}
	
	@RequestMapping(value = "city", method = RequestMethod.GET,params="s")
	public ResponseEntity<String> city(@RequestParam(value = "s") String s) {
		logger.info("Welcome home! the clientry request city");

		
		 
		
		return createJsonResponse(repository.findByNameRegex("^"+s, new PageRequest(0, 20,new Sort(new Order(Direction.DESC, "population")))));
	}
	
	@RequestMapping(value="page", method = RequestMethod.GET, params= "page")
	public String getPage(@RequestParam(value = "page") String page){
		logger.info("request for the page "+page);
		
		return "generated"+File.separator+page;
	}
	
	
	
	
	
    
    
    private ResponseEntity<String> createJsonResponse( Object o )
    {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String json = gson.toJson( o );
        return new ResponseEntity<String>( json, headers, HttpStatus.CREATED );
    }
    
//    private Users getUsers(){
//		User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//	    String name = user.getUsername(); //get logged in username
//	    Users u=new Users(user.getUsername(),user.getPassword(),user.isEnabled(),null);
//	    return u;
//    }
	
}
