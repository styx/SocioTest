package org.socio.test;

import java.util.*;

public class SocioType {

    private final static HashMap<String, String> socio_types = new HashMap<String, String>();
    static {
        socio_types.put("0000", "Штирлиц");
        socio_types.put("0001", "М. Горький");
        socio_types.put("0010", "Джек Лондон");
        socio_types.put("0011", "Робеспьер");
        socio_types.put("0100", "Гюго");
        socio_types.put("0101", "Драйзер");
        socio_types.put("0110", "Гамлет");
        socio_types.put("0111", "Достоевский");
        socio_types.put("1000", "Жуков");
        socio_types.put("1001", "Габен");
        socio_types.put("1010", "Дон Кихот");
        socio_types.put("1011", "Бальзак");
        socio_types.put("1100", "Наполеон");
        socio_types.put("1101", "Дюма");
        socio_types.put("1110", "Гексли");
        socio_types.put("1111", "Есенин");
    }

    private final static HashMap<String, String> socio_url = new HashMap<String, String>();
    static {
        socio_url.put("Штирлиц", "lse");
        socio_url.put("М. Горький", "lsi");
        socio_url.put("Джек Лондон", "lie");
        socio_url.put("Робеспьер", "lii");
        socio_url.put("Гюго", "ese");
        socio_url.put("Драйзер", "esi");
        socio_url.put("Гамлет", "eie");
        socio_url.put("Достоевский", "eii");
        socio_url.put("Жуков", "sle");
        socio_url.put("Габен", "sli");
        socio_url.put("Дон Кихот", "ile");
        socio_url.put("Бальзак", "ili");
        socio_url.put("Наполеон", "see");
        socio_url.put("Дюма", "sei");
        socio_url.put("Гексли", "iee");
        socio_url.put("Есенин", "iei");
    }

    public final static HashMap<String, String> duals = new HashMap<String, String>();
    static {
        duals.put("Дон Кихот", "Дюма");
        duals.put("Робеспьер", "Гюго");
        duals.put("Гамлет", "М. Горький");
        duals.put("Есенин", "Жуков");
        duals.put("Джек Лондон", "Драйзер");
        duals.put("Бальзак", "Наполеон");
        duals.put("Гексли", "Габен");
        duals.put("Достоевский", "Штирлиц");
        // ---
        duals.put("Дюма", "Дон Кихот");
        duals.put("Гюго", "Робеспьер");
        duals.put("М. Горький", "Гамлет");
        duals.put("Жуков", "Есенин");
        duals.put("Драйзер", "Джек Лондон");
        duals.put("Наполеон", "Бальзак");
        duals.put("Габен", "Гексли");
        duals.put("Штирлиц", "Достоевский");
    }

    public final static String sub_questions[] = { "систематический",
            "структура", "план", "решение", "систематичность",
            "организованный", "подготовка", "решительный", "твердый",
            "склонный к критике", "преимущество", "голова", "мысли",
            "анализировать", "фактический", "применение на практике", "опыт",
            "рассудительный", "практик", "реалист", "реальность", "шумный",
            "оживленный", "общительность", "расходование энергии",
            "ориентированный во внешний мир", "высказываться вслух", "отважный" };

    public final static String plus_questions[] = { "спонтанный", "течение",
            "импровизация", "импульс", "случайность", "импульсивный",
            "экспромт", "преданный", "мягкосердечный", "доброжелательный",
            "удача", "сердце", "чувства", "симпатизировать", "теоретический",
            "поиск скрытого смысла", "теории", "удивительный", "фантазер",
            "мечтатель", "перспективность", "тихий", "спокойный",
            "сосредоточенность", "сохранение энергии",
            "ориентированный внутрь себя", "переживать в себе", "хладнокровный" };

    public static final String socio_type(Integer quadros[]) {
        String tmp = "";
        for (int i = 0; i < 4; ++i) {
            if (quadros[i] > 0)
                tmp += "1";
            else
                tmp += "0";
        }

        return socio_types.get(tmp);
    }

    public static final String url_for(String type) {
        return "http://www.socionika.info/tip/" + socio_url.get(type) + ".html";
    }
}
