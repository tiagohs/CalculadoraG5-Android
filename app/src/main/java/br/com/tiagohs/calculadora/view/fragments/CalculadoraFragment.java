package br.com.tiagohs.calculadora.view.fragments;

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
import butterknife.OnLongClick;

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

    @OnLongClick(R.id.btn_keyboard_apagar)
    public boolean apagarTudo() {
        presenter.apagarTudo(mInputPrincipal.getText().toString(), mInputSecundario.getText().toString());
        return true;
    }

    @Override
    public void apagarUltimaValor() {
        presenter.apagarUltimoValorInputPrincipal(mInputPrincipal.getText().toString());
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
            R.id.btn_keyboard_7, R.id.btn_keyboard_8, R.id.btn_keyboard_9, R.id.btn_keyboard_0})
    public void onClickKeyBoard(View view) {
        presenter.onCheckKeyboard(((Button) view).getText().toString(), mInputPrincipal.getText().toString());
    }

    @OnClick({R.id.btn_keyboard_apagar, R.id.btn_keyboard_soma, R.id.btn_keyboard_subt,
            R.id.btn_keyboard_mult, R.id.btn_keyboard_div})
    public void onClickOperador(View view) {

        switch (view.getId()) {
            case R.id.btn_keyboard_soma:
                onClickOperador(OperationType.SOMA);
                break;
            case R.id.btn_keyboard_subt:
                onClickOperador(OperationType.SUBTRACAO);
                break;
            case R.id.btn_keyboard_mult:
                onClickOperador(OperationType.MULTIPLICACAO);
                break;
            case R.id.btn_keyboard_div:
                onClickOperador(OperationType.DIVISAO);
                break;
            case R.id.btn_keyboard_apagar:
                apagarUltimaValor();
                break;
        }

    }

    private void onClickOperador(OperationType operacaoAtual) {
        String displayAtual = mInputPrincipal.getText().toString();
        String displaySub = mInputSecundario.getText().toString();

        presenter.onCheckOperation(displayAtual, displaySub, operacaoAtual);
    }

    @OnClick(R.id.btn_keyboard_igual)
    public void onClickEquals() {
        presenter.onCheckResult(mInputPrincipal.getText().toString());
    }

}
