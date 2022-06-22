package g52833.sokoban.javafx;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

/**
 * Method which represents the win alert.
 *
 * @author Binh-Philippe
 */
public class AlertWin extends Alert {

    private ButtonType buttonMainMenu = new ButtonType("Revenir au menu "
            + "principal");
    private Alert alert;

    /**
     * Constructor of the class AlertWin.
     *
     * @param alertType is the type of alert.
     */
    AlertWin(AlertType alertType) {
        super(alertType);
        alert = new Alert(alertType);
        alert.setTitle("Niveau complété");
        alert.setHeaderText(null);
        alert.setContentText("Félicitations, vous avez réussi ce niveau !");
        ButtonType buttonTypeCancel = new ButtonType("Cancel",
                ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeCancel, buttonMainMenu);
        alert.getDialogPane().lookupButton(buttonTypeCancel).setVisible(false);
        alert.showAndWait();
    }

    /**
     * Method which returns the attribute main menu's button.
     *
     * @return
     */
    ButtonType getButtonMainMenu() {
        return buttonMainMenu;
    }

    /**
     * Method which tells if the main menu's button or the close button was
     * clicked.
     *
     * @return true if one was clicked else false.
     */
    boolean buttonMainMenuClicked() {
        if (alert.getResult() == buttonMainMenu || alert.getResult()
                == alert.getButtonTypes().get(0)) {
            return true;
        }
        return false;
    }

}
