package de.tubs.cs.ias.ampl;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.amplitude.android.Amplitude;
import com.amplitude.android.Configuration;
import com.amplitude.android.DefaultTrackingOptions;
import com.amplitude.common.Logger;
import com.amplitude.core.ServerZone;

import de.tubs.cs.ias.ampl.databinding.CreateObjectBinding;

public class A1_CreateObject extends Fragment {

    private CreateObjectBinding binding;

    private CharSequence text = "2. State: Create Object";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = CreateObjectBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonCreateObject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String EU_KEY = "APLITUDE_EU_KEY_PLACEHOLDER";
                Configuration config = new Configuration( EU_KEY, A1_CreateObject.this.getActivity().getApplicationContext());  
                config.setDefaultTracking(DefaultTrackingOptions.ALL);
                config.setServerZone(ServerZone.EU);
                Amplitude amplitude = new Amplitude(config);
                MainActivity.amplitude = amplitude;
                amplitude.getLogger().setLogMode(Logger.LogMode.DEBUG);
                binding.textviewCreateObject.setText(text + " [DONE]");
            }
        });

        binding.buttonCreateObjectNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(A1_CreateObject.this)
                        .navigate(R.id.action_CreateObject_to_InquireConsent);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}
