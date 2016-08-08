package br.com.tiagohs.calculadora.view.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import javax.inject.Inject;

import br.com.tiagohs.calculadora.App;
import br.com.tiagohs.calculadora.R;
import br.com.tiagohs.calculadora.presenter.InputPresenter;
import br.com.tiagohs.calculadora.view.InputView;
import butterknife.BindView;

public class InputFragment extends BaseFragment implements InputView {
    @BindView(R.id.txt_input_principal)
    TextView mInputPrincipal;

    @BindView(R.id.txt_input_secundario)
    TextView mInputSecundario;

    @Inject
    InputPresenter presenter;

    public InputFragment() {

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((App) getActivity().getApplication()).getComponent().inject(this);

        presenter.setView(this);
    }

    @Override
    public int getFragmentView() {
        return R.layout.fragment_input;
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

}
