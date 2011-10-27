package org.socio.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
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
    private Integer current_state[] = { 0, 0, 0, 0 };
    private Integer current_state_pos = 0;

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
            current_state_pos = 0;
            for (int i = 0; i < 4; ++i) {
                current_state[i] = 0;
            }
            break;

        case R.id.sub1:
            current_state[current_state_pos / 7] -= 1;
            sub_plus_common();
            break;

        case R.id.plus1:
            current_state[current_state_pos / 7] += 1;
            sub_plus_common();
            break;
        }
    }

    private void sub_plus_common() {
        current_state_pos += 1;

        if (current_state_pos / 7 == 4) {
            String st = SocioType.socio_type(current_state);
            String dt = SocioType.duals.get(st);

            show_result(st, dt);
        } else {
            sub1.setText(SocioType.sub_questions[current_state_pos]);
            plus1.setText(SocioType.plus_questions[current_state_pos]);
        }
    }

    private void show_result(String answ_text, String dual_text) {
        answer.setText(answ_text);
        answer.setVisibility(View.VISIBLE);
        answer_lbl.setVisibility(View.VISIBLE);

        dual.setText(dual_text);
        dual.setVisibility(View.VISIBLE);
        dual_lbl.setVisibility(View.VISIBLE);

        sub1.setEnabled(false);
        plus1.setEnabled(false);
    }

}
