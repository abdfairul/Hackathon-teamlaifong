package min3d.sampleProject1;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import min3d.core.RendererActivity;

/**
 * Created by fasannan on 29/5/2015.
 */
public class Homepage extends RendererActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homepage_layout);
    }

    public void sendMessage(View view) {
        // Intent(context, class to send the intent to)
        // this Intent will call another activity (DisplayMesageActivity)
        Intent intent = new Intent(this, Step1.class);
        startActivity(intent);
    }
}
