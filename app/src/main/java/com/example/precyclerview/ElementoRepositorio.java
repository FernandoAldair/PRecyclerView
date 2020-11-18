package com.example.precyclerview;

import android.provider.CalendarContract;

import java.util.ArrayList;
import java.util.List;

public class ElementoRepositorio {

    List<Elemento> elementos = new ArrayList<>();

    interface Callback {
        void cuandoFinalice(List<Elemento> elementos);
    }

    ElementoRepositorio(){
        elementos.add(new Elemento("1Chuletón de ternera a la plancha, con trucos para que te quede perfecto","Hay cortes de ternera para todos los gustos (y también los bolsillos), cada uno más apropiado para unas preparaciones que para otras pero siempre ofreciendo el intenso sabor tan característico de esta carne. Personalmente me gustan los cortes con potencia de sabor y sin duda alguna el chuletón de ternera es de mis preferidos dentro…"));
        elementos.add(new Elemento("2Chuletón de ternera a la plancha, con trucos para que te quede perfecto","Hay cortes de ternera para todos los gustos (y también los bolsillos), cada uno más apropiado para unas preparaciones que para otras pero siempre ofreciendo el intenso sabor tan característico de esta carne. Personalmente me gustan los cortes con potencia de sabor y sin duda alguna el chuletón de ternera es de mis preferidos dentro…"));
        elementos.add(new Elemento("3Chuletón de ternera a la plancha, con trucos para que te quede perfecto","Hay cortes de ternera para todos los gustos (y también los bolsillos), cada uno más apropiado para unas preparaciones que para otras pero siempre ofreciendo el intenso sabor tan característico de esta carne. Personalmente me gustan los cortes con potencia de sabor y sin duda alguna el chuletón de ternera es de mis preferidos dentro…"));
        elementos.add(new Elemento("4Chuletón de ternera a la plancha, con trucos para que te quede perfecto","Hay cortes de ternera para todos los gustos (y también los bolsillos), cada uno más apropiado para unas preparaciones que para otras pero siempre ofreciendo el intenso sabor tan característico de esta carne. Personalmente me gustan los cortes con potencia de sabor y sin duda alguna el chuletón de ternera es de mis preferidos dentro…"));
        elementos.add(new Elemento("5Chuletón de ternera a la plancha, con trucos para que te quede perfecto","Hay cortes de ternera para todos los gustos (y también los bolsillos), cada uno más apropiado para unas preparaciones que para otras pero siempre ofreciendo el intenso sabor tan característico de esta carne. Personalmente me gustan los cortes con potencia de sabor y sin duda alguna el chuletón de ternera es de mis preferidos dentro…"));
        elementos.add(new Elemento("6Chuletón de ternera a la plancha, con trucos para que te quede perfecto","Hay cortes de ternera para todos los gustos (y también los bolsillos), cada uno más apropiado para unas preparaciones que para otras pero siempre ofreciendo el intenso sabor tan característico de esta carne. Personalmente me gustan los cortes con potencia de sabor y sin duda alguna el chuletón de ternera es de mis preferidos dentro…"));
    }

    List<Elemento> obtener() {
        return elementos;
    }

    void insertar(Elemento elemento, Callback callback){
        elementos.add(elemento);
        callback.cuandoFinalice(elementos);
    }

    void eleminar(Elemento elemento, Callback callback){
        elementos.remove(elemento);
        callback.cuandoFinalice(elementos);
    }

    void actulizar(Elemento elemento, float valoracion, Callback callback){
        elemento.valoracion = valoracion;
        callback.cuandoFinalice(elementos);
    }
}
