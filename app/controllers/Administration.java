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

import com.dwolla.java.sdk.DwollaCallback;
import com.dwolla.java.sdk.DwollaServiceAsync;
import com.dwolla.java.sdk.DwollaServiceSync;
import com.dwolla.java.sdk.DwollaTypedBytes;
import com.dwolla.java.sdk.requests.SendRequest;
import com.dwolla.java.sdk.responses.BasicAccountInformationResponse;
import com.dwolla.java.sdk.responses.SendResponse;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.Server;
import retrofit.client.Response;

import models.*;

public class Administration extends Controller {

    public static void test() {
        render();
    }

    public static void project(String id) {
	Project result = Project.findById(id);
        render(result);
    }

}
