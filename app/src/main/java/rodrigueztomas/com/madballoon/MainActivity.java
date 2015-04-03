package rodrigueztomas.com.madballoon;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;


public class MainActivity extends ActionBarActivity {

    private ImageView balloonImageView;
    private float start = 1.0f;
    private float end = 1.0f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        balloonImageView = (ImageView) findViewById(R.id.balloon);


    }

    public void InflateAnimation(View v)
    {
        Log.d("MainActivity", "InflateAnimation");

        if(start > end)
        {
            float temp = start;
            start = end;
            end = temp;
        }
        else
        {
            start = end;
            end *= 1.4;
        }

        ScaleAnimation grow = new ScaleAnimation(start, end, start, end,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        grow.setFillEnabled(true);
        grow.setFillAfter(true);
        grow.setDuration(600);

        balloonImageView.startAnimation(grow);
    }

    public void DeflateAnimation(View v)
    {
        if(start < end)
        {
            float temp = start;
            start = end;
            end = temp;
        }
        else
        {
            start = end;
            end /= 1.4f;
        }

        ScaleAnimation shrink = new ScaleAnimation(start, end, start, end,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        shrink.setFillEnabled(true);
        shrink.setFillAfter(true);
        shrink.setDuration(600);

        balloonImageView.startAnimation(shrink);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
