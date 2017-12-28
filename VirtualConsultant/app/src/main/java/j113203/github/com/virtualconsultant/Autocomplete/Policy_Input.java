package j113203.github.com.virtualconsultant.Autocomplete;

import android.text.Spannable;

import com.otaliastudios.autocomplete.AutocompletePolicy;

/**
 * Created by j113203 on 28/12/2017.
 */

public class Policy_Input implements AutocompletePolicy {

    @Override
    public boolean shouldShowPopup(Spannable text, int cursorPos) {
        return text.length() > 0;
    }

    @Override
    public boolean shouldDismissPopup(Spannable text, int cursorPos) {
        return text.length() == 0;
    }

    @Override
    public CharSequence getQuery(Spannable text) {
        return text;
    }

    @Override
    public void onDismiss(Spannable text) {}

}
