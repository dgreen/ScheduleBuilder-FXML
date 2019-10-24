module edu.uab.dgreen.schedulebldrfxml {
    requires javafx.controls;
    requires javafx.fxml;

    opens edu.uab.dgreen.schedulebldrfxml to javafx.fxml;
    exports edu.uab.dgreen.schedulebldrfxml;
    requires java.logging;
}