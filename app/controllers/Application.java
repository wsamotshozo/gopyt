package controllers;

import play.*;
import play.mvc.*;
import play.cache.Cache;

import java.util.*;

import siena.*;
import com.google.appengine.api.memcache.ErrorHandlers;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import java.util.logging.Level;
import java.lang.Double;


import models.*;

public class Application extends Controller {

    public static void index() {
	List<Project> query = Project.all();
	List<Student> students = Student.all();
        render(query,students);
    }

    public static void setup() {
	Project jhs = new Project("John F Kennedy HS");
	Project vsb = new Project("Virginia State Beta");
	Project chs = new Project("Crossland High");
	Project ahs = new Project("Michael Test Students");
	Project asb = new Project("Lindsey Test Group");
	Project bhs = new Project("Test School");
	jhs.save();
	vsb.save();
	chs.save();
	ahs.save();
	asb.save();
	bhs.save();
        renderJSON("it was a success");
    }
    public static void temporary() {
	Student a = new Student();
	a.title = "Intelligence and Eloquence";
	a.picURL1 = "http://www.gopyt.com/ProjImages/Thumb_Img/Dexter_54_43.jpg";
	a.videoURL1 = "http://www.youtube.com/watch?v=ovMG0jrerhM";
	a.whoAmI = "I am a senior at Crossland and I am active in the Student Govt Association, BAND, and Mock Trial team.  I want to pursue a legal career.  I hope to be the first of my siblings to go college and graduate.  I am asking that with just one dollar a day that you can help to bring my student loan cost down. ";
	a.hobbiesInterests = "I like to travel, social networking, watching law show like LAW AND ORDER, SUITS, and FRANKLIN AND BASH. - I love tennis and I am actively working to get better to be able to maybe play on tennis team I volunteer currently at the District of Columbia Central Kitchen on Holidays My GPA is 4.3 - My Diploma will be the International Baccalaureate Diploma";
	a.academicInterests = "I love Biology and English";
	a.colleges = "Fordham Unversity, University of Maryland, North Carolina A & T Macaula Honors College Loyola University";
	a.school = "Crosslland  High School";
	a.picURL2 = "http://www.gopyt.com/ProfileUploads/53_Feeding%20America.jpg";
	a.lastName = "Heath";
	a.firstName = "Dexter";
	a.city ="Fairfax";
	a.save();
	renderJSON("it was a success");
	}

    public static void about() {
        render();
    }

    public static void howwework() {
        render();
    }

    public static void faq() {
        render();
    }
    public static void basicDetail(String firstName,String lastName,String email, String password, String  school) {
	Student s = new Student(school,firstName,lastName,email,password);
	s.save();
        render(s);
    }
    public static void getStarted(String id, String city,String zipcode,String facebook, String twitter, String  tumblr) {
	Student s = Student.findById(id);
	s.addSocialLinks(facebook,twitter,tumblr);
	s.addLocation(zipcode,city);
	s.save();
        render(s);
    }
    public static void aboutYou(String id,String school, double amount) {
	Student s = Student.findById(id);
	s.addSchool(school);
	s.addAmount(amount);
	s.save();
        render(s);
    }
    public static void addUser(String id, String hobbies, String academic, String colleges)
    {
	Student s  = Student.findById(id);
	s.colleges = colleges;
	s.hobbiesInterests = hobbies;
	s.academicInterests = academic;
	s.save();
	renderJSON(s);
    }
	

    public static void register(String firstName,String lastName,String email, String password, String  school) {
	MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
        cache.setErrorHandler(ErrorHandlers.getLogAndContinue(Level.INFO));
	Student s = new Student(school,firstName,lastName,email,password);
	s.save();
	cache.put("Student", s.id);
	List<Project> query = Project.all();
        render(s,query);
    }

    public static void register1(String city,String facebook, String zipcode, String twitter, String tumblr) {
	MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
        cache.setErrorHandler(ErrorHandlers.getLogAndContinue(Level.INFO));
	if(cache.contains("Student"))
	{
		String temp = (String)cache.get("Student");
		Student s = Student.findById(temp);
		s.city = city;
		s.zipcode = zipcode;
		s.facebook = facebook;
		s.twitter = twitter;
		s.tumblr = tumblr;
		s.save();
		cache.put("Student",s.id);
		List<Project> query = Project.all();
		render(s,query);
	}
	renderJSON("something went terribly wrong");
    }

    public static void register2(String school,String amount) {
	MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
        cache.setErrorHandler(ErrorHandlers.getLogAndContinue(Level.INFO));
	if(cache.contains("Student"))
	{
		String temp = (String)cache.get("Student");
		Student s = Student.findById(temp);
		s.school = school;
		s.amount = Double.parseDouble(amount);
		s.save();
		cache.put("Student",s.id);
		List<Project> query = Project.all();
		render(s,query);
	}
	renderJSON("something went terribly wrong");
    }

    public static void register3() {
	MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
        cache.setErrorHandler(ErrorHandlers.getLogAndContinue(Level.INFO));
	if(cache.contains("Student"))
	{
		String temp = (String)cache.get("Student");
		Student s = Student.findById(temp);
		s.save();
		cache.put("Student",s.id);
		List<Project> query = Project.all();
		render(s,query);
	}
	renderJSON("something went terribly wrong");
    }

    public static void register4(String hobbies, String interests, String colleges, String graduation, String celebrity, String nonprofit) {
	MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
        cache.setErrorHandler(ErrorHandlers.getLogAndContinue(Level.INFO));
	if(cache.contains("Student"))
	{
		String temp = (String)cache.get("Student");
		Student s = Student.findById(temp);
		s.hobbiesInterests = hobbies;
		s.academicInterests = interests;
		s.colleges = colleges;
		//s.expectedGrduationDate = graduation;
		s.celebrity = celebrity;
		s.nonprofit = nonprofit;
		s.save();
		cache.put("Student",s.id);
		List<Project> query = Project.all();
		render(s,query);
	}
	renderJSON("something went terribly wrong");
    }

    public static void register5(String title, String teaser, String description) {
	MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
        cache.setErrorHandler(ErrorHandlers.getLogAndContinue(Level.INFO));
	if(cache.contains("Student"))
	{
		String temp = (String)cache.get("Student");
		Student s = Student.findById(temp);
		s.title = title;
		s.teaser = teaser;
		s.whoAmI = description;
		s.save();
		cache.put("Student",s.id);
		List<Project> query = Project.all();
		render(s,query);
	}
	renderJSON("something went terribly wrong");
    }

    public static void register6() {
	MemcacheService cache = MemcacheServiceFactory.getMemcacheService();
        cache.setErrorHandler(ErrorHandlers.getLogAndContinue(Level.INFO));
	if(cache.contains("Student"))
	{
		String temp = (String)cache.get("Student");
		Student s = Student.findById(temp);
		s.save();
		cache.put("Student",s.id);
		List<Project> query = Project.all();
		render(s,query);
	}
	renderJSON("something went terribly wrong");
    }

    public static void login() {
        render();
    }

    public static void contactus() {
        render();
    }

    public static void schoolforsuccess() {
        render();
    }

    public static void signup() {
		List<Project> query = Project.all();
        render(query);
    }

    public static void student(String id) {
	Student result = Student.findById(id);
        render(result);
    }

    public static void terms() {
        render();
    }

    public static void studentList() {
        render();
    }

    public static void project(String id) {
	Project result = Project.findById(id);
        render(result);
    }

}
