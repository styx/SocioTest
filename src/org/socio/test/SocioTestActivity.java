package org.socio.test;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import org.socio.test.SocioType;

public class SocioTestActivity extends Activity {
    private Button sub1;
    private Button plus1;

    private TextView answer;
    private TextView answer_lbl;
    private TextView dual;
    private TextView dual_lbl;

    private State current_state = new State();

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        answer     = (TextView) findViewById(R.id.answer);
        answer_lbl = (TextView) findViewById(R.id.answer_lbl);
        dual       = (TextView) findViewById(R.id.dual);
        dual_lbl   = (TextView) findViewById(R.id.dual_lbl);
        sub1       = (Button) findViewById(R.id.sub1);
        plus1      = (Button) findViewById(R.id.plus1);

        // Set first Q
        sub1.setText(SocioType.sub_questions[0]);
        plus1.setText(SocioType.plus_questions[0]);

        answer.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(current_state.url_s));
                startActivity(intent);
            }
        });

        dual.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(current_state.url_d));
                startActivity(intent);
            }
        });
    }

    public void mainClickHandler(View view) {
        switch (view.getId()) {
        case R.id.reset:
            // Reset current state to initial
            answer.setVisibility(View.INVISIBLE);
            answer_lbl.setVisibility(View.INVISIBLE);
            dual.setVisibility(View.INVISIBLE);
            dual_lbl.setVisibility(View.INVISIBLE);

            sub1.setEnabled(true);
            plus1.setEnabled(true);

            sub1.setText(SocioType.sub_questions[0]);
            plus1.setText(SocioType.plus_questions[0]);
            current_state = new State();
            break;

        case R.id.sub1:
            current_state.dec();
            sub_plus_common();
            break;

        case R.id.plus1:
            current_state.inc();
            sub_plus_common();
            break;

        }
    }

    private void sub_plus_common() {
        if (current_state.is_done()) {
            show_result();
        } else {
            sub1.setText(current_state.sub_question());
            plus1.setText(current_state.plus_question());
        }
    }

    private void show_result() {
        answer.setText(current_state.socio_type);
        answer.setVisibility(View.VISIBLE);
        answer_lbl.setVisibility(View.VISIBLE);

        dual.setText(current_state.dual_type);
        dual.setVisibility(View.VISIBLE);
        dual_lbl.setVisibility(View.VISIBLE);

        sub1.setEnabled(false);
        plus1.setEnabled(false);
    }

}
