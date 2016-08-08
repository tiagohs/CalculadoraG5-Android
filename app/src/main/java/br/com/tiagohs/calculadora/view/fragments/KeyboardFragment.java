package br.com.tiagohs.calculadora.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

import br.com.tiagohs.calculadora.App;
import br.com.tiagohs.calculadora.R;
import br.com.tiagohs.calculadora.presenter.KeyboardPresenter;
import br.com.tiagohs.calculadora.view.InputView;
import br.com.tiagohs.calculadora.view.KeyboardView;
import butterknife.OnClick;


public class KeyboardFragment extends BaseFragment implements KeyboardView {
    private InputView mInputView;

    @Inject
    KeyboardPresenter presenter;

    public KeyboardFragment() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                                .add(R.id.fragment_operacoes_especiais, new OperacoesEspeciaisFragment())
                                .commit();

        ((App) getActivity().getApplication()).getComponent().inject(this);

        presenter.setView(this);
        mInputView = (InputFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.fragment_input);
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_keyboard;
    }

    @OnClick({R.id.btn_keyboard_1, R.id.btn_keyboard_2, R.id.btn_keyboard_3,
              R.id.btn_keyboard_4, R.id.btn_keyboard_5, R.id.btn_keyboard_6,
              R.id.btn_keyboard_7, R.id.btn_keyboard_8, R.id.btn_keyboard_9, R.id.btn_keyboard_0})
    @Override
    public void onClickKeyBoard(View view) {
        displayValor(presenter.onClickKeyboard(((Button) view).getText().toString()));
    }

    @OnClick({R.id.btn_keyboard_apagar})
    @Override
    public void onClickOperador(View view) {
        mInputView.apagarUltimaValor();
        //displayValor(presenter.onClickOperador(((Button) view).getText().toString()));
    }

    private void displayValor(String valor) {
        mInputView.displayInputPrincipal(valor);
    }

}
