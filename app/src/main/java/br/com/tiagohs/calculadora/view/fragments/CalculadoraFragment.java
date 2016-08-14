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
import br.com.tiagohs.calculadora.view.CalculadoraView;
import butterknife.BindView;
import butterknife.OnClick;

public class CalculadoraFragment extends BaseFragment implements CalculadoraView {


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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((App) getActivity().getApplication()).getComponent().inject(this);

        presenter.setView(this);

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
    public int getFragmentView() {
        return R.layout.calculadora_fragment;
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
    @Override
    public void onClickKeyBoard(View view) {
        presenter.onClickKeyboard(((Button) view).getText().toString());
    }

    @OnClick({R.id.btn_keyboard_apagar})
    @Override
    public void onClickOperador(View view) {
        apagarUltimaValor();
    }

}
