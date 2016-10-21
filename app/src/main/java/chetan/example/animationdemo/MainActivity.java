package chetan.example.animationdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity
{

    Button mCrossFadeAnimButton;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCrossFadeAnimButton = ( Button )findViewById( R.id.cross_fade_anim_button );
        mCrossFadeAnimButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent( MainActivity.this, ActivityCrossFadingViewAnimation.class);
                startActivity( intent );
            }
        });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
    }

}
