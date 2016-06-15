package com.mellonkhv.sratbuzz;

/**
 * Created by nvarfolomeev on 27.05.2016.
 */
public class Drink {
    private String name;
    private String description;
    private int imageResourceId;

    // drinks - массив с элементами Drink
    public static final Drink[] drinks = {
            new Drink("Latte", "A couple of espresso shots with steamed milk", R.drawable.latte),
            new Drink("Cappuccino", "Espresso, hot milk, and a steamed milk foam", R.drawable.cappuccino),
            new Drink("Filter", "Highest quality beans roasted and brewed fresh", R.drawable.coffe)
    };

    //============ CONSTRUCTOR =============
    // Для каждого напитка хранится имя, описание и ресурс изображения
    private Drink(String name, String description, int imageResourceId) {
        this.name = name;
        this.description = description;
        this.imageResourceId = imageResourceId;
    }

    //============= GETTER & SETTER ==============
    public String getDescription(){
        return description;
    }

    public String getName(){
        return name;
    }

    public int getImageResourceId(){
        return imageResourceId;
    }

    // В качестве строкового представления Drink используется название напитка.
    public String toString(){
        return this.name;
    }
}
