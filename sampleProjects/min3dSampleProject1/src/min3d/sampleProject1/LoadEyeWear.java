package min3d.sampleProject1;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;

/**
 * Created by fasannan on 30/5/2015.
 */
public class LoadEyeWear extends RendererActivity{
    private Object3dContainer face;

    @Override
    protected void onCreateSetContentView()
    {
        setContentView(R.layout.face_layout);

        LinearLayout ll = (LinearLayout) this.findViewById(R.id.faceholder);
        ll.addView(_glSurfaceView);
    }

    public void sendMessage(View view) {
        // Intent(context, class to send the intent to)
        // this Intent will call another activity (DisplayMesageActivity)
        Intent intent = new Intent(this, Step2.class);
        startActivity(intent);
    }

    @Override
    public void initScene() {

        scene.lights().add(new Light());

        IParser parser = Parser.createParser(Parser.Type.OBJ,
                getResources(), "min3d.sampleProject1:raw/face_obj", true);
        parser.parse();

        face = parser.getParsedObject();
        face.scale().x = face.scale().y = face.scale().z = .01f;
        scene.addChild(face);

    }

    @Override
    public void updateScene() {
        face.rotation().y++;
        face.rotation().x++;

    }


}
