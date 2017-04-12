package com.example.user.travelhelper;

import android.app.AlertDialog;
import android.app.Dialog;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

/**
 * Created by User on 4/8/2017.
 */

public class ConfirmationDialogFragment extends DialogFragment  {
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // создаём строителя
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        // добавляем заголовок
        builder.setTitle("Сделайте ваш выбор!");
        // создаём действие при нажатии на ОК
        DialogInterface.OnClickListener okClickListener = new DialogInterface.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(getContext(), TheBestWayActivity.class);
                getContext().startActivity(intent);
            }
        };
        // добавляем кнопочку OK с уже созданным действием
        builder.setPositiveButton("Лучший маршрут", okClickListener);
        DialogInterface.OnClickListener cancelClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        };
        builder.setPositiveButton("Свой маршрут", okClickListener);


        // просим строителя построить диалог и возвращаем его из метода
        return builder.create();
    };

}
