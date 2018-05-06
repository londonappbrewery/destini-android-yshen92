package com.londonappbrewery.destini;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryBox;
    Button mTopButton;
    Button mBottomButton;
    Button mRestartButton;
    int mIndex;
    boolean mEnd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryBox = findViewById(R.id.storyTextView);
        mTopButton = findViewById(R.id.buttonTop);
        mBottomButton = findViewById(R.id.buttonBottom);
        mRestartButton = findViewById(R.id.buttonRestart);

        if (savedInstanceState != null){
            mIndex = savedInstanceState.getInt("IndexKey");
            mEnd = savedInstanceState.getBoolean("EndKey");
            mStoryBox.setText(savedInstanceState.getCharSequence("StoryKey"));
            mTopButton.setText(savedInstanceState.getCharSequence("TopButtonKey"));
            mBottomButton.setText(savedInstanceState.getCharSequence("BottomButtonKey"));

            checkEnd();
        }

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storyTellerTop();
                checkEnd();
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                storyTellerBottom();
                checkEnd();
            }
        });

        mRestartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIndex = 0;
                mEnd = false;
                mStoryBox.setText(R.string.T1_Story);
                mTopButton.setText(R.string.T1_Ans1);
                mBottomButton.setText(R.string.T1_Ans2);

                mTopButton.setVisibility(View.VISIBLE);
                mBottomButton.setVisibility(View.VISIBLE);
                mRestartButton.setVisibility(View.GONE);
            }
        });
    }

    public void storyTellerTop(){
        switch (mIndex){
            case 0:
                mStoryBox.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
                mIndex = 2;
                Log.d("Story","T3_story");
                break;
            case 1:
                mStoryBox.setText(R.string.T3_Story);
                mTopButton.setText(R.string.T3_Ans1);
                mBottomButton.setText(R.string.T3_Ans2);
                mIndex = 2;
                Log.d("Story","T3_story");
                break;
            case 2:
                mStoryBox.setText(R.string.T6_End);
                mEnd = true;
                Log.d("Story","T6_End");
                break;
        }
    }

    public void storyTellerBottom() {
        switch (mIndex){
            case 0:
                mStoryBox.setText(R.string.T2_Story);
                mTopButton.setText(R.string.T2_Ans1);
                mBottomButton.setText(R.string.T2_Ans2);
                mIndex = 1;
                Log.d("Story","T2_story");
                break;
            case 1:
                mStoryBox.setText(R.string.T4_End);
                Log.d("Story","T4_end");
                mEnd = true;
                break;
            case 2:
                mStoryBox.setText(R.string.T5_End);
                Log.d("Story","T5_end");
                mEnd = true;
                break;
        }
    }

    public void checkEnd(){
        if (mEnd)
        {
            mTopButton.setVisibility(View.GONE);
            mBottomButton.setVisibility(View.GONE);
            mRestartButton.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey",mIndex);
        outState.putBoolean("EndKey",mEnd);
        outState.putCharSequence("StoryKey",mStoryBox.getText());
        outState.putCharSequence("TopButtonKey",mTopButton.getText());
        outState.putCharSequence("BottomButtonKey",mBottomButton.getText());
    }
}
