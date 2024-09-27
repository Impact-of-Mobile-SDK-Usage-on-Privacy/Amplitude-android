package de.tubs.cs.ias.ampl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.amplitude.core.events.BaseEvent;

import de.tubs.cs.ias.ausschlag.databinding.CoreFunctionalityBinding;

public class D_CoreFunctionality extends Fragment {

    private MainActivity getMainActivity() {
        return (MainActivity) this.getActivity();
    }

    private CoreFunctionalityBinding binding;
    private CharSequence text = "4. State: Basic Func";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CoreFunctionalityBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonLogEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coreFunc();
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void coreFunc() {
        MainActivity.amplitude.track("Sign Up");
        binding.coreFunctionalityInfo.setText(text + " [DONE]");
    }

    @Override
    public void onStart() {
        super.onStart();
    }

}
