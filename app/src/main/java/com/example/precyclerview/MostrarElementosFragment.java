package com.example.precyclerview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.precyclerview.databinding.FragmentMostrarElementosBinding;


public class MostrarElementosFragment extends Fragment {
    private FragmentMostrarElementosBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentMostrarElementosBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        ElementosViewModel elementosViewModel = new ViewModelProvider(requireActivity()).get(ElementosViewModel.class);

        elementosViewModel.seleccionado().observe(getViewLifecycleOwner(), new Observer<Elemento>() {
            @Override
            public void onChanged(Elemento elemento) {
                binding.nombre.setText(elemento.nombre);
                binding.descripcion.setText(elemento.descripcion);
                binding.valoracion.setRating(elemento.valoracion);

                binding.valoracion.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                        if(fromUser){
                            elementosViewModel.actualizar(elemento, rating);
                        }
                    }
                 });
             }
        });
    }
}