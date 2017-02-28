package firstproject.com.techmate;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by user on 02-09-2016.
 */
public class Config extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}