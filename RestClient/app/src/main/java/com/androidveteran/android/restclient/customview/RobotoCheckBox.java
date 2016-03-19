package com.androidveteran.android.restclient.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.CheckBox;

import com.androidveteran.android.restclient.R;

/**
 * Created by chint on 3/19/2016.
 */
public class RobotoCheckBox extends CheckBox {
    public RobotoCheckBox(Context context) {
        super(context);
    }

    public RobotoCheckBox(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(attrs);
    }

    public RobotoCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public RobotoCheckBox(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        setFont(attrs);
    }

    public void setFont(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.roboto);
            int font = typedArray.getInteger(R.styleable.roboto_font, 9);
            Typeface myTypeface = Typeface
                    .createFromAsset(
                            getContext().getAssets(),
                            "fonts/" + getResources().getStringArray(R.array.roboto_fonts)[font]
                    );
            setTypeface(myTypeface);
            typedArray.recycle();
        }
    }
}
