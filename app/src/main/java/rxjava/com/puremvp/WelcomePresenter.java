package rxjava.com.puremvp;

public class WelcomePresenter implements WelcomeContract.Presenter{
    private WelcomeContract.View view;
    private WelcomeContract.Model model;

    public WelcomePresenter(WelcomeContract.Model model) {
        this.model = model;

    }

    @Override
    public void setView(WelcomeContract.View view) {
        this.view = view;
    }

    @Override
    public void loadWelcomeMessage() {
        view.showWelcomeMessage(model.getWelcomeMessage());
    }

    @Override
    public void submitName(String firstName, String lastName) {
        model.setDetails(firstName, lastName);
    }
}
