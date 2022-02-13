package rakha.controller;

import javax.swing.JOptionPane;
import rakha.model.admin.UserJdbc;
import rakha.model.admin.UserJdbcImplement;
import rakha.view.menu.FormLogin;
import rakha.view.menu.FormMenu;

/**
 *
 * @author Khanza
 */
public class ControllerLogin {

    private final UserJdbc userJdbc;

    public ControllerLogin() {
        userJdbc = new UserJdbcImplement();
    }

    public void initController(FormLogin formLogin) {
        formLogin.getjButtonLogin().addActionListener(e -> perLogin(formLogin));
        formLogin.getjCheckBoxShow().addActionListener(e -> perShow(formLogin));
        perShow(formLogin);
    }

    @SuppressWarnings("deprecation")
    private void perLogin(FormLogin formLogin) {
        if (!formLogin.getjTextFieldId().getText().isEmpty()) {
            if (!formLogin.getjTextFieldPassword().getText().isEmpty()) {
                if (userJdbc.login(formLogin.getjTextFieldId().getText(), formLogin.getjTextFieldPassword().getText())) {
                    JOptionPane.showMessageDialog(null, "Berhasil Login", "Success", JOptionPane.INFORMATION_MESSAGE);
                    perMenu(formLogin, userJdbc.role(formLogin.getjTextFieldId().getText()));
                } else {
                    empty(formLogin);
                    JOptionPane.showMessageDialog(null, "Gagal Login", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                empty(formLogin);
                JOptionPane.showMessageDialog(null, "Password tidak boleh kosong", "Warning", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            empty(formLogin);
            JOptionPane.showMessageDialog(null, "Username tidak boleh kosong", "Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void perMenu(FormLogin formLogin, Integer role) {
        formLogin.setVisible(false);
        FormMenu formMenu = new FormMenu();
        formMenu.setVisible(true);
        ControllerMenu controllerMenu = new ControllerMenu();
        controllerMenu.initController(formMenu, role);
    }

    private void empty(FormLogin formLogin) {
        formLogin.getjTextFieldPassword().setText("");
    }

    private void perShow(FormLogin formLogin) {
        if (formLogin.getjCheckBoxShow().isSelected()) {
            formLogin.getjTextFieldPassword().setEchoChar((char) 0);
        } else {
            formLogin.getjTextFieldPassword().setEchoChar('\u2022');
        }
    }

}
