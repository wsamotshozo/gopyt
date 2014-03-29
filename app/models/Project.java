package models;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import com.google.gson.Gson;

import play.Play;
import play.data.validation.CheckWith;
import play.data.validation.Email;
import play.data.validation.Equals;
import play.data.validation.Match;
import play.data.validation.MaxSize;
import play.data.validation.Min;
import play.data.validation.MinSize;
import play.data.validation.Password;
import play.data.validation.Phone;
import play.data.validation.Required;
import play.libs.Codec;
import play.libs.Crypto;
import play.libs.Crypto.HashType;

import siena.*;
import siena.embed.Embedded;
import siena.embed.Embedded.Mode;
/*
import utils.UsernameCheck;
import utils.EmailCheck;
import utils.PhoneNumberCheck;
*/
public class Project extends Model {
	@Id(Generator.UUID)
	public String id;
	public double total;
	public String title;
	public String picture;
	public Date creationDate;

	public Project(){
		super();
		creationDate = new Date();
	}

	public Project(String name){
		super();
		creationDate = new Date();
		title = name;
	}

	public static Project findById(String id){
		return Project.all(Project.class).filter("id",id).get();
	}

	public static List<Project> all(){
		return Model.all(Project.class).fetch();
	}
	
	/*public static int count(){
		return Model.all(Project.class).findRowCount();
	}*/
	

}

