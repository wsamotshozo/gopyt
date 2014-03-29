package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import siena.*;


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
	Student s = new Student("I will give back with time to DKMS and my local food bank Oxon Hill Food Pantry.  I will go to school if I do not go to the airforce,But my main goal is to attend both. Going to college will help me out an make my parents proud,but going to the Air Force  will really help them out an i can give back to the community I promised my mother that i will pay her back for everything she has done for me. I love my family an i will just love to make my parents an grandmother proud!!!!!!! Going to school is important to me it's a higher education and that degree will help me out in money wise it's nothing better then having a high school diploma and being a college graduate.",
"Cosmetics,basketball,help the homeless, I also played in the band",
"english, science",
"Taqua");
	s.save();
	 s = new Student("I will give back with time to DKMS and my local food bank Oxon Hill Food Pantry.  I will go to school if I do not go to the airforce,But my main goal is to attend both. Going to college will help me out an make my parents proud,but going to the Air Force  will really help them out an i can give back to the community I promised my mother that i will pay her back for everything she has done for me. I love my family an i will just love to make my parents an grandmother proud!!!!!!! Going to school is important to me it's a higher education and that degree will help me out in money wise it's nothing better then having a high school diploma and being a college graduate.",
"Cosmetics,basketball,help the homeless, I also played in the band",
"english, science",
"no");
	s.save();
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

    public static void contactus() {
        render();
    }

    public static void schoolforsuccess() {
        render();
    }

    public static void signup() {
        render();
    }

    public static void student(String id) {
	Student result = Student.findById(id);
        render(result);
    }

    public static void studentList() {
        render();
    }

    public static void project(String id) {
	Project result = Project.findById(id);
        render(result);
    }

}
