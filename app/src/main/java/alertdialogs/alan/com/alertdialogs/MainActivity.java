package alertdialogs.alan.com.alertdialogs;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {


    private Button showDialogue;
    private AlertDialog.Builder dialogue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialogue = (Button) findViewById(R.id.showButtonId);

        showDialogue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //show Alert Dialogue
                dialogue = new AlertDialog.Builder(MainActivity.this);

                //set Title
                dialogue.setTitle(getResources().getString(R.string.dialogue_title));
                //set Message
                dialogue.setMessage(getResources().getString(R.string.dialogue_message));
                //set Cancellable
                dialogue.setCancelable(false);

                //set icon
                dialogue.setIcon(android.R.drawable.btn_star);

                //set positive Button
                dialogue.setPositiveButton(getResources().getString(R.string.positive_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                //exit activity
                                MainActivity.this.finish();
                            }
                        });

                //set Negative
                dialogue.setNegativeButton(getResources().getString(R.string.negative_button),
                        new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.cancel();
                            }
                        });

                //create Dialogue object
                AlertDialog alertD = dialogue.create();

                alertD.show();
            }
        });
    }
}
