package min3d.sampleProject1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import min3d.core.Object3dContainer;
import min3d.core.RendererActivity;
import min3d.parser.IParser;
import min3d.parser.Parser;
import min3d.vos.Light;

/**
 * Created by fasannan on 30/5/2015.
 */
public class LoadFaceAndFrame extends RendererActivity {

    private Object3dContainer face;
    private Object3dContainer spec;


    private final float DEGREE = (float)(Math.PI/180);

    @Override
    protected void onCreateSetContentView() {
        setContentView(R.layout.face_layout);

        Button mButton=(Button)findViewById(R.id.layoutOkay);
        mButton.setText("PRINT!");


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
        scene.lights().add(new Light());
        Light myLight = new Light();
        myLight.position.setZ(150);
        myLight.ambient.setAll(0x88000011);
        myLight.diffuse.setAll(0xff0000ff);
        scene.lights().add(myLight);

        IParser parser = Parser.createParser(Parser.Type.OBJ,
                getResources(), "min3d.sampleProject1:raw/face_obj", true);
        parser.parse();

        face = parser.getParsedObject();
        face.scale().x = face.scale().y = face.scale().z = .01f;
        scene.addChild(face);

        IParser parser2 = Parser.createParser(Parser.Type.OBJ,
                getResources(), "min3d.sampleProject1:raw/glasses_001_obj", true);
        parser2.parse();

        spec = parser2.getParsedObject();
        spec.scale().x = spec.scale().y = spec.scale().z = .01f;
        scene.addChild(spec);

    }
}
