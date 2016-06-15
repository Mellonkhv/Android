package com.mellonkhv.beeradviser;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;


public class FindBeerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    private BeerExpert expert = new BeerExpert();

    // Вызов метода по жатию кнопки
    public void onClickFindBeer(View view) {
        // Получить ссылку на TextView
        TextView brands = (TextView) findViewById(R.id.brands);
        // Получить ссылку на Spinner
        Spinner color = (Spinner) findViewById(R.id.color);
        // Получить вариант выбраный в Spinner
        String beerType = String.valueOf(color.getSelectedItem());
        // Получить контейнер List с сортами пива
        List<String> brandsList = expert.getBrands(beerType);
        // Построить String по данным из List
        StringBuilder brandsFormatted = new StringBuilder();
        for (String brand:brandsList)
        {
            // Каждый сорт выводится с новой строки
            brandsFormatted.append(brand).append('\n');
        }
        // Отобразить подобраные сорта пива
        brands.setText(brandsFormatted);
    }
}
