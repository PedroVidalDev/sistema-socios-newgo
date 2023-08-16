package com.pedro.domain;

import com.pedro.application.*;

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

            // MENUS RELACIONADOS AOS SOCIOS
            case 1:
                MenuRegistrarSocio menuRegistrar = new MenuRegistrarSocio();
                menuRegistrar.menuRegistro();
                break;

            case 2:
                MenuConsultarSocio menuConsultar = new MenuConsultarSocio();
                menuConsultar.menuConsulta();
                break;
            case 3:
                MenuEditarSocio menuEditar = new MenuEditarSocio();
                menuEditar.menuEdita();
                break;
            case 4:
                MenuExcluirSocio menuExcluir = new MenuExcluirSocio();
                menuExcluir.menuExclui();
                break;

            // MENUS RELACIONADOS AOS LOCAIS
            case 5:
                MenuCriarLocal menuCriarLocal = new MenuCriarLocal();
                menuCriarLocal.menuCria();
                break;
            case 6:
                MenuCriarAgenda menuCriarAgenda = new MenuCriarAgenda();
                menuCriarAgenda.menuCria();
                break;
            case 7:
                MenuRelatorioLocais menuRelatorioLocais = new MenuRelatorioLocais();
                menuRelatorioLocais.menuRelatorio();
                break;
            case 8:
                MenuRelatorioLocaisPorSocio menuRelatorioLocalSocio = new MenuRelatorioLocaisPorSocio();
                menuRelatorioLocalSocio.menuRelatorioSocio();
                break;
            default:
                System.out.println("Opcao invalida");
                return;
        }
    }
}
