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
public class Student extends Model {
	@Id(Generator.UUID)
	public String id;
	public double totalRaisedForTuition;
	public double totalRaiseedThisMonth;
	public double serviceHours;
	public String whoAmI;
	public String hobbiesInterests;
	public String academicInterests;
	public Date creationDate;
	public Date expectedGraduationDate;
	public String nonprofitPic;
	public String profilePic;
	public String colleges;
	public String school;
	public double organizationHours;
	//whether or not to send mail to the user
	public boolean sendmail = false;

	//profile information
	public String email;
	public String password;
	public String phone;
	public String firstName;
	public String lastName;

	public Student(){
		super();
		creationDate = new Date();
	}

	public Student(String who, String hobbies, String academic, String firstname){
		super();
		creationDate = new Date();
		whoAmI = who;
		hobbiesInterests = hobbies;
		academicInterests = academic;
		firstname = firstname;
	}

	public static Student findById(String id){
		return Model.all(Student.class).filter("id",id).get();
	}

        public static List<Student> all(){
                return Model.all(Student.class).fetch();
        }

	

}

