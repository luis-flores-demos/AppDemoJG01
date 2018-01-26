package demos.lafm.demojg1.custom;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import demos.lafm.demojg1.R;

import static android.support.v7.app.AlertDialog.Builder;

/**
 * Created by Gabino on 03/07/2017.
 */

public class Utils {



    public static void showAlert(final Context context, String message) {

        try{

        Builder dialogBuilder = new Builder(context);

        final View dialogView = LayoutInflater.from(context).inflate(R.layout.layout_alert_dialog, null);

        dialogBuilder.setView(dialogView);

        final AlertDialog alertDialog = dialogBuilder.create();

        alertDialog.setCanceledOnTouchOutside(false);

        Button btnAcept = (Button) dialogView.findViewById(R.id.btn_acept);
        btnAcept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog.dismiss();
                //Utils.reverseRevealEffect(dialogView, alertDialog);
            }
        });

        Button btnCancel = (Button) dialogView.findViewById(R.id.btn_cancel);

        btnCancel.setVisibility(View.GONE);

        TextView text = (TextView)  dialogView.findViewById(R.id.txt_message);
        text.setText(message);

        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        alertDialog.show();

        dialogView.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {
                //Utils.revealEffect(v);
            }
        });

        }catch (Exception ex){

            Toast.makeText(context, "" + message, Toast.LENGTH_LONG).show();

        }

    }


}