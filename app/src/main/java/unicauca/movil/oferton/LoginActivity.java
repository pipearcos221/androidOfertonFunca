package unicauca.movil.oferton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import unicauca.movil.oferton.databinding.ActivityLoginBinding;
import unicauca.movil.oferton.util.Preference;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;
    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        preferences = getSharedPreferences(Preference.PREFERENCE_NAME, MODE_PRIVATE);
        boolean logged =  preferences.getBoolean(Preference.KEY_LOGGED, false);
        if(logged){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            return;
        }

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        binding.setHandler(this);


    }

    public void goToMain(){

        String username =  binding.username.getEditText().getText().toString();

        SharedPreferences.Editor editor =  preferences.edit();
        editor.putString(Preference.KEY_EMAIL, username);
        editor.putBoolean(Preference.KEY_LOGGED, true);
        editor.apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
