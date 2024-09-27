/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ementor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Vincenzo
 */
public class DadosEmDisco {
    private static final String ERROS_FILENAME = "ERROS.dat";
    private static ArrayList<String> erros = new ArrayList<>();
    
    private void salvarErrosEmDisco() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ERROS_FILENAME))) {
            oos.writeObject(erros);
        } catch (IOException ex) {
            System.err.println("Erro ao salvar erros: " + ex.getMessage());
        }
    }

    private void lerErrosDoDisco() {
        File arquivo = new File(ERROS_FILENAME);
        if (arquivo.exists()) {
            try (ObjectInputStream oin = new ObjectInputStream(new FileInputStream(arquivo))) {
                erros = (ArrayList<String>) oin.readObject();
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println("Erro ao ler erros: " + ex.getMessage());
            }
        }
    }

    public void adicionarErro(String novoErro) {
        erros.add(novoErro);
        salvarErrosEmDisco();
    }

}
