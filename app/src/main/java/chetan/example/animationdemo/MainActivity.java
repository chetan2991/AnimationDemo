package chetan.example.animationdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    Button  mStartClockWiseAnimationButton;
    ImageView mImageView;
    Animation mAnimation;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mStartClockWiseAnimationButton = ( Button ) findViewById( R.id.startclockwiseanimationbutton );
        mImageView = ( ImageView ) findViewById( R.id.welcometextimage );
        mAnimation = AnimationUtils.loadAnimation( getApplicationContext(), R.anim.clockwiseanimation );
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        mImageView.startAnimation( mAnimation );
    }
}
