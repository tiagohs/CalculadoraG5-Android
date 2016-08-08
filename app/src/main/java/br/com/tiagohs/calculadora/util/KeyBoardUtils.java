package br.com.tiagohs.calculadora.util;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.widget.Button;

/**
 * Created by Tiago Henrique on 05/08/2016.
 */
public class KeyBoardUtils {

    public static void formatarBotoesEspeciais(Button botao, Context context, int idBotao, int idTexto) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            botao.setText(Html.fromHtml(context.getString(idTexto), Html.FROM_HTML_SEPARATOR_LINE_BREAK_DIV));
        else
            botao.setText(Html.fromHtml(context.getString(idTexto)));

    }


}
