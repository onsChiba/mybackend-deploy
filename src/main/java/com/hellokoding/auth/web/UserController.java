package com.hellokoding.auth.web;

import com.hellokoding.auth.model.PoissonFavoris;
import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.PoissonRepos;
import com.hellokoding.auth.service.SecurityService;
import com.hellokoding.auth.service.UserService;
import com.hellokoding.auth.validator.UserValidator;

import java.util.List;
import org.springframework.validation.Errors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins ="*", allowedHeaders = "*")//, allowCredentials = "true")
@RequestMapping(value = "/User")
@Controller
public class UserController {
	
	Error errors = new Error();
    @Autowired
    private UserService userService;
    @Autowired
	private PoissonRepos poissonrepo;
    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

 /*   @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }*/

  /*  @RequestMapping(value = "/saveUser")
	@CrossOrigin("*")
    public User registration(@RequestBody  User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return null;
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return userForm;
    }*/

    @GetMapping("/login")
    @CrossOrigin("*")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }
    @RequestMapping(value = "/saveUser")
	@CrossOrigin("*")
	public User saveUser(@RequestBody User userForm)
	{
    	
		userService.save(userForm);

		return userForm;
		
	}
    
    
    @GetMapping("/")
    String hello() {
    	return "hello" ;
    }
	
	@RequestMapping(value = "/findUser/{email}")
	@CrossOrigin("*")
	public User findUser(@PathVariable ("email") String email)
	{
		 return userService.findByEmail(email);
		
		
	}
	
	@PutMapping(value = "/updateUser")
	@CrossOrigin("*")
	public User updateAbonne(@RequestBody User ab)
	
	{
		userService.updateAbonne(ab);
		return ab;
	}
	
	@PutMapping(value = "/updateUser/{firstname}")
	@CrossOrigin("*")
	public User updatefishAbonne(@PathVariable(value = "firstname") String firstname, @RequestBody String fishes)
	{
		
          User ab= userService.findByFirstname(firstname) ;
         
          PoissonFavoris poissontrouve =poissonrepo.findByName(fishes);
         ab.addPoissons(poissontrouve);;
        
         userService.updateAbonne(ab);
		return ab;
	}
	
	@RequestMapping(value = "/findbynameUser/{firstname}")
	@CrossOrigin("*")
	public User fishAbonne(@PathVariable(value = "firstname") String firstname)
	{
				return userService.findByFirstname(firstname) ;
	}
	
	
	@DeleteMapping(value = "/deleteUser/{id}")
	
	@CrossOrigin(origins = "*", allowedHeaders = "*", allowCredentials = "true")
	public void deleteAbonne(@PathVariable ("id") Long id)
	{
		userService.deleteUser(id);
		
	}
	
	@RequestMapping(value = "/getAllUsers")
	@CrossOrigin("*")
	public List<User> getAllusers()
	{
		return userService.getAllAbonne();	
	}

}

    

