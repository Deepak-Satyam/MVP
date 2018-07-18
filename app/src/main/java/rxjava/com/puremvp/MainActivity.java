package rxjava.com.puremvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rxjava.com.puremvp.root.MyApp;

public class MainActivity extends AppCompatActivity implements WelcomeContract.View{

    @BindView(R.id.etWelceMessage)
    TextView etWelceMessage;
    @BindView(R.id.etFirstName)
    EditText etFirstName;
    @BindView(R.id.etLastName)
    EditText etLastName;
    @BindView(R.id.btnSubmit)
    Button btnSubmit;

    @Inject
    WelcomeContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ((MyApp)getApplication()).getApplicationComponent().inject(this);
       // presenter = new WelcomePresenter(this);
    }

    @OnClick(R.id.btnSubmit)
    public void onClick() {
        if(TextUtils.isEmpty(etFirstName.getText().toString())){

        }
        else{
            presenter.submitName(etFirstName.getText().toString(),etLastName.getText().toString());
            presenter.loadWelcomeMessage();
        }
    }

    @Override
    public void showWelcomeMessage(String welcomeMessage) {
        etWelceMessage.setText(welcomeMessage);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(MainActivity.this);
    }
}
