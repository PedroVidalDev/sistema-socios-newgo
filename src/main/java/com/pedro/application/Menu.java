package com.pedro.application;

import com.pedro.domain.TratamentoEscolhaMenu;

import java.io.IOException;

public class Menu {

    public void showMenu() throws IOException {
        TratamentoEscolhaMenu escMenu = new TratamentoEscolhaMenu();

        System.out.println("=-=-=-=-=- SISTEMA DE SOCIOS =-=-=-=-=-=");
        System.out.print("1) Registrar novos socios \n2) Consultar socio (por documento) \n3) Editar (por carteirinha) \n4) Excluir (por carteirinha) \n5) Criar novo espaco \n6) Criar nova reserva \n7) Relatorio espacos \n8) Relatorio espacos por socio (numero de carteirinha) \nEscolha: ");

        escMenu.validarEscolha();
    }
}
