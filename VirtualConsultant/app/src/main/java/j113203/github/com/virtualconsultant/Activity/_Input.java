package j113203.github.com.virtualconsultant.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.otaliastudios.autocomplete.Autocomplete;

import j113203.github.com.virtualconsultant.Autocomplete.Callback_Input;
import j113203.github.com.virtualconsultant.Autocomplete.Policy_Input;
import j113203.github.com.virtualconsultant.Autocomplete.Presenter_Input;
import j113203.github.com.virtualconsultant.Model.Model_Symptoms;
import j113203.github.com.virtualconsultant.R;

public class _Input extends Activity implements TextView.OnEditorActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        inputLabel = findViewById(R.id.inputLabel);

        setResult(RESULT_CANCELED);

        Autocomplete.<Model_Symptoms>on(inputLabel)
                .with(6f)
                .with(new Policy_Input())
                .with(new Presenter_Input(this))
                .with(new Callback_Input())
                .build();

        inputLabel.setOnEditorActionListener(this);

    }

    private EditText inputLabel;

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {

        if (i == EditorInfo.IME_ACTION_DONE) {
            setResult(RESULT_OK);
            finish();
        }
        return true;
    }
}
