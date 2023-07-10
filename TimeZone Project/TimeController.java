package application;

import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.TimeZone;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class TimeController implements Initializable {
    @FXML
    private ComboBox<String> countries;

    private ObservableList<String> list = FXCollections.observableArrayList(
        "India", "Nepal", "America", "Pakistan", "Srilanka", "Australia", "China", "Russia",
        "Japan", "France", "Bangladesh", "Iraq", "United Kingdom", "Hong Kong"
    );

    @FXML
    private Label time_initialize;

    @FXML
    private Label time_result;

    private static final String DATE_FORMAT = "dd-MM-yyyy hh:mm:ss a";
    private SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
    private Date date1 = new Date();
    private String dateInString = formatter.format(date1) + "";
    private Date date;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        countries.setItems(list);
        try {
            date = formatter.parse(dateInString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        time_initialize.setText(formatter.format(date1));
    }

    public void timeDisplay() {
        String selectTimeZone = countries.getValue();
        String timeZone = getSelectTimeZone(selectTimeZone);
        SimpleDateFormat sdfAmerica = new SimpleDateFormat(DATE_FORMAT);
        TimeZone tzInAmerica = TimeZone.getTimeZone(timeZone);
        sdfAmerica.setTimeZone(tzInAmerica);
        String sDateInAmerica = sdfAmerica.format(date);
        Date dateInAmerica = null;
        try {
            dateInAmerica = formatter.parse(sDateInAmerica);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        time_result.setText(formatter.format(dateInAmerica) + "");
    }

    private String getSelectTimeZone(String selectTimeZone) {
        switch (selectTimeZone.toLowerCase()) {
            case "india":
                return "Asia/Kolkata";
            case "nepal":
                return "Asia/Kathmandu";
            case "america":
                return "America/New_York";
            case "pakistan":
                return "Asia/Karachi";
            case "srilanka":
                return "Asia/Colombo";
            case "australia":
                return "Australia/Sydney";
            case "china":
                return "Asia/Shanghai";
            case "russia":
                return "Europe/Moscow";
            case "japan":
                return "Asia/Tokyo";
            case "france":
                return "Europe/Paris";
            case "bangladesh":
                return "Asia/Dhaka";
            case "iraq":
                return "Asia/Baghdad";
            case "united kingdom":
                return "Europe/London";
            case "hong kong":
                return "Asia/Hong_Kong";
            default:
                break;
        }
        return "Asia/Kolkata";
    }
}
