package com.dam.as_ue_tarea_uf42;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.snackbar.Snackbar;

public class SizeDialog extends DialogFragment {

    EditText etSize;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
       View v = getActivity().getLayoutInflater().inflate(R.layout.dialog_size, null);

         etSize = v.findViewById(R.id.etSize);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(v);

        builder.setTitle("Change Text Size").setPositiveButton("Accept", null).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialogInterface) {
                Button btn = ((AlertDialog) dialogInterface).getButton(DialogInterface.BUTTON_POSITIVE);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (etSize.getText().toString().isEmpty()){
                            Snackbar.make(view, "El tamaño no puede estar vacío", Snackbar.LENGTH_SHORT).show();
                        } else {
                            int txtSize = Integer.parseInt(etSize.getText().toString());
                            if (txtSize < 0) {
                                Snackbar.make(view, "El tamaño debe ser mayor que 0", Snackbar.LENGTH_SHORT).show();
                            } else {
                                alertDialog.dismiss();
                                MainActivity.TAM = txtSize;
                            }
                        }

                    }
                });
            }
        });

        return alertDialog;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
