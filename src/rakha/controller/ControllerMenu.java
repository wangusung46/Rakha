package rakha.controller;

import javax.swing.JOptionPane;
import rakha.view.menu.FormLogin;
import rakha.view.menu.FormMenu;
import rakha.view.transaction.FormSell;
import rakha.view.transaction.FormUpdateSell;

public class ControllerMenu {

    public void initController(FormMenu formMenu, Integer role) {

        if (role == 1) {
            formMenu.getjMenuSallesUpdate().setVisible(false);
            formMenu.getjMenuSuper().setVisible(false);
        } else {
            formMenu.getjMenuSallesAdd().setVisible(false);
            formMenu.getjMenuOperator().setVisible(false);
        }

        formMenu.getjMenuItemAddSell().addActionListener(e -> doSell(formMenu));
        formMenu.getjMenuItemUpdateSell().addActionListener(e -> doUpdateSell(formMenu));
        formMenu.getjMenuItemLogOff().addActionListener(e -> doLogout(formMenu));
        formMenu.getjMenuItemLogOff1().addActionListener(e -> doLogout(formMenu));
    }

    private void doSell(FormMenu formMenu) {
        formMenu.getjDesktopPane1().removeAll();
        formMenu.getjDesktopPane1().updateUI();
        FormSell formSell = new FormSell();
        formMenu.getjDesktopPane1().add(formSell);
        formSell.setVisible(true);
        ControllerSell controllerSell = new ControllerSell();
        controllerSell.initController(formSell);
    }

    private void doUpdateSell(FormMenu formMenu) {
        formMenu.getjDesktopPane1().removeAll();
        formMenu.getjDesktopPane1().updateUI();
        FormUpdateSell formUpdateSell = new FormUpdateSell();
        formMenu.getjDesktopPane1().add(formUpdateSell);
        formUpdateSell.setVisible(true);
        ControllerUpdateSell controllerUpdateSell = new ControllerUpdateSell();
        controllerUpdateSell.initController(formUpdateSell);
    }

    private void doLogout(FormMenu formMenu) {
        if (JOptionPane.showConfirmDialog(null, "Yakin ingin keluar ? ", "Warning", JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
            formMenu.getjDesktopPane1().removeAll();
            formMenu.getjDesktopPane1().updateUI();
            formMenu.setVisible(false);
            FormLogin formLogin = new FormLogin();
            formLogin.setVisible(true);
            ControllerLogin controllerLogin = new ControllerLogin();
            controllerLogin.initController(formLogin);
        }

    }

}
