package j113203.github.com.virtualconsultant.Autocomplete;

import android.graphics.Typeface;
import android.text.Editable;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.util.Log;

import com.otaliastudios.autocomplete.AutocompleteCallback;
import com.otaliastudios.autocomplete.CharPolicy;

import j113203.github.com.virtualconsultant.Model.Model_Symptoms;

/**
 * Created by j113203 on 28/12/2017.
 */

public class Callback_Input implements AutocompleteCallback<Model_Symptoms> {

    @Override
    public boolean onPopupItemClicked(Editable editable, Model_Symptoms item) {

        editable.clear();
        editable.append(item.getEngName());
//        Log.e("j11","clicked");
//        int[] range = CharPolicy.getQueryRange(editable);
//        if (range == null) return false;
//        int start = range[0];
//        int end = range[1];
//        String replacement = item.getEngName();
//        editable.replace(start, end, replacement);
//        editable.setSpan(new StyleSpan(Typeface.BOLD), start, start + replacement.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return true;
    }

    @Override
    public void onPopupVisibilityChanged(boolean shown) {

    }

}
