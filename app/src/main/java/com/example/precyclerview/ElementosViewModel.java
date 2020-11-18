package com.example.precyclerview;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class ElementosViewModel extends AndroidViewModel {

    ElementoRepositorio elementoRepositorio;
    MutableLiveData<List<Elemento>> listMutableLiveData = new MutableLiveData<>();

    public ElementosViewModel(@NonNull Application application) {
        super(application);

        elementoRepositorio = new ElementoRepositorio();

        listMutableLiveData.setValue(elementoRepositorio.obtener());
    }

    MutableLiveData<List<Elemento>> obtener(){
        return listMutableLiveData;
    }
    MutableLiveData<Elemento> elementoSeleccionado = new MutableLiveData<>();

    void insert(Elemento elemento){
        elementoRepositorio.insertar(elemento, new ElementoRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Elemento> elementos) {
                listMutableLiveData.setValue(elementos);
            }
        });
    }

    void eliminar(Elemento elemento){
        elementoRepositorio.eleminar(elemento, new ElementoRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Elemento> elementos) {
                listMutableLiveData.setValue(elementos);
            }
        });
    }

    void actualizar(Elemento elemento, float valoracion){
        elementoRepositorio.actulizar(elemento, valoracion, new ElementoRepositorio.Callback() {
            @Override
            public void cuandoFinalice(List<Elemento> elementos) {
                listMutableLiveData.setValue(elementos);
            }
        });
    }
    void seleccionar(Elemento elemento){
        elementoSeleccionado.setValue(elemento);
    }

    MutableLiveData<Elemento> seleccionado(){
        return elementoSeleccionado;
    }

}
