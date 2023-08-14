package com.pedro.domain;

import com.pedro.application.MenuConsultarSocio;
import com.pedro.application.MenuExcluirSocio;
import com.pedro.application.MenuRegistrarSocio;

import java.io.IOException;
import java.util.Scanner;

public class TratamentoEscolhaMenu {
    public void validarEscolha() throws IOException {
        Scanner sc = new Scanner(System.in);

        int escolhaMenu;

        try{
            escolhaMenu = sc.nextInt();
        } catch(Error e){
            escolhaMenu = -1;
        }


        switch(escolhaMenu){

            case 1:
                MenuRegistrarSocio menuRegistrar = new MenuRegistrarSocio();
                menuRegistrar.menuRegistro();
                break;

            case 2:
                MenuConsultarSocio menuConsultar = new MenuConsultarSocio();
                menuConsultar.menuConsulta();
                break;
            case 3:

                break;
            case 4:
                MenuExcluirSocio menuExcluir = new MenuExcluirSocio();
                menuExcluir.menuExclui();
                break;
            default:

                break;
        }
    }
}
