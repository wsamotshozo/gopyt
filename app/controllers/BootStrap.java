package controllers;
import play.*;
import play.jobs.*;
import play.test.*;
 
import models.*;
 
@OnApplicationStart
public class BootStrap extends Job {
 
    public void doJob() {
        // Check if the database is empty
        if(0 == 0) {
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
        }
    }
 
}
