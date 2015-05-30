package min3d.sampleProject1;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by fasannan on 29/5/2015.
 */
public class Homepage extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.homepage_layout);

        registerForContextMenu(getListView());
    }

    public void sendMessage(View view) {
        // Intent(context, class to send the intent to)
        // this Intent will call another activity (DisplayMesageActivity)
        Intent intent = new Intent(this, Step1.class);
        startActivity(intent);
    }


    //

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        super.onCreateOptionsMenu(menu);

        int i = 0;
        menu.add(0, 0, i++, "Project Home");
        menu.add(0, 1, i++, "Official Site");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        Intent i;

        switch (item.getItemId())
        {
            case 0:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(this.getResources().getString(R.string.projectUrl)));
                startActivity(i);
                return true;

            case 1:
                i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse( this.getResources().getString(R.string.siteUrl) ));
                startActivity(i);
                return true;
        }
        return false;
    }

}
