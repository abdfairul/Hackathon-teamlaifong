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
 * How to load a model from a .obj file
 *
 * @author dennis.ippel
 *
 */
public class LoadFace extends RendererActivity {
    private Object3dContainer objModel;

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

        objModel = parser.getParsedObject();
        objModel.scale().x = objModel.scale().y = objModel.scale().z = .01f;
        scene.addChild(objModel);
    }

    @Override
    public void updateScene() {
        //objModel.rotation().y++;

    }
}
