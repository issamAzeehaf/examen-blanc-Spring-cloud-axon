package ma.azehaf.radarservice.commonapi.commands;

import lombok.Getter;

public class CreateRadarCommand extends BaseCommand<String> {
    @Getter private int vitesse;
    @Getter private double longitude;
    @Getter private double latitude;
    //constructor
    public CreateRadarCommand(String id, int vitesse, double longitude, double latitude) {
        super(id);
        this.vitesse = vitesse;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
