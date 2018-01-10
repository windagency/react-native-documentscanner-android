package com.documentscanner.views;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.documentscanner.R;
import com.facebook.react.bridge.WritableMap;

/**
 * Created by andre on 09/01/2018.
 */

public class MainView extends FrameLayout{
    private OpenNoteCameraView view = null;

    public MainView(Context context, Activity activity) {
        super(context);
        LayoutInflater lf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FrameLayout fl = (FrameLayout) lf.inflate(R.layout.activity_open_note_scanner,null);

        view = new OpenNoteCameraView(context, -1, activity, fl);

        addView(view);
        addView(fl);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        for(int i = 0 ; i < getChildCount() ; i++){
            getChildAt(i).layout(l, t, r, b);
        }
    }


    void setDocumentAnimation(boolean animate){
        view.setDocumentAnimation(animate);
    }

    void setDetectionCountBeforeCapture(int numberOfRectangles){
        view.setDetectionCountBeforeCapture(numberOfRectangles);
    }

    void setEnableTorch(boolean enable){
        view.setEnableTorch(enable);
    }

    public void setOnScannerListener(OpenNoteCameraView.OnScannerListener listener){
        view.setOnScannerListener(listener);
    }

}
