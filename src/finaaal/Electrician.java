/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finaaal;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author HP
 */
public class Electrician {

    private final IntegerProperty Serial = new SimpleIntegerProperty();
    private final StringProperty Name = new SimpleStringProperty();
    private final StringProperty Phone = new SimpleStringProperty();
    private final StringProperty Area = new SimpleStringProperty();

    public String getArea() {
        return Area.get();
    }

    public void setArea(String value) {
        Area.set(value);
    }

    public StringProperty AreaProperty() {
        return Area;
    }
    

    public String getPhone() {
        return Phone.get();
    }

    public void setPhone(String value) {
        Phone.set(value);
    }

    public StringProperty PhoneProperty() {
        return Phone;
    }
    

    public String getName() {
        return Name.get();
    }

    public void setName(String value) {
        Name.set(value);
    }

    public StringProperty NameProperty() {
        return Name;
    }
    

    public int getSerial() {
        return Serial.get();
    }

    public void setSerial(int value) {
        Serial.set(value);
    }

    public IntegerProperty SerialProperty() {
        return Serial;
    }
    
    
}
