package rxjava.com.puremvp;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class WelcomeModule {

    @Provides @Singleton
    public WelcomeContract.Presenter provideWelcomePresenter(WelcomeContract.Model model){
        return new WelcomePresenter(model);
    }

    @Provides @Singleton
    public WelcomeContract.Model provideWelcomeContractModel(){
        return new UserDataManager();
    }
}
