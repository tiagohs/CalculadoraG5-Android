package br.com.tiagohs.calculadora.view.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import br.com.tiagohs.calculadora.App;
import br.com.tiagohs.calculadora.R;
import br.com.tiagohs.calculadora.presenter.CalculadoraPresenter;
import br.com.tiagohs.calculadora.util.KeyBoardUtils;
import br.com.tiagohs.calculadora.util.OperationType;
import br.com.tiagohs.calculadora.view.CalculadoraView;
import butterknife.BindView;
import butterknife.OnClick;

public class CalculadoraFragment extends BaseFragment implements CalculadoraView {
    private static final String TAG = CalculadoraFragment.class.getSimpleName();

    private static final String INPUT_PRINCIPAL_STATE = "InputPrincipal";
    private static final String INPUT_SECUNDARIO_STATE = "InputSecundario";

    @BindView(R.id.txt_input_principal)
    TextView mInputPrincipal;

    @BindView(R.id.txt_input_secundario)
    TextView mInputSecundario;

    @BindView(R.id.btn_arco_cos)
    Button btnOperacaoArcoCos;

    @BindView(R.id.btn_arco_tan)
    Button btnOperacaoArcoTan;

    @BindView(R.id.btn_arco_seno)
    Button btnOperacaoArcoSen;

    @BindView(R.id.btn_arco_sec)
    Button btnOperacaoArcoSec;

    @BindView(R.id.btn_arco_coss)
    Button btnOperacaoArcoCossec;

    @BindView(R.id.btn_arco_cot)
    Button btnOperacaoArcoCot;

    @BindView(R.id.btn_arco_elevado_base_dez)
    Button btnOperacaoElevadoBaseDez;

    @BindView(R.id.btn_raiz_y)
    Button btnOperacaoRaizY;

    @BindView(R.id.btn_elevado_x_por_y)
    Button btnOperacaoXElevadoY;

    @BindView(R.id.btn_fracao)
    Button btnOperacaoFracao;

    @Inject
    CalculadoraPresenter presenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((App) getActivity().getApplication()).getComponent().inject(this);

        presenter.setView(this);

        if (savedInstanceState != null) {
            mInputPrincipal.setText(savedInstanceState.getString(INPUT_PRINCIPAL_STATE));
            mInputSecundario.setText(savedInstanceState.getString(INPUT_SECUNDARIO_STATE));
        }

        configureTextButtons();
        }

    private void configureTextButtons() {
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoArcoCos, getContext(), R.id.btn_arco_cos, R.string.keyboard_arco_cos);
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoArcoTan, getContext(), R.id.btn_arco_tan, R.string.keyboard_arco_tan);
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoArcoSen, getContext(), R.id.btn_arco_seno, R.string.keyboard_arco_seno);
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoArcoSec, getContext(), R.id.btn_arco_sec, R.string.keyboard_arco_sec);
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoArcoCossec, getContext(), R.id.btn_arco_coss, R.string.keyboard_arco_cossec);
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoArcoCot, getContext(), R.id.btn_arco_cot, R.string.keyboard_arco_cot);
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoElevadoBaseDez, getContext(), R.id.btn_arco_elevado_base_dez, R.string.keyboard_elevado_base_dez);
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoRaizY, getContext(), R.id.btn_raiz_y, R.string.keyboard_raiz_y);
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoXElevadoY, getContext(), R.id.btn_elevado_x_por_y, R.string.keyboard_elevado_x_por_y);
        KeyBoardUtils.formatarBotoesEspeciais(btnOperacaoFracao, getContext(), R.id.btn_fracao, R.string.keyboard_fracao);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(INPUT_PRINCIPAL_STATE, mInputPrincipal.getText().toString());
        outState.putString(INPUT_SECUNDARIO_STATE, mInputSecundario.getText().toString());
    }

    @Override
    public int getFragmentView() {
        return R.layout.calculadora_fragment;
    }

    @OnClick(R.id.btn_keyboard_apagar_tudo)
    public void apagarTudo() {
        presenter.apagarTudo(mInputPrincipal.getText().toString(), mInputSecundario.getText().toString());
    }

    @OnClick(R.id.btn_keyboard_apagar)
    public void apagarUltimaValor() {
        presenter.apagarUltimoValorInputPrincipal(mInputSecundario.getText().toString());
        updateInput("");
    }

    @Override
    public void displayInputPrincipal(String valor) {
        mInputPrincipal.setText(valor);
    }

    @Override
    public void displayInputSecundario(String valor) {
        mInputSecundario.setText(valor);
    }

    @OnClick({R.id.btn_keyboard_1, R.id.btn_keyboard_2, R.id.btn_keyboard_3,
            R.id.btn_keyboard_4, R.id.btn_keyboard_5, R.id.btn_keyboard_6,
            R.id.btn_keyboard_7, R.id.btn_keyboard_8, R.id.btn_keyboard_9, R.id.btn_keyboard_0,
            R.id.btn_keyboard_parenteses_direito, R.id.btn_keyboard_parenteses_esquerdo})
    public void onClickKeyBoard(final View view) {
        updateInput(((Button) view).getText().toString());
    }

    private void updateInput(String novoInput) {
        presenter.onCheckKeyboard(novoInput, mInputSecundario.getText().toString());
    }

    @OnClick({R.id.btn_keyboard_apagar, R.id.btn_keyboard_soma, R.id.btn_keyboard_subt,
              R.id.btn_keyboard_mult, R.id.btn_keyboard_div, R.id.btn_keyboard_raiz,
              R.id.btn_keyboard_resto, R.id.btn_log,
              R.id.btn_cos, R.id.btn_arco_cos, R.id.btn_sen, R.id.btn_arco_seno,
              R.id.btn_tan, R.id.btn_arco_tan, R.id.btn_arco_cot, R.id.btn_arco_coss, R.id.btn_arco_sec})
    public void onClickOperador(View view) {
        String displaySubAtual = mInputSecundario.getText().toString();

        switch (view.getId()) {
            case R.id.btn_keyboard_soma:
                presenter.onCheckOperador(OperationType.SOMA, displaySubAtual);
                break;
            case R.id.btn_keyboard_subt:
                presenter.onCheckOperador(OperationType.SUBTRACAO, displaySubAtual);
                break;
            case R.id.btn_keyboard_mult:
                presenter.onCheckOperador(OperationType.MULTIPLICACAO, displaySubAtual);
                break;
            case R.id.btn_keyboard_div:
                presenter.onCheckOperador(OperationType.DIVISAO, displaySubAtual);
                break;
            case R.id.btn_keyboard_raiz:
                presenter.onCheckOperador(OperationType.RAIZ_QUADRADA, displaySubAtual);
                break;
            case R.id.btn_keyboard_resto:
                presenter.onCheckOperador(OperationType.RESTO, displaySubAtual);
                break;
            case R.id.btn_log:
                presenter.onCheckOperador(OperationType.LOG, displaySubAtual);
                break;
            case R.id.btn_cos:
                presenter.onCheckOperador(OperationType.COSSENO, displaySubAtual);
                break;
            case R.id.btn_arco_cos:
                presenter.onCheckOperador(OperationType.ARCO_COSSENO, displaySubAtual);
                break;
            case R.id.btn_sen:
                presenter.onCheckOperador(OperationType.SENO, displaySubAtual);
                break;
            case R.id.btn_arco_seno:
                presenter.onCheckOperador(OperationType.ARCO_SENO, displaySubAtual);
                break;
            case R.id.btn_tan:
                presenter.onCheckOperador(OperationType.TANGENTE, displaySubAtual);
                break;
            case R.id.btn_arco_tan:
                presenter.onCheckOperador(OperationType.ARCO_TANGENTE, displaySubAtual);
                break;
            case R.id.btn_arco_cot:
                presenter.onCheckOperador(OperationType.COTANGENTE, displaySubAtual);
                break;
            case R.id.btn_arco_coss:
                presenter.onCheckOperador(OperationType.COSSECANTE, displaySubAtual);
                break;
            case R.id.btn_arco_sec:
                presenter.onCheckOperador(OperationType.SECANTE, displaySubAtual);
                break;
        }

    }

    @OnClick({R.id.btn_keyboard_mudar_sinal, R.id.btn_keyboard_ponto, R.id.btn_euler,
              R.id.btn_pi})
    public void onClickOperadorEspecial(View view) {

        switch (view.getId()) {
            case R.id.btn_keyboard_mudar_sinal:
                presenter.onCheckOperadorEspecial(OperationType.CHANGE_SINAL, mInputPrincipal.getText().toString());
                break;
            case R.id.btn_keyboard_ponto:
                presenter.onCheckOperadorEspecial(OperationType.PONTO, mInputSecundario.getText().toString());
                break;
            case R.id.btn_pi:
                presenter.onCheckOperadorEspecial(OperationType.PI, mInputSecundario.getText().toString());
                break;
            case R.id.btn_euler:
                presenter.onCheckOperadorEspecial(OperationType.EULER, mInputSecundario.getText().toString());
                break;
        }
    }

    public void setErrorFormat() {
        setColors(android.R.color.holo_red_dark);
    }

    public void setSucessFormat() {
        setColors(android.R.color.black);
    }

    private void setColors(int idColor) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            mInputPrincipal.setTextColor(getResources().getColor(idColor, null));
            mInputSecundario.setTextColor(getResources().getColor(idColor, null));
        } else {
            mInputPrincipal.setTextColor(getResources().getColor(idColor));
            mInputSecundario.setTextColor(getResources().getColor(idColor));
        }
    }

    @OnClick(R.id.btn_keyboard_igual)
    public void onClickEquals() {
        presenter.onCheckResult(mInputPrincipal.getText().toString());
    }

}
