package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Summa extends KomentoStub {

    public Summa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    @Override
    public void suorita() {
        try {
            edTuloskentta = sovellus.tulos();
            sovellus.plus(Integer.parseInt(syotekentta.getText()));
            tuloskentta.setText("" + sovellus.tulos());
            nollaa.disableProperty().set(sovellus.tulos() == 0);
            undo.disableProperty().set(false);
        } catch (Exception e) {
        }
    }


}
