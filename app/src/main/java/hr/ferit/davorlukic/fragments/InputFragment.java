package hr.ferit.davorlukic.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class InputFragment extends Fragment implements TextWatcher {

    private String input = "...";
    private Button mSubmitButton;
    private EditText mEditText;
    private ButtonClickListener mListener;

    public static InputFragment newInstance() {
        return new InputFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEditText = view.findViewById(R.id.etEnterMessage);
        mSubmitButton = view.findViewById(R.id.btnSubmit);
        setUpListeners();
    }

    private void setUpListeners() {
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onButtonClicked(input);
            }
        });

        mEditText.addTextChangedListener(this);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ButtonClickListener){
            mListener = (ButtonClickListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement ButtonClickListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        input = s.toString();
    }
}
