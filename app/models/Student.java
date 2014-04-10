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
	public boolean active = true;
	public double totalRaisedForTuition;
	public double totalRaisedThisMonth;
	public double serviceHours;
	public String whoAmI;
	public String hobbiesInterests;
	public String academicInterests;
	public Date creationDate;
	public Date expectedGraduationDate;
	public String nonprofitPic;
	public String profilePic;
	public String picURL1;
	public String picURL2;
	public String picURL3;
	public String videoURL1;
	public String videoURL2;
	public String videoURL3;
	public String colleges;
	public String school;
	public double organizationHours;
	public double amount;
	public String teaser;
	public String nonprofit;
	public String celebrity;
	public String title = "";
	//whether or not to send mail to the user
	public boolean sendmail = true;

	//profile information
	public String email;
	public String password;
	public String phone;
	public String firstName;
	public String lastName;
	
	//questionable info
	public String city;
	public String zipcode;
	public String twitter;
	public String tumblr;
	public String facebook;

	public Student(){
		super();
		creationDate = new Date();
	}

	public Student(String nschool, String nfirstName, String nlastName, String nemail, String npassword){
		super();
		creationDate = new Date();
		school = nschool;
		firstName = nfirstName;
		lastName = nlastName;
		email = nemail;
		password = npassword;
	}

	public Student(String who, String hobbies, String academic, String firstname){
		super();
		creationDate = new Date();
		whoAmI = who;
		hobbiesInterests = hobbies;
		academicInterests = academic;
		firstName = firstname;
	}
	public void addSchool(String nschool)
	{
		school = nschool;
	}
	public void addAmount(double namount)
	{
		amount=namount;
	}
	public void addSocialLinks(String facebooklink, String twitterlink, String tumblrlink)
	{
		facebook = facebooklink;
		twitter = twitterlink;
		tumblr = tumblrlink;
	}	
	public void addLocation(String nzipcode, String ncity)
	{
		zipcode = nzipcode;
		city = ncity;
	}

	public static Student findById(String id){
		List<Student> all = Student.all();
		for(int i = 0; i < all.size(); i++)
		{
			if(all.get(i).id.equals(id))
			{
				return all.get(i);
			}
		}
		return null;
	}

        public static List<Student> all(){
                return Model.all(Student.class).fetch();
        }
	public String toString()
{
	return firstName + " " + lastName;
}

	

}

