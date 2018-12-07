package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class KomentoStub implements Komento {
    
    TextField tuloskentta;
    int edTuloskentta;
    TextField syotekentta;
    Button nollaa;
    Button undo;
    Sovelluslogiikka sovellus;
    
    @Override
    public void suorita() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void peru() {
        try {
            int temp = Integer.parseInt(tuloskentta.getText());
            sovellus.nollaa();
            sovellus.plus(edTuloskentta);
            tuloskentta.setText("" + sovellus.tulos());
            edTuloskentta = temp;
            nollaa.disableProperty().set(sovellus.tulos() == 0);
            undo.disableProperty().set(true);
            nollaa.disableProperty().set(false);
        } catch (Exception e) {
        }
    }
    
}
