package com.example.facedetection;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import com.example.facedetection.databinding.FragmentResultdialogBinding;
public class ResultDialog  extends DialogFragment {
   FragmentResultdialogBinding binding;

    @Nullable
    @Override
    public View
    onCreateView(@NonNull LayoutInflater inflater,
                 @Nullable ViewGroup container,
                 @Nullable Bundle savedInstanceState)
    {

       binding= FragmentResultdialogBinding.inflate(inflater,container,false);

        String resultText;

        Bundle bundle = getArguments();
        assert bundle != null;
        resultText = bundle.getString(
                LCOFaceDetection.RESULT_TEXT);
        binding.resultDialogResultTextView.setText(resultText);
        binding.resultDialogOkButton.setOnClickListener(
                v -> dismiss());
        return binding.getRoot();
    }
}
