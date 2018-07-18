package rxjava.com.puremvp.root;

import javax.inject.Singleton;

import dagger.Component;
import rxjava.com.puremvp.MainActivity;
import rxjava.com.puremvp.WelcomeModule;

@Singleton
@Component(modules = {WelcomeModule.class})
public interface ApplicationComponent {
    void inject(MainActivity mainActivity);
}
