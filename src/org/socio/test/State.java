package org.socio.test;

public class State {
    public Integer results[] = { 0, 0, 0, 0 };
    public Integer pos = 0;
    public String  socio_type = "";
    public String  dual_type = "";
    public String  url_s = "";
    public String  url_d = "";

    public void dec() {
        results[pos / 7] -= 1;
        common_step();
    }

    public void inc() {
        results[pos / 7] += 1;
        common_step();
    }

    private void common_step() {
        pos += 1;
    }

    public boolean is_done() {
        if (pos / 7 == 4) {
            socio_type = SocioType.socio_type(results);
            dual_type  = SocioType.duals.get(socio_type);
            url_s = SocioType.url_for(socio_type);
            url_d = SocioType.url_for(dual_type);
            return true;
        } else {
            return false;
        }
    }

    public String sub_question() {
        return SocioType.sub_questions[pos];
    }

    public String plus_question() {
        return SocioType.plus_questions[pos];
    }
}
