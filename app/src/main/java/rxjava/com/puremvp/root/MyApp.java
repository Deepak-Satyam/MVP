package rxjava.com.puremvp.root;

import android.app.Application;

import rxjava.com.puremvp.WelcomeModule;

public class MyApp extends Application{

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .welcomeModule(new WelcomeModule())
                .build();
    }
}
