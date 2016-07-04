package com.mellonkhv.workout;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void itemClicked(long id){
        View fragmentContainer = findViewById(R.id.fragment_container);
        if(fragmentContainer != null) {
            WorkoutDetailFragment details = new WorkoutDetailFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction(); // Начало транзакции
            details.setWorkout(id); // Получаем конкретный фрагмент
            transaction.replace(R.id.fragment_container, details); // Заменяем фрагмент
            transaction.addToBackStack(null); // Добавляем фрагмент в стек возврата
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE); // Анимируем переход
            transaction.commit(); // Подтверддаем транзакцию
        } else {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id);
            startActivity(intent);
        }
    }
}
