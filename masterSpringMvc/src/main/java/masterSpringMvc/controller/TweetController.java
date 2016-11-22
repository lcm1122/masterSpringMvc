package masterSpringMvc.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.SearchResults;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TweetController {
	@Autowired
	private Twitter twitter;
	
	
	/*
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello, world!";
	}
	*/
	
	/*
	@RequestMapping("/")
	public String hello() {
	  return "resultPage";
	}	
	*/
	
	/*
	@RequestMapping("/")
	//public String hello(@RequestParam("name") String userName, Model model) {
	public String hello(@RequestParam(value = "name", required = false, defaultValue = "world") String userName, Model model) { 	//	required and defaultValue
	  model.addAttribute("message", "Hello11, "+userName);
	  return "resultPage";
	}	
	*/
	
	@RequestMapping("/")
	public String home() {
	  return "searchPage";
	}
	
	@RequestMapping(value = "/postSearch", method = RequestMethod.POST)
	public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	  String search = request.getParameter("search");
	  
	  if (search.toLowerCase().contains("struts")) {
		  redirectAttributes.addFlashAttribute("error", "Try using spring instead!");
		  return "redirect:/";
	  }
	  
	  redirectAttributes.addAttribute("search", search);
	  return "redirect:result";
	}	
	
	@RequestMapping("/result")
	public String hello(@RequestParam(defaultValue =	"masterSpringMVC4") String search, Model model) {
	  SearchResults searchResults = twitter.searchOperations().	search(search);
	  //String text = searchResults.getTweets().get(0).getText();
	  //model.addAttribute("message", text);
	  
	  List<Tweet> tweets = searchResults.getTweets();
	  /*
	  List<String> tweets =
			  searchResults.getTweets()
			  .stream()
			  .map(Tweet::getText)
			  .collect(Collectors.toList());
	 */		  
	  model.addAttribute("tweets", tweets);
	  model.addAttribute("search", search);
	  
	  return "resultPage";
	}	
	
	
	/*
	MasterSpringMvc4-lcm1122
	Access level	Read and write (modify app permissions)
    Consumer Key (API Key)	PBNPeVieoK9refo42Aei0rs9q (manage keys and access tokens)
    Callback URL	http://127.0.0.1:9090
    Callback URL Locked	No
    Sign in with Twitter	Yes
    App-only authentication	https://api.twitter.com/oauth2/token
    Request token URL	https://api.twitter.com/oauth/request_token
    Authorize URL	https://api.twitter.com/oauth/authorize
    Access token URL	https://api.twitter.com/oauth/access_token	
*/
}
