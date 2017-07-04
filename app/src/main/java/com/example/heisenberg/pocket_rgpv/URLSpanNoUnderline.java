package com.example.heisenberg.pocket_rgpv;

import android.text.TextPaint;
import android.text.style.URLSpan;

/**
 * Created by HeisenBerg on 4/10/2017.
 */

public class URLSpanNoUnderline extends URLSpan {

    public URLSpanNoUnderline(String p_URL){
        super(p_URL);
    }

    public void updateDrawState(TextPaint p_DrawState){
        super.updateDrawState(p_DrawState);
        p_DrawState.setUnderlineText(false);
    }
}
