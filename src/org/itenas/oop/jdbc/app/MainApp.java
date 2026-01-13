package org.itenas.oop.jdbc.app;

import org.itenas.oop.jdbc.view.LoginView;

public class MainApp {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new LoginView().setVisible(true);
        });
    }
}
